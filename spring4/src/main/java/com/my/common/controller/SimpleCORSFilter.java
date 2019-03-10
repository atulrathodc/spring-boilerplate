package com.my.common.controller;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

//private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

public SimpleCORSFilter() {
  //  log.info("SimpleCORSFilter init");
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException 
{

	System.out.println("filtering..");
   /* HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;*/

   ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
    ((HttpServletResponse) response).setHeader("Access-Control-Allow-Credentials", "true");
    ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    ((HttpServletResponse) response).setHeader("Access-Control-Max-Age", "3600");
    ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

    chain.doFilter(request, response);
}

@Override
public void init(FilterConfig filterConfig) {
}

@Override
public void destroy() {
}



}