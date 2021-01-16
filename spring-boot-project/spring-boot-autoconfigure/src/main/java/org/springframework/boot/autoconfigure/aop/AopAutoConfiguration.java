/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.weaver.AnnotatedElement;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration
 * Auto-configuration} for Spring's AOP support. Equivalent to enabling
 * {@link org.springframework.context.annotation.EnableAspectJAutoProxy} in your
 * configuration.
 * <p>
 * The configuration will not be activated if {@literal spring.aop.auto=false}. The
 * {@literal proxyTargetClass} attribute will be {@literal true}, by default, but can be
 * overridden by specifying {@literal spring.aop.proxy-target-class=false}.
 *
 * @author Dave Syer
 * @author Josh Long
 * @since 1.0.0
 * @see EnableAspectJAutoProxy
 * TODO 对注解AOP的支撑
 */
@Configuration
@ConditionalOnClass({ EnableAspectJAutoProxy.class, Aspect.class, Advice.class, AnnotatedElement.class })
@ConditionalOnProperty(prefix = "spring.aop", name = "auto", havingValue = "true", matchIfMissing = true)
public class AopAutoConfiguration {

	/**
	 * 自动装配中用了很多@Conditional类型的注解，@Conditional的作用其实就是“条件满足的时候，才把对应的实例加入刀spring容器中”
		 	@ConditionalOnClass ： classpath中存在该类时起效
	 		@ConditionalOnMissingClass ： classpath中不存在该类时起效
	 		@ConditionalOnBean ： DI容器中存在该类型Bean时起效
	 		@ConditionalOnMissingBean ： DI容器中不存在该类型Bean时起效
	 		@ConditionalOnSingleCandidate ： DI容器中该类型Bean只有一个或@Primary的只有一个时起效
	 		@ConditionalOnExpression ： SpEL表达式结果为true时
	 		@ConditionalOnProperty ： 参数设置或者值一致时起效
	 		@ConditionalOnResource ： 指定的文件存在时起效
	 		@ConditionalOnJndi ： 指定的JNDI存在时起效
	 		@ConditionalOnJava ： 指定的Java版本存在时起效
	 		@ConditionalOnWebApplication ： Web应用环境下起效
	 		@ConditionalOnNotWebApplication ： 非Web应用环境下起效

	 *
	 * 实际上spring在加载的时候已经将这些自动注解封装成beanDefinition，只是在是否实例化需要根据这个类的@Conditional配置来决定，当
	 * 条件满足，才会被实例化。简单的说，当你配置中配置了AOP相关的配置，springboot才会对相关的注解进行实例化做支撑
	 */
	@Configuration
	@EnableAspectJAutoProxy(proxyTargetClass = false)
	@ConditionalOnProperty(prefix = "spring.aop", name = "proxy-target-class", havingValue = "false",
			matchIfMissing = false)
	public static class JdkDynamicAutoProxyConfiguration {

	}

	@Configuration
	@EnableAspectJAutoProxy(proxyTargetClass = true)
	@ConditionalOnProperty(prefix = "spring.aop", name = "proxy-target-class", havingValue = "true",
			matchIfMissing = true)
	public static class CglibAutoProxyConfiguration {

	}

}
