package pascal.symbol;

import java.util.Collections;
import java.util.List;

public class FunctionSignature {
	
	private final String name;

	private final List<Parameter> params;

	public FunctionSignature(String name, List<Parameter> params) {
		super();
		this.name = name;
		this.params = Collections.unmodifiableList(params);
	}

	public String getName() {
		return name;
	}

	public List<Parameter> getParams() {
		return params;
	}
	
	public Parameter getParam(String name) {
		for (Parameter p: params) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		throw new IllegalArgumentException("no parameter found with name [" + name + "]");
	}
	
	
}
