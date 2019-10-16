package com.summer.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wnameless.json.flattener.JsonFlattener;

import java.util.Map;

/**
 * json工具类
 */
public class JsonUtils {

    /**
     * json 格式化输出
     *
     * @param json json
     * @return String
     */
    public static String beautifulJson(JSONObject json) {
        String text;
        ObjectMapper mapper = new ObjectMapper();
        try {
            text = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            text = json.toJSONString();
        }
        return text;
    }

    /**
     * json扁平化为map
     *
     * @param json json对象
     * @return map
     */
    public static Map<String, Object> jsonFlatten(JSONObject json) {
        return JsonFlattener.flattenAsMap(json.toString());
    }

    /**
     * json扁平化为map 并修改分隔符
     * 修改级别之间的分隔字符
     *
     * @param json    json
     * @param spliter 自定义分隔符
     * @return map
     */
    public static Map<String, Object> jsonFlatten(JSONObject json, char spliter) {
        return new JsonFlattener(json.toString()).withSeparator(spliter).flattenAsMap();
    }
}
