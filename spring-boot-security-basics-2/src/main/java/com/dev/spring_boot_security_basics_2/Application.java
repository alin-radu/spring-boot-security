package com.dev.spring_boot_security_basics_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.FilterChainProxy;

import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner logFilters(FilterChainProxy filterChainProxy) {
        AtomicReference<Integer> counter = new AtomicReference<>(1);
        return args -> {
            System.out.println("-----------------------------------------------");
            System.out.println("Registered Security Filters:");
            filterChainProxy.getFilterChains().forEach(chain -> {
                chain.getFilters().forEach(filter -> {
                    String[] filterFullName = filter.getClass().getName().split("\\.");
                    String filterName = filterFullName[filterFullName.length - 1];
                    String counterStr = counter.get().toString();

                    String idx = counter.get() < 10 ? "0" + counterStr : counterStr;

                    System.out.println(idx + ". " + filterName);

                    counter.set(counter.get() + 1);

                });
            });
            System.out.println("-----------------------------------------------");
        };
    }

}
