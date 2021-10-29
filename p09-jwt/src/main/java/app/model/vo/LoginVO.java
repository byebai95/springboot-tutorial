package app.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:41
 */
@Accessors(chain = true)
@Data
public class LoginVO {

    private String uid;

    private String token;
}
