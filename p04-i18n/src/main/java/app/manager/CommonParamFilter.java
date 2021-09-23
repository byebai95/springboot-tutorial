package app.manager;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@Slf4j
public class CommonParamFilter implements Filter {

    public static final ThreadLocal<Locale> LOCALE_LOCAL = new ThreadLocal<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        setLocal((HttpServletRequest)servletRequest);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    public void setLocal(HttpServletRequest request){
        String local = request.getHeader("locale");
        LOCALE_LOCAL.set(getLocale(local));
    }

    private static Locale getLocale(String locale) {
        if (ObjectUtils.isEmpty(locale)) {
            log.warn("locale is empty, use default local SIMPLIFIED_CHINESE");
            return Locale.SIMPLIFIED_CHINESE;
        }
        switch (locale) {
            case "zh_TW":
                return Locale.TRADITIONAL_CHINESE;
            case "zh_CN":
                return Locale.SIMPLIFIED_CHINESE;
            case "en_US":
                return Locale.US;
            default:
                log.warn("{} not found, use default local SIMPLIFIED_CHINESE", locale);
                break;
        }
        return Locale.SIMPLIFIED_CHINESE;
    }
}
