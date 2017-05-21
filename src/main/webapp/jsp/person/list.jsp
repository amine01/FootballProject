<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>FIRSTNAME</td>
				<td>LASTNAME</td>
				<td>DATE OF BIRTH</td>
				<td>ACTIONS</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td><c:out value="${person.id}" /></td>
					<td><c:out value="${person.firstname}" /></td>
					<td><c:out value="${person.lastname}" /></td>
					<td><fmt:formatDate value="${person.dob}" pattern="dd-MM-YYYY" /></td>
					<td><a href="person?update&id=${person.id}">Update</a> | <a
						href="person?delete&id=${person.id}">Delete</a> | <a
						href="person?details&id=${person.id}">Details</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul>
		<li><a href="person?add">add Person</a></li>
	</ul>
</body>
</html>