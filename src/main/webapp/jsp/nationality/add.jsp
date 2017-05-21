<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="nationality" method="post">
		<ul>
			<li><input type="hidden" name="add" value="add"></li>
				<li><input type="hidden" name="person_id" value="${person_id}"></li>
			<li>Nationality	: <input type="text" name="nationality"></li>
			<li><input type="submit"></li>
		</ul>
	</form>
</body>
</html>