package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolAutoConfiguration {

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class) // 需要项目中存在ThreadPoolExecutor类，该类为JDK自带，所以，一定成立
    public ThreadPoolExecutor myThreadPool() {
        System.out.println("这里是我自己实现的线程池，myThreadPool===========");
        return new ThreadPoolExecutor(10, 10,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
    }

}
