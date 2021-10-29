package app.service;

import app.model.param.LoginParam;
import app.model.response.ResponseInfo;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:29
 */
public interface LoginService {

    ResponseInfo<?> login(LoginParam param);

    ResponseInfo<?> getUserInfo(String uid);
}
