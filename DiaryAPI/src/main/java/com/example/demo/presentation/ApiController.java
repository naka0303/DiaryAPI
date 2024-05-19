package com.example.demo.presentation;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  @PostMapping("/v1/csrf")
  @CrossOrigin("http://localhost:4200")
  public CsrfToken csrf(CsrfToken token) {
    return token;
  }
}