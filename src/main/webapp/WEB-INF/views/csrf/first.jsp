<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	first: get method는 csrf가 작동하지 않는다. 
	<ul>
		<li><a href="<c:url value="/users/auth/second"/>">second</a></li>

	</ul>

	<form action="<c:url value="/users/auth/second"/>" method="get">
		<input type="text" name="${_csrf.parameterName}" value="${_csrf.token}" /> <input type="submit" value="check" />
	</form>

</body>
</html>