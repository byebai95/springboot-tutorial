package app.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:33
 */
@Accessors(chain = true)
@Data
public class ResponseInfo<T> {

    private static final Integer ERROR = -1;
    private static final Integer SUCCESS = 0;

    private static final String DEFAULT_MSG_SUCCESS = "请求成功";

    private static final String DEFAULT_MSG_ERROR = "请求失败";

    private T data;

    private String msg;

    private Integer code;

    public static <T> ResponseInfo<T> ok(T data, String msg) {
        return new ResponseInfo<T>()
                .setCode(SUCCESS)
                .setData(data)
                .setMsg(msg);
    }

    public static <T> ResponseInfo<T> ok(T data) {
        return new ResponseInfo<T>()
                .setCode(SUCCESS)
                .setData(data)
                .setMsg(DEFAULT_MSG_SUCCESS);
    }

    public static <T> ResponseInfo<T> error(String msg) {
        return new ResponseInfo<T>()
                .setCode(ERROR)
                .setData(null)
                .setMsg(msg);
    }

    public static <T> ResponseInfo<T> error() {
        return new ResponseInfo<T>()
                .setCode(ERROR)
                .setData(null)
                .setMsg(DEFAULT_MSG_ERROR);
    }
}
