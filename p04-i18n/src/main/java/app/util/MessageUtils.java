package app.util;

import app.manager.CommonParamFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Slf4j
@Component
public class MessageUtils {

    private static MessageSource messageSource;

    public MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    /**
     * 根据 key 查询参数，指定参数 param 与 地域信息
     *
     * @param key
     * @param params
     * @param locale
     * @return
     */
    public static String getMsg(String key, Object[] params, Locale locale) {
        try {
            return messageSource.getMessage(key, params, locale);
        } catch (Exception e) {
            log.error(e.getMessage());
            return key;
        }
    }

    /**
     * 没有参数 params
     *
     * @param key
     * @param locale
     * @return
     */
    public static String getMsg(String key, Locale locale) {
        return getMsg(key, null, locale);
    }

    /**
     * 使用系统的 locale
     *
     * @param key
     * @param params
     * @return
     */
    public static String getMsg(String key, Object[] params) {
        return getMsg(key, params, LocaleContextHolder.getLocale());
    }


    /**
     * 只通过 key 查询
     * @param key
     * @return
     */
    public static String getMsg(String key) {
        return getMsg(key, null, CommonParamFilter.LOCALE_LOCAL.get());
    }

}
