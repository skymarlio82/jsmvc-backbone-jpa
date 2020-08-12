package com.spa.demo.config;

import com.plumelog.core.TraceId;
import com.plumelog.core.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    private IdWorker worker = new IdWorker(1, 1, 1);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        logger.info("doFilter ========== {}", TraceId.logTraceID.get());
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String traceId = request.getHeader("TraceId");
            if (StringUtils.isEmpty(traceId)) {
                TraceId.logTraceID.set(String.valueOf(worker.nextId()));
            } else {
                TraceId.logTraceID.set(traceId);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            logger.info("finally doFilter ========== {}", TraceId.logTraceID.get());
        }
    }

    @Override
    public void destroy() {
        logger.info("destroy ============");
    }
}