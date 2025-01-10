package com.dev.spring_boot_security_basics.model;

import org.springframework.data.annotation.Id;

public record Post(@Id Integer id, String title, String content) {
}
