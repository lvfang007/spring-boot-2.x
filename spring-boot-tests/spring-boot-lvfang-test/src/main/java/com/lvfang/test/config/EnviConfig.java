package com.lvfang.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/11/20
 */
@Component
public class EnviConfig {

	@Autowired
	private Environment environment;

	@Value("${spring.datasource.druid.username}")
	private String username;

	@Value("${spring.datasource.druid.password}")
	private String password;

	public void show(){
		System.out.println(environment.getProperty("spring.datasource.druid.username"));
		//重载方法，使得读取到的数据是Integer类型的
		System.out.println(environment.getProperty("spring.datasource.druid.password",String.class));
		System.out.println(username);
		System.out.println(password);

	}
}
