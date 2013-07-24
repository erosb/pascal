package pascal.symbol;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SymbolTable implements Map<String, Variable>{
	
	private Map<String, Variable> storage = new HashMap<String, Variable>();
	
	private SymbolTable parent;
	
	public SymbolTable(SymbolTable parent) {
		super();
		this.parent = parent;
	}

	@Override
	public int size() {
		return storage.size() + (parent == null ? 0 : parent.size());
	}

	@Override
	public boolean isEmpty() {
		return storage.isEmpty() && (parent == null ? true : parent.isEmpty());
	}

	@Override
	public boolean containsKey(Object key) {
		return storage.containsKey(key) || (parent == null ? false : parent.containsKey(key));
	}

	@Override
	public boolean containsValue(Object value) {
		return storage.containsValue(value) || (parent == null ? false : parent.containsValue(value));
	}

	@Override
	public Variable get(Object key) {
		Variable rval = storage.get(key);
		if (rval == null && parent != null) {
			rval = parent.get(key);
		}
		return rval;
	}
	
	public void add(Variable var)  {
		put(var.getName(), var);
	}

	@Override
	public Variable put(String key, Variable value) {
		if ( ! key.equals(value.getName())) {
			throw new IllegalArgumentException("key must be the same as the name of the variable");
		}
		return storage.put(key, value);
	}

	@Override
	public Variable remove(Object key) {
		return storage.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Variable> m) {
		storage.putAll(m);
	}

	@Override
	public void clear() {
		storage.clear();
	}

	@Override
	public Set<String> keySet() {
		Set<String> rval = new HashSet<String>();
		rval.addAll(storage.keySet());
		if (parent != null) {
			rval.addAll(parent.keySet());
		}
		return rval;
	}

	@Override
	public Collection<Variable> values() {
		Collection<Variable> rval = new ArrayList<Variable>(size());
		rval.addAll(storage.values());
		if (parent != null) {
			rval.addAll(parent.values());
		}
		return rval;
	}

	@Override
	public Set<java.util.Map.Entry<String, Variable>> entrySet() {
		Set<java.util.Map.Entry<String, Variable>> rval = new HashSet<Map.Entry<String, Variable>>(size());
		rval.addAll(storage.entrySet());
		if (parent != null) {
			rval.addAll(parent.entrySet());
		}
		return rval;
	}

	public SymbolTable getParent() {
		return parent;
	}

}
