package com.phynos.solar.controller;

import com.phynos.solar.util.json.R;
import com.phynos.solar.util.json.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Lupc
 * @Date: 2019/10/31 9:23
 **/
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public R<?> handlerException(RuntimeException ex) {
        logger.error(ex.getMessage(), ex);
        return R.codeMsg(ResultCodeEnum.SYSTEM_UNKNOWN_ERROR, ex.getMessage());
    }

    //参数类型不匹配
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public R<?> requestTypeMismatch(TypeMismatchException ex) {
        logger.error(ex.getMessage(), ex);
        return R.codeMsg(ResultCodeEnum.PARAMETER_ERROR, "参数类型不匹配,参数" + ex.getPropertyName() + "类型应该为" + ex.getRequiredType());
    }

    //缺少参数异常
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public R<?> requestMissingServletRequest(MissingServletRequestParameterException ex) {
        logger.error(ex.getMessage(), ex);
        return R.codeMsg(ResultCodeEnum.PARAMETER_ERROR, "缺少必要参数,参数名称为" + ex.getParameterName());
    }

}
