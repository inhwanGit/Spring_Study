## 📚 Spring_Study
### 🗓️ Day1 😁
##### - Spring 맛보기 -> Mysql DB을 이용한 아주 간단한 내용출력


Spring 프레임워크

## 등장이유
-> 스프링 프레임워크가 나오기전에 EJB(Enterprise JavaBeans)이 있었다.
->EJB -> 애플리케이션 작성을 쉽게 해준다. (미들웨어 보다 쉽다.)
-> EJB -> 선언적 프로그래밍 모델 -> (선언적 프로그래밍)설정만 해두면 자동으로 해준다.
-> 트랜잭션, 보안,  분산컴퓨팅 이런것들을 굉장히 쉽게 할 수 있다.
-> EJB 구동시킬 수 있는 Web Application Server가 등장
-> EJB는 개발도 힘들고, 배포도 힘들었다.

## Bean이란
-> Java에서 인스턴스 생성
     -> 프로그래머가 직접 인스턴스를 생성함
	‘’’
	Book book = new Book();
	‘’’
-> Bean은 컨테이너가 관리하는 객체
	-> 객체의 생명주기를 컨테이너가 관리한다.
	-> 객체를 싱글턴으로 만들것인지, 프로토타입으로 만들것인지

## Spring에 핵심기능
-> 관점지향 컨테이너
	-> Bean을 생성, 관리한다.
	-> 관점지향(AOP, aspect-oriented programming)

## Bean을 만들때 규칙
-> 기본 생성자가 있어야 한다.(기본 생성자가 있어야 클래스로드을 이용해서 인스턴스를 만들기가 편하다.)

## 객체를 싱글턴으로 생성해주고, 자기자신도 싱글턴인 ApplicationContext
-> 컨테이너 역할을 수행한다.
-> Spring이 제공하는 컨테이너는 이것보다 훨씬 복잡한 일을 한다.

## ApplicationContext
-> ApplicationContext는 다양한 인터페이스를 상속 받고 있다.
-> 스프링 컨테이너의 핵심 인터페이스!
‘’’
org.springframework.context
Interface ApplicationContext
‘’’
-> 그중에서도 BeanFactory도 ApplicationContext는 상속받는다.
‘’’
org.springframework.beans.factory
Interface BeanFactory
‘’’

## ApplicationContext를 구현하고 있는 대표적인 인터페이스
-> ClASSPATH에서 XML설정파일을 읽어들여 동작한다.
‘’’
org.springframework.context.support
Class ClassPathXmlApplicationContext
‘’’

## 스피링 프레임워크의 핵심 모듈
-> Core Container 부분이 가장 핵심
-> Gradle에서 아래의 라이브러리를 추가한다.

implementation("org.springframework", "spring-context", "6.1.3")

# MyService & MyDao
-> 프로그래머가 직접 인스턴스를 생성하고 주입하는 방법
-> setter 주입
‘’’
MyService myService = new MyService();
MyDao myDao = new MyDao();
myService.setMyDao(myDao);
‘’’
-> 생성자에 주입
‘’’
MyService myService = new MyService(new Dao());
‘’’

# Spring 설정으로 주입
‘’’
MyService myService = new MyService();
MyDao myDao = new MyDao();
myService.setMyDao(myDao);
‘’’
같다
‘’’
<bean id="myService" class="org.example.spring.componet.Myservice">
    <!--setMyDao-->
    <property name="myDao" ref="myDao"></property>
</bean>
<bean id="myDao" class="org.example.spring.componet.MyDao"></bean>
‘’’

# AnnotationConfigApplicationContext
-> Spring 3.0부터 등장
-> Annotation기반(Java Config, Component Scan)
‘’’
org.springframework.context.annotation
Class AnootationConfigApplicationContext
‘’’
