package pascal;

public class Type {
	
	public static final Type INTEGER = new Type("integer");
	
	public static final Type STRING = new Type("string");
	
	public static final Type BOOLEAN = new Type("boolean");
	
	private final String name;

	public Type(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

}
