package com.lvfang.test.config;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/11/21
 */
@Configuration
@Component
public class MyApplicationRunListener implements SpringApplicationRunListener {

	/**
	 * springboot提供的6个监听时机
	 * 	开始启动
	 	Environment构建完成
	 	ApplicationContext构建完成
	 	ApplicationContext完成加载
	 	ApplicationContext完成刷新并启动
	 	启动完成
	 */

	/**
	 * TODO SpringApplicationRunListener 接口的作用主要就是在Spring Boot 启动初始化的过程中可以通过SpringApplicationRunListener接口回调来让用户在启动的各个流程中可以加入自己的逻辑。
	 */
	public MyApplicationRunListener(){
		System.out.println("构造方法：MyApplicationRunListener");
	}

	@Override
	public void starting() {
		System.out.println("starting...TODO 在run()方法开始执行时，该方法就立即被调用，可用于在初始化最早期时做一些工作");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("environmentPrepared...TODO 当environment构建完成，ApplicationContext创建之前，该方法被调用");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("contextPrepared...TODO 当ApplicationContext构建完成时，该方法被调用");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("contextLoaded...在ApplicationContext完成加载，但没有被刷新前，该方法被调用");
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("started...在ApplicationContext刷新并启动后，CommandLineRunners和ApplicationRunner未被调用前，该方法被调用");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("running...在run()方法执行完成前该方法被调用");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("failed...当应用运行出错时该方法被调用");
	}
}
