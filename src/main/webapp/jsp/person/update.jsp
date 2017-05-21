<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="person" method="post">
		<ul>
			<li><input type="hidden" name="update" value="update"></li>
			<li><input type="hidden" name="id" value="${person.id}"></li>
			<li>FirstName: <input type="text" name="firstname"
				value="${person.firstname}"></li>
			<li>LastName: <input type="text" name="lastname"
				value="${person.lastname}"></li>
			<fmt:formatDate value="${person.dob}" var="fmtdate" pattern="dd-MM-YYYY"/>
			<li>DateOfBirth: <input type="text" name="dob" value="${fmtdate}">"Ex:
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