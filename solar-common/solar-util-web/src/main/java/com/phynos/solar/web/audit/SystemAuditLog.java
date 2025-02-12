package com.phynos.solar.web.audit;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author lupc
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemAuditLog {

    /**
     * 模块
     */
    String module() default "";

    /**
     * 功能
     */
    String action() default "";

    /**
     * 渠道
     */
    String channel() default "OperatorType.MANAGE";

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

}
