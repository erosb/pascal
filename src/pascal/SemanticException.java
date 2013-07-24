package pascal;

public class SemanticException extends RuntimeException {
	
	private final int lineNumber;

	public SemanticException(String message, int lineNumber) {
		super(message);
		this.lineNumber = lineNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	
}
