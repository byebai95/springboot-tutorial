package app.manager;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class LangLocaleResolver implements LocaleResolver {

    private static final String FIELD_LOCALE = "locale";

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale = Locale.getDefault();
        String localeStr = httpServletRequest.getHeader(FIELD_LOCALE);
        if (StringUtils.isEmpty(localeStr) || "undefined".equals(localeStr)) {
            localeStr = "zh_CN";
        }
        boolean flag = StringUtils.isEmpty(localeStr);
        if (!flag) {
            locale = locale(localeStr);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    public static Locale locale(String localeStr) {
        String[] language = localeStr.split("_");
        return new Locale(language[0], language[1]);
    }
}
