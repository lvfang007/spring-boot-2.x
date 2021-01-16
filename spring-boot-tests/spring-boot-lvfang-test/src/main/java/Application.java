
import com.lvfang.test.config.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/9/8
 */
@Import({TestConfig.class})
@MapperScan(value = {"com.lvfang.test.mapper"})
@ComponentScan("com.lvfang.*")
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableAsync
public class Application {
	public static void main(String[] args) {
		/**
		 * 启动入口
		 *
		 * 源码环境搭建地址：https://blog.csdn.net/bskfnvjtlyzmv867/article/details/89434894
		 * 源码学习地址：https://www.cnblogs.com/hello-shf/p/10976646.html#_label3_0_1_2
		 * 源码学习地址：https://blog.csdn.net/woshilijiuyi/article/details/82219585
		 *
		 * 1、springboot的启动
		 * 	1.1 完成spring容器的启动
		 * 	1.2 要把项目部署到Tomcat
		 *
		 * 2、springboot自动装配
		 * 	核心注解@SpringBootApplication
		 * 	https://blog.csdn.net/u014745069/article/details/83820511
		 * 	https://www.cnblogs.com/niechen/p/9027804.html
		 *
		 * 	springboot在主类启动的refresh方法执行的时候出发自动装配，将类自动注入
		 *
		 *
		 * 	@SpringBootApplication ——>
		 * 		@EnableAutoConfiguration ——>
		 * 			@Import(AutoConfigurationImportSelector.class) ——>
		 * 				selectImports()方法中通过SPI机制读取springboot-autoconfig包下的/META-INF/spring.factories文件加载注册所有的自重装配类
		 * 					@ConditionalOn注解是自动装配生效的关键所在，通过@EnableConfigurationProperties(XxxProperties.class)与配置绑定
		 *
		 */
		/**
		 * 自动装配中用了很多@ConditionalOn类型的注解，@ConditionalOn的作用其实就是“条件满足的时候，才把对应的实例加入到spring容器中”
		 *
		 * @ConditionalOnClass
		 * @ConditionalOnProperty
		 *
		 * 实际上spring在加载的时候已经将这些自动注解封装成beanDefinition，只是在是否实例化需要根据这个类的@ConditionalOn配置来决定，当
		 * 条件满足，才会被实例化。简单的说，当你配置中配置了AOP相关的配置，springboot才会对相关的注解进行实例化做支撑
		 *
		 * 重点看看Redis的自动注入，
		 *
		 *
		 * SPI工具类SpringFactoriesLoader
		 *
		 * springboot就是spring+springMVC的简化集成。
		 *
		 * springboot的核心依赖spring-boot-starter-web支持，可以在maven上看一下这个依赖
		 */

//		SpringApplication.run(Application.class,args);

		SpringApplication application = new SpringApplication(Application.class);
		application.addInitializers(new MyApplicationContextInitializer());
		application.addListeners(new StartingEventListener(),new StartedEventListener());

		ConfigurableApplicationContext context = application.run(args);
		System.out.println(context.getEnvironment().getProperty("spring.datasource.druid.username"));
		System.out.println(context.getEnvironment().getProperty("spring.profiles.active"));
		context.close();
	}
}
