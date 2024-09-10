### 스프링이란

Java 기술을 더 쉽게 사용 할 수 있게 해주는 오픈소스 프레임워크 입니다.
핵심 패러다임으로는 DI, AOP, PSA 가 3대 요소로 꼽힙니다.

DI 는 IOC 컨테이너에 자바 객체를 인스턴스화 하여 의존관계를 맺는 객체를 개발자가 아닌 스프링이 주입하는 방식입니다.

AOP 는 로깅 트랜잭션 보안 요소등 여러 모듈에서 공통적으로 사용하는 기능을 분리 관리 할 수 있는 기능을 제공합니다.

PSA 추상화 기술을 사용해 기술을 내부에 숨기고 개발자에게 편의성을 제공합니다. Spring Mvc 의 핵심 기술인
DispatcherServlet 이 그 예이며 Transaction 어노테이션의 구현체 또한 PSA 의 예입니다. JPA 의
실 구현체인 하이버네이트 도 이헤 속합니다.

### 스프링부트 동작 과정

1. SpringBoot SpringApplication.run 을 통해 실행
2. application.properties 파일을 읽어서 설정값을 Environment 에 저장
3. Spring Application 은 Bean 으로 등록한 객체에 대해 ComponentScan 을 수행함
4. Auto Configuration 으로 설정을 스캔하여 Bean 으로 등록 
5. Web Server 인 내장 톰켓 기동
6. Application Context 초기화 이후 Application Event 리스너 호출
7. HTTP 요청이 있을 경우 DispatcherServlet 객체가 등록되며 요청 처리 준비가 완료 됨.

### 스프링 프레임워크 동작 과정

스프링 4.0 이상부터는 web.xml 을 사용하지 않고 WebApplicationInitializer 를 사용합니다.
WebApplicationInitializer 는 Servlet 3.0 스펙을 구현한 클래스로서, 스프링 컨테이너를 초기화 하는 클래스입니다.

