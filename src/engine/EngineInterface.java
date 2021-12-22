package engine;

import java.awt.Dimension;
import java.awt.Graphics2D;

public class EngineInterface {
	
	//Window-related methods
	
	/**
	 * Gets the main GameWindow object used for rendering
	 * @return the main GameWindow
	 */
	public static GameWindow getMainWindow () {
		return MainInit.getRenderLoop ().getMainWindow ();
	}
	
	/**
	 * Gets a graphics context used to draw to the main window
	 * @return a Graphics2D context for the main window's buffer
	 */
	public static Graphics2D getRenderGraphics () {
		return MainInit.getRenderLoop ().getMainWindow ().getBufferGraphics ();
	}
	
	/**
	 * Gets the output resolution of the main window
	 * @return a Dimension object describing the main window's output resolution
	 */
	public static Dimension getOutputResolution () {
		return MainInit.getRenderLoop ().getMainWindow ().getOutputResolution ();
	}
	
	/**
	 * Sets the main window's output resolution to the given width and height
	 * @param width the new horizontal resolution
	 * @param height the new vertical resolution
	 */
	public static void setOutputResolution (int width, int height) {
		MainInit.getRenderLoop ().getMainWindow ().setOutputResolution (new Dimension (width, height));
	}
	
	//Misc. methods
	
	/**
	 * Gets the target framerate, in frames per second. The game will run at this framerate or slower. Default is 60fps.
	 */
	public static int getTargetFramerate () {
		return MainInit.getRenderLoop ().getTargetFramerate ();
	}
	
	/**
	 * Sets the target framerate to the given value. The game will run at this framerate or slower.
	 * @param fps the target framerate to use, in frames per second
	 */
	public static void setTargetFramerate (int fps) {
		MainInit.getRenderLoop ().setTargetFramerate (fps);
	}

}
