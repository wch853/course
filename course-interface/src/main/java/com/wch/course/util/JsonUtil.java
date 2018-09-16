package com.wch.course.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json工具类
 * base on jackson
 */
public class JsonUtil {

    // private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * Object转json字符串
     *
     * @param object object
     * @return String
     */
    public static String toJsonString(Object object) {
        String json = null;
        // if (object instanceof String) {
        //     json = (String) object;
        // } else {
        //     try {
        //         json = MAPPER.writeValueAsString(object);
        //     } catch (JsonProcessingException e) {
        //         LOGGER.error("JsonUtil.toJsonString JsonProcessingException");
        //     }
        // }
        return json;
    }

    /**
     * json格式字符串转Bean
     *
     * @param json  json
     * @param clazz Class.Type
     * @param <T>   T
     * @return T
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        T t = null;
        // try {
        //     t = MAPPER.readValue(json, clazz);
        // } catch (IOException e) {
        //     LOGGER.error("JsonUtil.toBean IOException");
        // }
        return t;
    }
}
