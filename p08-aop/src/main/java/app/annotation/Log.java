package app.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 操作
     * @return
     */
    String value();

    /**
     * 用户
     * @return
     */
    String username();
}
