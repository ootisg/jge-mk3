package engine;

public class MainInit {
	
	//Loop objects
	private static GameLoop gameLoop;
	private static RenderLoop renderLoop;
	
	//Loop threads
	private static Thread gameThread;
	private static Thread renderThread;
	
	public static void main (String[] args) {
		
		//Initialize the GameLoop and RenderLoop
		gameLoop = new GameLoop ();
		renderLoop = new RenderLoop ();
		
		//Create threads for GameLoop and RenderLoop
		gameThread = new Thread (gameLoop);
		renderThread = new Thread (renderLoop);
		
		//Run GameLoop on a new thread
		gameThread.start ();
		
		//Run RenderLoop on the current thread
		renderThread.run ();
		
		//Only returns if RenderLoop stops
		return;
		
	}
	
	static GameLoop getGameLoop () {
		return gameLoop;
	}
	
	static RenderLoop getRenderLoop () {
		return renderLoop;
	}
	
}
