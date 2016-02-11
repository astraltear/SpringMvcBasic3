<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<ul>
		<li>post</li>
		<li>
			<form action='<c:url value="/methodfilter/httpmethodTest"/>' method="post">
				<input type="submit" />
			</form>
		</li>
		<li>put</li>
		<li>
			<form action="<c:url value="/methodfilter/httpmethodTest"/>" method="post">
				<input type="text" name="_method" value="put"> <input type="submit" />
			</form>
		</li>
		<li>delete</li>
		<li>

			<form action="<c:url value="/methodfilter/httpmethodTest"/>" method="post">
				<input type="text" name="_method" value="delete"> <input type="submit" />
			</form>
		</li>
	</ul>

	<ul>
		<li>Non post</li>
		<li>
			<form action='<c:url value="/NonMethodfilter/httpmethodTest"/>' method="post">
				<input type="submit" />
			</form>
		</li>
		<li>Non put</li>
		<li>
			<form action="<c:url value="/NonMethodfilter/httpmethodTest"/>" method="post">
				<input type="text" name="_method" value="put"> <input type="submit" />
			</form>
		</li>
		<li>Non delete</li>
		<li>

			<form action="<c:url value="/NonMethodfilter/httpmethodTest"/>" method="post">
				<input type="text" name="_method" value="delete"> <input type="submit" />
			</form>
		</li>
	</ul>
	
	<ul>
		<li><a href="<c:url value="/users/auth/first"/>">csrf1</a></li>
	</ul>

</body>
</html>
