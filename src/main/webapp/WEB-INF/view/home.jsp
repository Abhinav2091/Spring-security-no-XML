<!-- form tag uri -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- jstl suport -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- securty support for display username and role -->
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>Welcome to the luv2code company home page!</p>
	<hr>

	<hr>
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Roles:
		<security:authentication property="principal.authorities" />
	</p>
	<hr>

<!-- link based on roles -->
<ul>
<!-- use authorized role to show or hide content -->
<security:authorize access="hasRole('MANAGER')">
<li>
<a href="${pageContext.request.contextPath}/manager"> Manager Role</a>
</li>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<li>
<a href="${pageContext.request.contextPath}/system"> Admin Role</a>
</li>
</security:authorize>
</ul>

	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>
