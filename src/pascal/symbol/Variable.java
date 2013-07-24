package pascal.symbol;

import pascal.Type;
import pascal.Value;

public class Variable extends Value {
	
	private final String name;
	
	public Variable(String name, Type type, String value) {
		super(type, value);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
