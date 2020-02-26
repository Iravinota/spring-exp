package com.ws.exp.spring.jk.reactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * SimpleReactorDemoApplication
 *
 * @author Eric at 2020-02-25_21:44
 */
@SpringBootApplication
@Slf4j
public class SimpleReactorDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleReactorDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("============================");
        Flux.range(1, 6)
                .doOnRequest(n -> log.info(">>> Request {} number", n)) // 注意顺序造成区别
                // .publishOn(Schedulers.elastic())    // 后续代码在这个线程中执行
                .doOnComplete(() -> log.info(">>> Publisher COMPLETE 1"))
                .map(i -> {
                    log.info(">>> Publish {} {}", Thread.currentThread(), i);
                    // return 10/(i-3);
                    return i;
                })
                .doOnComplete(() -> log.info(">>> Publisher COMPLETE 2"))
                // .subscribeOn(Schedulers.single())   // 启动一个单独的线程进行订阅
                // .onErrorResume(e -> {
                //     log.error(">>> Exception {}", e.toString());
                //     return Mono.just(-1);
                // })
                // .onErrorReturn(-1)
                .subscribe(i -> log.info(">>> Subscribe {}: {}", Thread.currentThread(), i),    // consumer
                        e -> log.error(">>> error {}", e.toString()),                           // error consumer
                        () -> log.info(">>> Subscriber COMPLETE")                               // complete consumer
                        // ,s -> s.request(4)  // backpressure
                        );
        Thread.sleep(2000);
    }
}
