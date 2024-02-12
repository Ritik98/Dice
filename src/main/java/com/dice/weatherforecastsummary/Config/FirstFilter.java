package com.dice.weatherforecastsummary.Config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class FirstFilter implements Filter {

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String client_id = req.getHeader("client-id");
        String client_secret = req.getHeader("client-secret");

        if (client_id == null || client_secret == null) {
            res.sendError(HttpStatus.UNAUTHORIZED.value(), "client_id or client_secret could not be found");
            return;
        }
        if (!client_id.equals(clientId) || !client_secret.equals(clientSecret) ){
            res.sendError(HttpStatus.UNAUTHORIZED.value(), "client_id or client_secret token mismatch");
            return;
        }
        res.addHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(req, res);
    }
}