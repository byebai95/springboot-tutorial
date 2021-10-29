package app.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: bai
 * @Date: 2021/10/29 11:01
 */
@Accessors(chain = true)
@Data
public class UserInfoVO {

    private String uid;

    private String username;

    private String password;
}
