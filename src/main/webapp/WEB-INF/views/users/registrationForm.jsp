<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="submitRegistrationUrl" value="/account/register" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>New user registration</title>
</head>
<body>
	<h1>New user registration</h1>

	<form:form cssClass="main" action="${submitRegistrationUrl}" modelAttribute="account">
		<p>All fields are required.</p>

	<div class="fieldLabel yui-u first">Username:<form:input path="username" cssClass="short" /></div>
	<div class="fieldLabel yui-u first">Password:<form:password path="password" showPassword="false" cssClass="short" /></div>
	<div class="fieldLabel yui-u first">Confirm password:<form:password path="confirmPassword" showPassword="false" cssClass="short" /></div>
	<div class="fieldLabel yui-u first">First name:<form:input path="firstName" cssClass="short" /></div>
	<div class="fieldLabel yui-u first">Last name:<form:input path="lastName" cssClass="short" /></div>
	<div class="fieldLabel yui-u first">E-mail address:<form:input path="email" cssClass="medium" /></div>
	<div class="yui-u first">
		<form:checkbox id="marketingOk" path="marketingOk" />
		<label for="marketingOk">Please send me product updates by e-mail. I can unsubscribe at any time.</label>
	</div>
	<div class="yui-u first">
		<form:checkbox id="acceptTerms" path="acceptTerms" />
		<label for="acceptTerms">I accept the terms of use.</label>
	</div>
	<div class="yui-u first"><input type="submit" value="Register"></input></div>
	</form:form>
</body>
</html>
