package org.learning.spring

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SimpleWebController {
    @RequestMapping
    public String greetings() {
        return "<h1>Spring Boot rocks in Java too!</h1>"
    }
}