package pascal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pascal.parser.PascalBaseVisitor;
import pascal.parser.PascalParser;
import pascal.parser.PascalParser.FunctionContext;
import pascal.symbol.FunctionSignature;
import pascal.symbol.Parameter;

public class FunctionSignatureLoader extends PascalBaseVisitor<FunctionSignature> {
	
	private final Map<String, Type> types;
	
	public FunctionSignatureLoader(Map<String, Type> types) {
		super();
		this.types = types;
	}

	@Override
	public FunctionSignature visitFunction(FunctionContext ctx) {
		String fnName = ctx.fnName.getText();
		final List<Parameter> params = new ArrayList<Parameter>(ctx.formParList().formPar().size());
		for (PascalParser.FormParContext parCtx: ctx.formParList().formPar()) {
			Type type = types.get(parCtx.type.getText());
			params.add(new Parameter(parCtx.name.getText(), type));
		}
		return new FunctionSignature(fnName, params);
	}
	
}
