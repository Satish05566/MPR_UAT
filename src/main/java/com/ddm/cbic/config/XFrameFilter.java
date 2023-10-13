package com.ddm.cbic.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class XFrameFilter extends OncePerRequestFilter {

@Override
protected void doFilterInternal(HttpServletRequest httpRequest,
                                HttpServletResponse httpResponse,
                                FilterChain filterChain) throws ServletException, IOException {
	httpResponse.setHeader("X-FRAME-OPTIONS", "DENY");
    httpResponse.setHeader(HttpHeaders.CACHE_CONTROL,
            "no-cache, must-revalidate, no-store");
    httpResponse.setHeader("Expires", "0");
    httpResponse.setHeader("Set-Cookie", "HttpOnly;Secure;SameSite=Strict");
    httpResponse.setHeader("Content-Security-Policy",
            "default-src https: http:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https: http:; style-src http: https: 'unsafe-inline'; img-src 'self' data: https:; connect-src http: https: ws:;");
    filterChain.doFilter(httpRequest, httpResponse);
}
}    