package pascal.symbol;

import java.util.HashMap;
import java.util.Map;

import pascal.parser.PascalParser;
import pascal.parser.PascalParser.FunctionContext;

public class FunctionTable {
	
	private Map<FunctionSignature, PascalParser.FunctionContext> functions;
	
	public FunctionTable(Map<FunctionSignature, FunctionContext> functions) {
		super();
		this.functions = functions;
	}

	public PascalParser.FunctionContext get(FunctionSignature signature) {
		PascalParser.FunctionContext rval = functions.get(signature);
		if (rval == null) {
			throw new IllegalArgumentException("function [" + signature + "] not found");
		}
		return rval;
	}

}
