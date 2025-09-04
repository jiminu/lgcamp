package com.lgcns.inspire_restjpa.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, 
                         ServletResponse response, 
                         FilterChain chain)
            throws IOException, ServletException {
                
        System.out.println("[DEBUG] : jwt filter doFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String path = req.getRequestURI();
        System.out.println("[DEBUG] : client path -> " + path);
        String method = req.getMethod();
        System.out.println("[DEBUG] : client method -> " + method);
        
        if(isPath(path)) {
            System.out.println("[DEBUG] : isPath -> " + isPath(path));
            chain.doFilter(request, response);
            return;
        }
    }
    
    // 특정 end point는 인가없이 이동 가능하게
    public boolean isPath(String path) {
    return path.startsWith("/swagger-ui") ||
           path.startsWith("/index.html") ||
           path.startsWith("/v3/api-docs") ||
           path.startsWith("/api/v2/inspire/user/signin") ||
           path.startsWith("/api/v2/inspire/user/signup");
    }
}
