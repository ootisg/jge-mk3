package engine;

public class RenderLoop implements Runnable {
	
	//The main GameWindow
	private GameWindow mainWindow;
	
	//Target framerate for rendering
	private int targetFramerate = 60;
	
	/**
	 * Default constructor
	 */
	public RenderLoop () {
		
	}
	
	/**
	 * Gets the window used to display the game.
	 * @return the main (usually only) GameWindow object
	 */
	public GameWindow getMainWindow () {
		return mainWindow;
	}
	
	/**
	 * Sets the target framerate for rendering. Default is 60fps.
	 * @param framerate the framerate to use, in frames per second
	 */
	public void setTargetFramerate (int framerate) {
		targetFramerate = framerate;
	}
	
	/**
	 * Gets the target framerate for rendering. Default is 60fps, but it's configurable.
	 * @return framerate the current target framerate, in frames per second
	 */
	public int getTargetFramerate () {
		return targetFramerate;
	}
	
	/**
	 * Init for RenderLoop; called before loop()
	 */
	private void init () {
		mainWindow = new GameWindow ();
	}
	
	/**
	 * Loop for RenderLoop
	 */
	private void loop () {
		
		while (true) {
			
			//Store the current time
			long startTime = System.nanoTime ();
			
			//Render to the main window
			mainWindow.refresh ();
			
			//Compute the proper wait time
			long frameDurationNs = 1000000000L / targetFramerate; //1 billion ns in one second
			long frameTarget = startTime + frameDurationNs;
			if (System.nanoTime () < frameTarget) {
				long frameNs = frameTarget - System.nanoTime ();
				long frameMs = frameNs / 1000000; //1 million ns in one ms
				long remainingNs = frameNs - (frameMs * 1000000); //Compute remaining ns to sleep for
				
				//Sleep until the target frame time
				//TODO replace this with a timer for consistency and performance
				try {
					if ((frameMs - 4) > 0) {
						Thread.sleep (frameMs - 4);
					}
				} catch (InterruptedException e) {
					//Do nothing here
				}
				while (System.nanoTime () < frameTarget) {} //Spinning loop for accuracy
				
			}
			
		}
		
	}
	
	@Override
	public void run () {
		init ();
		loop ();
	}
	
}
