package app.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:32
 */
@Data
public class LoginParam {

    @ApiModelProperty(value = "用户昵称",required = true)
    private String username;

    @ApiModelProperty(value = "用户密码",required = true)
    private String password;
}
