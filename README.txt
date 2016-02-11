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
		GET, HEAD, TRACE, OPTIONS �޼ҵ� �� ������ �������� �ʽ��ϴ�.
		csrf��ü�� ����Ÿ�� ����� �� �߻��ϴ� ������ �����ϴ� �����̱� ������ get�޼ҵ�� ��ȸ ���·� �����ϱ� ������ �����մϴ�.
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
	'/'�� �����ϰ� '/*'�� ������ url-pattern�� ��� ������ ���ؼ� ���ȴ�.
	'*.'�� �����ϴ� url-pattern�� Ȯ���ڿ� ���� ������ �� �� ���ȴ�.
	"/"�� ������ ��� ����Ʈ ������ �ǹ��Ѵ�.
	������ �ٸ� ���ڿ��� ��Ȯ�� ������ ���ؼ� ���ȴ�.
	
	<default-servlet-handler/>