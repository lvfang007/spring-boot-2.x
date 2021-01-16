package com.lvfang.test.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @描述
 * @创建人 lvfang
 * @创建时间 2020/8/4
 */
@Slf4j
@Service
public class TaskService {


    @Scheduled(cron="0/55 * * * * ? ") //每1秒执行一次
    public void testCron1() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(new Date())+"*********每1秒执行一次");

    }
}
