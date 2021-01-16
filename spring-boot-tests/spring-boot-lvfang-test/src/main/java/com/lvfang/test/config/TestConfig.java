package com.lvfang.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/11/20
 */
@Component
@Configuration
public class TestConfig implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {

		System.out.println("@Import ——> TestConfig:===============");
		System.out.println("@Import ——> TestConfig:===============");
		System.out.println("@Import ——> TestConfig:===============");
		System.out.println("@Import ——> TestConfig:===============");
		return new String[0];
	}
}
