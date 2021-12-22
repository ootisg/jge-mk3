package engine;

public class GameLoop implements Runnable {
	
	//The target Ticks Per Second
	private int targetTPS = 60;
	
	/**
	 * Init for MainLoop
	 */
	private static void init () {
		
	}
	
	/**
	 * Loop for MainLoop
	 */
	private void loop () {
		
		while (true) {
			
			//Store the current time
			long startTime = System.nanoTime ();
			
			//Run the game logic
			//TODO something
			
			//Compute the proper wait time
			long frameDurationNs = 1000000000L / targetTPS; //1 billion ns in one second
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
	
	/**
	 * Gets the target "ticks", or steps per second. Game logic will update at this rate when possible. Default is 60TPS.
	 * @return the game logic update rate in ticks per second
	 */
	public int getTargetTPS () {
		return targetTPS;
	}
	
	/**
	 * Sets the target "ticks", or steps per second to the given value. Game logic will update at this rate when possible. Default is 60TPS.
	 * @param tps the new game logic update rate in ticks per second
	 */
	public void setTargetTPS (int tps) {
		targetTPS = tps;
	}

	@Override
	public void run () {
		init ();
		loop ();
	}
	
}
