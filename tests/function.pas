program funct

var a: integer;

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
end