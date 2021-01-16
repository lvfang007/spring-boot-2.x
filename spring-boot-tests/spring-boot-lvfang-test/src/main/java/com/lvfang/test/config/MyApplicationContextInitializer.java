package com.lvfang.test.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/11/20
 */
@Order(1000)
public class MyApplicationContextInitializer implements ApplicationContextInitializer{
	/**
	 *
	 * 用于spring容器刷新之前的初始化回调，通常用于需要对应用程序上下文进行编程初始化的web应用程序中。例如，根据上下文环境注册属性源或激活配置文件等。
	 *
	 * 调用时机在初始化context时，所以说ApplicationContextInitializer是在容器刷新refresh之前被调用，做一些初识工作，
	 * 		prepareContext(context);->applyInitializers(context);最终遍历所有的ApplicationContextInitializer，调用initialize方法
	 *
	 * @param applicationContext
	 *
	 * https://www.cnblogs.com/hello-shf/p/10987360.html
	 * https://www.liangzl.com/get-article-detail-30269.html
     */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("bean count===========================:"+applicationContext.getBeanDefinitionCount());
		System.out.println("app name===========================: " + applicationContext.getDisplayName());

		/**
		 * 这里会爆异常：has not been refreshed yet，原因是initialize的执行节点在refreshed之前，这时候容器中还没有bean对象
		 */
//		StartRunner runner = applicationContext.getBean(StartRunner.class);

	}
}
