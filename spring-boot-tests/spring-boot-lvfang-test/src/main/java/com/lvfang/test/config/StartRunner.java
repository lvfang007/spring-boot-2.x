package com.lvfang.test.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/10/27
 */
@Slf4j
@Component
public class StartRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {


        log.info("{}","####################################");
        log.info("{}","####################################");
		log.info("{}","####  StartRunner启动运行-成功  ####");
        log.info("{}","####################################");
        log.info("{}","####################################");
    }
}
