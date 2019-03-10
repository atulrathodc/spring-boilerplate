<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Save Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>

	<springForm:form method="POST" commandName="employee"
		action="saveact">
		<table>
			<tr>
				<td>Name:</td>
				<td><springForm:input path="firstName" /></td>
				<td><springForm:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><springForm:input path="age" /></td>
				<td><springForm:errors path="age" cssClass="error" /></td>
			</tr>
				<tr>
				<td>salary:</td>
				<td><springForm:input path="salary" /></td>
				<td><springForm:errors path="salary" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Save Employee"></td>
			</tr>
		</table>

	</springForm:form>

</body>
</html>