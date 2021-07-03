package com.phynos.solar.common.auth.kaptcha;

import com.phynos.solar.util.json.ResultCodeEnum;

import javax.servlet.http.HttpServletResponse;

public interface KaptchaService {

    void kaptcha(HttpServletResponse response);

    ResultCodeEnum valid(String code);

}
