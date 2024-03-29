<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Custom Login</title>
<style>
.failed{
color:red;
}
</style>
</head>
<body>
	<h3>My Custom Login Page</h3>

<!-- authenticateTheUser provided by spring  so name need to be mention below -->
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<!-- Check for login error -->
		<c:if test="${param.error != null}">
		<i class="failed">Sorry! You entered invalid username/password </i>
		</c:if>
		

		<p>
			User name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />
	</form:form>

</body>

</html>