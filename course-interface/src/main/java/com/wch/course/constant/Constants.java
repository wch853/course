package com.wch.course.constant;

public interface Constants {

    /**
     * 用户token过期时间
     */
    int USE_TOKEN_EXPIRE_TIME = 60 * 60;

    /**
     * 用户token缓存前缀
     */
    String USE_TOKEN_CACHE_PREFIX = "token:";

    /**
     * 手机验证码缓存时间
     */
    int VERIFICATION_CODE_EXPIRE_TIME = 5 * 60;

    /**
     * 手机验证码缓存前缀
     */
    String VERIFICATION_CODE_CACHE_PREFIX = "verification:";

}
