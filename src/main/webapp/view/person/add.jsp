<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="person" method="post">
		<ul>
			<li><input type="hidden" name="add" value="add"></li>
			<li>FirstName: <input type="text" name="firstname"></li>
			<li>LastName: <input type="text" name="lastname"></li>
			<li>DateOfBirth: <input type="text" name="dob">"Ex:
				24-06-1985"
			</li>
			<li><input type="submit"></li>
		</ul>
	</form>
	<ul>
		<li><a href="persons">persons</a></li>
	</ul>
</body>
</html>