spring-webmvc 4.2.2.RELEASE

HiddenHttpMethod
CSRF Filter
interceptor
sitemesh


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
	preHandle : Controller 가 수행되기 전에 실행됩니다. 여기서는 이후 Controller를 수행할지 여부를 boolean 으로 return 하게 됩니다.
	postHandle : Controller 가 수행된후 View 를 호출하기 전 상태입니다.
	afterCompletion : View 작업까지 완료된 후 호출 됩니다. responseBody 를 이용할 경우 UI 에 이미 값을 전달후 해당 부분이 호출됩니다.

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
	
	  테스트 방법
	  호출 /SpringMvcBasic3/interceptorLogin/board_write  
	  결과 /SpringMvcBasic3/interceptorLogin/login 컨트롤러 페이지로 가는지확인
	  
	  호출 /SpringMvcBasic3/interceptorLogin/setSession  
	  결과 /SpringMvcBasic3/interceptorLogin/board_write    
	  
## interceptor with annotaion
	/bothInterceptor/logging는 로깅 인터셉터를 수행시키고 /bothInterceptor/noLogging 는 로깅 인터셉터를 수행 안함
	물론 exclude-mapping을 여러개 등록하면 되지만 로그인이 필요하지 않은 컨트롤러가 생길때마다 exclude-mapping을 선언
	임의의 어노테이션을 생성하여 로깅이 필요한  컨트롤러의 메소드에 어노테이션을 붙이고, 어노테이션 유무를 인터셉터에서 확인
	
## sitemesh
	<dependency>
		<groupId>opensymphony</groupId>
		<artifactId>sitemesh</artifactId>
		<version>2.4.2</version>
	</dependency>
		
		
	<!-- sitemesh filter -->
	<filter>
		<filter-name>sitemesh</filter-name>
		<filter-class>com.opensymphony.module.sitemesh.filter.PageFilter</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>sitemesh</filter-name>
		<url-pattern>/sitemeshlayout/*</url-pattern>
	</filter-mapping>
	
	WEB-INF/decorators.xml
	WEB-INF/sitemesh.xml
	
## view-controller
	<view-controller path="/account/registration_ok.html" view-name="users/registrationOk" />
	
## bean에서 RequestMapping하기
	<context:component-scan base-package="com.astraltear.springmvcbasic3" /> 부분 주석
	
	spring xml 파일에 bean을 직접 등록한다.
	Controller에는 RequestMapping을 설정하지 않는다. 
	<beans:bean name="/nominee/*"
		class="com.astraltear.springmvcbasic3.controller.NomineeController"
		p:thanksViewName="nominee/thanks"/>