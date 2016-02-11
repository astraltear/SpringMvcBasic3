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

	
## CSRF FILTER
		GET, HEAD, TRACE, OPTIONS 메소드 일 때에는 동작하지 않습니다.
		csrf자체가 데이타가 변경될 때 발생하는 문제를 예방하는 형태이기 때문에 get메소드는 조회 형태로 생각하기 때문에 무시합니다.
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
	'/'로 시작하고 '/*'로 끝나는 url-pattern은 경로 매핑을 위해서 사용된다.
	'*.'로 시작하는 url-pattern은 확장자에 대한 매핑을 할 때 사용된다.
	"/"만 정의한 경우 디폴트 서블릿을 의미한다.
	나머지 다른 문자열을 정확한 매핑을 위해서 사용된다.
	
	<default-servlet-handler/>