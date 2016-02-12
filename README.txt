spring-webmvc 4.2.2.RELEASE

HiddenHttpMethod
CSRF Filter
interceptor


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

	
## CSRF FILTER
		GET, HEAD, TRACE, OPTIONS 는 CSRF필터가 적용되지 않는다. 
		<!-- Security (used for CSRF protection only) -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>4.0.1.RELEASE</version>
		</dependency>
		
		<!-- CSRF Filter -->
		<bean id="csrfFilter" class="org.springframework.security.web.csrf.CsrfFilter">
			<constructor-arg>
				<bean class="org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository" />
			</constructor-arg>
		</bean>
		<bean id="requestDataValueProcessor" class="org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor" />
		
		
		<!--  CSRF Filter -->
		<filter>
			<filter-name>csrfFilter</filter-name>
			<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>csrfFilter</filter-name>
			<url-pattern>/auth/*</url-pattern>
		</filter-mapping>
		
## web.xml url-pattern
	http://jinwooe.blogspot.kr/2014/05/servlet-mapping-url-pattern-vs.html
	'/' 로 시작해서 '/*'로 끝나는 문자열을 사용할 수 있습니다.
	'*'.prefix 형태의 확장자를 사용할 수 있습니다.
	빈 문자열("")은 특별한 URL 패턴인데 application의 context root에 매핑이 됩니다. 
	예를 들면 "http://host:port/<contextroot>/에 매핑이 되고, path info는 '/' 됩니다. 이 때 servlet path와 context path는 빈 문자열("")이 됩니다.
	'/' 만 있는 문자열은 default servlet을 의미합니다. 이 때 servlet path는 request URI에서 context path를 제외한 문자열이 되고 path info는 null 입니다.
	url-pattern에 의해 여러개의 servlet이 매핑이 되면 deploy가 실패해야 합니다.
	
	<default-servlet-handler/>
	
## login interceptor demo

	<interceptors>
		<interceptor>
			<mapping path="/interceptorLogin/board_write" />
			<beans:bean class="com.astraltear.springmvcbasic3.interceptor.BoardInterCeptor" />
		</interceptor>
		<!-- 추가로 여러개의 인터셉터 설정 가능 
		<interceptor> 
			<mapping path="/admin/board_write"/> 
				<bean class="com.spring.interceptor.AdminInterCeptor"/> 
		</interceptor>
		 -->
	</interceptors>
	