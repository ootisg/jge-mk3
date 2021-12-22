package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8537802541411424289L;
	
	//Default window dimensions
	public static final int DEFAULT_WIDTH = 1280;
	public static final int DEFAULT_HEIGHT = 720;
	
	//Resize modes
	public static final int RESIZE_MODE_SCALE = 0;
	
	//Miscellaneous GameWindow parameters
	private int resizeMode;
	private Color clearColor;
	
	//The image buffer for this GameWindow
	private BufferedImage buffer;
	
	/**
	 * GameWindow constructor
	 */
	public GameWindow () {
		
		//Makes sure the game exits when the window closes
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				System.exit (0);
			}
		});
		
		//Size the window
		getContentPane ().setPreferredSize (new Dimension (DEFAULT_WIDTH, DEFAULT_HEIGHT));
		pack ();
		
		//Set parameters to defaults
		resizeMode = RESIZE_MODE_SCALE;
		clearColor = Color.LIGHT_GRAY;
		
		//Create the content buffer
		buffer = new BufferedImage (DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		
		//Show the window
		setVisible (true);

	}
	
	/**
	 * Draws the buffer to the window, then clears the frame buffer.
	 */
	public void refresh () {

		//Render to the window
		if (resizeMode == RESIZE_MODE_SCALE) {
			getContentPane ().getGraphics ().drawImage (buffer, 0, 0, getContentPane ().getWidth (), getContentPane ().getHeight (), 0, 0, buffer.getWidth (), buffer.getHeight (), null);
		}
		
		//Clear the buffer
		Graphics g = buffer.getGraphics ();
		g.setColor (clearColor);
		g.fillRect (0, 0, buffer.getWidth (), buffer.getHeight ());
		
	}
	
	/**
	 * Gets the graphics used to draw to this GameWindow
	 * @return a Graphics2D object that can be used to render to the GameWindow
	 */
	public Graphics2D getBufferGraphics () {
		return (Graphics2D)buffer.createGraphics ();
	}
	
	/**
	 * Gets the output resolution of this window
	 * @return a Dimension object containing the resolution dimensions of this GameWindow
	 */
	public Dimension getOutputResolution () {
		return new Dimension (buffer.getWidth (), buffer.getHeight ());
	}
	
	/**
	 * Sets the output resolution of this window to the given Dimension.
	 * @param d the Dimension to use
	 */
	public void setOutputResolution (Dimension d) {
		buffer = new BufferedImage (d.width, d.height, BufferedImage.TYPE_3BYTE_BGR);
	}

}
