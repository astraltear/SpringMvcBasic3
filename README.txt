spring-webmvc 4.2.2.RELEASE

##Hidden Http Method
	<filter>
		<filter-name>httpMethodFilter</filter-name>
		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>httpMethodFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	<form action="<c:url value="httpmethodTest"/>" method="post">
		<input type="text" name="_method" value="put"> 
		<input type="submit" />
	</form>	
