package hunter;

public class GameOverException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameOverException() {
		System.err.println("Loser !");
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
