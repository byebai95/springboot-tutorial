package app.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class ParamFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // Filter.super.init(filterConfig);
        log.info("ParamFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("FilterConfig doFilter()");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
       // Filter.super.destroy();
        log.info("ParamFilter destroy()");
    }
}
