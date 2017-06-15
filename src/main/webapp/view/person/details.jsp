<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>Id : <c:out value="${person.id}" /></li>
		<li>FirstName : <c:out value="${person.firstname}" /></li>
		<li>LastName : <c:out value="${person.lastname}" /></li>
		<li>DateOfBirth : <fmt:formatDate value="${person.dob}" pattern="dd-MM-YYYY"/></li>

	</ul>

	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>NATIONALITY</td>
				<td>ACTIONS</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nationalities}" var="nationality">
				<tr>
					<td><c:out value="${nationality.id}" /></td>
					<td><c:out value="${nationality.nationality}" /></td>
					<td><a href="nationality?delete&id=${nationality.id}">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul>
		<li><a href="nationality?add&person_id=${person.id}">New
				Nationality</a></li>
		<li><a href="persons">Persons</a></li>
	</ul>
</body>
</html>