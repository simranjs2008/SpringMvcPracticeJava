<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Detail Form</title>
	
</head>

<body>
	<div>
		<h1>Fill in contact Details</h1>

		<form:form action="processForm" modelAttribute="user" method="post">

            Email:
            <form:input path="name" />
            <form:errors path="name" cssClass="error" />

			<br>
			<br> user name:
            <form:input path="email" />
			<form:errors path="email" cssClass="error" />


			<br>
			<br>

			<input type="submit" value="Submit" />

		</form:form>
	</div>
</body>
</html>