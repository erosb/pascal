program funct

var a: integer, b: integer;

integer abs(integer x)
begin
	if x >= 0 then
		return x;
	end if
	return x * -1;
end

begin
	a := -5;
	a := abs(a);
	b := refGlobScope(3);
end

integer refGlobScope(integer y)
begin
	return y * a;
end