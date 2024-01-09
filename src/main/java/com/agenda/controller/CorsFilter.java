package com.agenda.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import jakarta.servlet.*;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
    public void doFilter(
            ServletRequest req,
            ServletResponse resp,
            FilterChain chain
    ) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader(
                "Access-Control-Allow-Headers",
                "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN"
        );
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("X-Frame-Options", "true");
        if ("OPTIONS" == request.getMethod()) {
            response.setStatus(200);
        } else {
            chain.doFilter(req, resp);
        }
    }
}