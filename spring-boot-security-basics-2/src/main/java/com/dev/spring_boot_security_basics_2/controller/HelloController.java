package com.dev.spring_boot_security_basics_2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest request, Principal principal) {

        System.out.println(principal.getName());

        System.out.println("---> Request | greet");

        System.out.println("---> request.getRequestedSessionId(): " + request.getRequestedSessionId());

        System.out.println("---> request.getSession().getId(): " + request.getSession().getId());

        return """
                <div>
                 <h3> Hello World.</h3>
                 <b>%s</b>
                 </div>
                """.formatted(request.getRequestedSessionId());
    }
}
