package com.lvfang.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/9/8
 */
@Controller
@RequestMapping("/test")
public class MyTestController {

	/**
	 * 请求地址：http://localhost/test/hello
	 * @return
     */
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
