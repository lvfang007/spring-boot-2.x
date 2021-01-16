package com.lvfang.test.config;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/11/21
 */
//@Configuration
public class StartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

	/**
	 * TODO ApplicationStartingEvent事件-在run()方法开始执行时，该方法就立即被调用，可用于在初始化最早期时做一些工作
	 *
	 * springboot提供的listener时机有很多处，具体可以参考SpringApplicationRunListener中的接口方法，每个方法代表一个时机的事件触发.
	 * 可以通过对类加@Configuration注解实现监听
	 * 也可以通过在主类上通过application.addListeners(new StartingEventListener())添加监听
	 *
	 * springboot提供了SpringApplicationRunListener,作用主要就是在Spring Boot 启动初始化的过程中可以通过SpringApplicationRunListener接口回调来让用户在启动的各个流程中可以加入自己的逻辑。
	 * @param applicationStartedEvent
	 *
	 * 监听的分类（分时机）
	 * @see org.springframework.boot.SpringApplicationRunListener
	 */
	@Override
	public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
		System.out.println("+++++++++++++++called own started listener++++++++++++++");

		applicationStartedEvent.getArgs().toString();
		System.out.println(applicationStartedEvent.getApplicationContext().getEnvironment().getSystemEnvironment().toString());
		System.out.println(applicationStartedEvent.getApplicationContext().getEnvironment().getSystemProperties().toString());
		System.out.println(applicationStartedEvent.getApplicationContext().getEnvironment().getPropertySources().toString());
		System.out.println(applicationStartedEvent.getClass());
	}
}
