package pascal;

public class Value {

	protected final Type type;
	protected final String value;

	public Value(Type type, String value) {
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return type + ": " + value;
	}

}