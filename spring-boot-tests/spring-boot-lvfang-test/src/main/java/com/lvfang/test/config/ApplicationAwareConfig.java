package com.lvfang.test.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/11/20
 */
@Component
public class ApplicationAwareConfig implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		applicationContext.getBean(StartRunner.class);
	}
}
