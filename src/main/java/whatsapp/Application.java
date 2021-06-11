package whatsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot的一些注解
 *     		ps：@SpringBootApplication 表示开启下述 1、2、5
 *
 *      1.@Configuration 注解是spring去xml配置,开启spring基于java的配置
 *        @Configuration 类级别的注解， 一般这个注解，我们用来标识main方法所在的类,完成元数据bean的初始化。
 *        @Bean 一个带有 @Bean 的注解方法将返回一个对象
 *
 *      2.@ComponentScan 收集自动收集所有的spring组件  搜索beans类级别的注解，自动扫描加载所有的Spring组件包括Bean注入，一般用在main方法所在的类上
 *
 *      3.@Import导入其他的Configuration类
 *
 *      4.@ImportResource附加注入一个外置的xml
 *
 *      5.@EnableAutoConfiguration 和 @SpringBootApplication是类级别的注解，
 *      根据maven依赖的jar来自动猜测完成正确的spring的对应配置，只要引入了spring-test-starter-web的依赖，默认会自动配置Spring MVC和tomcat容器
 *
 *      6.@Component类级别注解，用来标识一个组件，比如我自定了一个filter，则需要此注解标识之后，Spring Boot才会正确识别。
 *
 *
 * Spring-boot加载配置文件的顺序是
 *
 * 		1. ./config/application.properties
 *		2. ./application.properties
 *		3. classpath:config/application.properties
 *		4. classpath:application.properties
 *
 * yaml文件里配置项名和bean里的属性名相同
 */
 
@SpringBootApplication
public class Application { // extends SpringBootServletInitializer

  public static void main(String[] args) {
      SpringApplication application = new SpringApplication(Application.class, "classpath*:/spring/*.xml");
      application.setWebEnvironment(true);
      application.run(args);
  }
  
   /**
     *  HOW TO MAKE A SPRING BOOT JAR INTO A WAR TO DEPLOY ON TOMCAT
     */
//    @Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		// Customize the application or call application.sources(...) to add sources
//
//		application.sources(Application.class);
//		return application;
//	}

}