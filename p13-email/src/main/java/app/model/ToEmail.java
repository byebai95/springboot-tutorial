package app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: bai
 * @Date: 2021/12/2 14:26
 */
@Accessors(chain = true)
@Data
public class ToEmail {

    /**
     * 接收方
     */
    private String[] tos;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

}
