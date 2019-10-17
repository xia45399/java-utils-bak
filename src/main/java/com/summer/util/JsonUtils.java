package com.summer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;

import java.util.Map;

/**
 * json工具类
 * 包含：
 * json美化输出
 * json扁平化处理
 * json扁平化后还原
 */
public class JsonUtils {

    /**
     * json 格式化输出
     *
     * @param json json对象
     * @return String
     */
    public static String beautifulJson(Object json) {
        String text;
        ObjectMapper mapper = new ObjectMapper();
        try {
            text = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            text = json.toString();
        }
        return text;
    }

    /**
     * jsonStr 扁平化为 String
     *
     * @param jsonStr json字符串
     * @return 扁平化后的字符串
     */
    public static String jsonFlattenAsStr(String jsonStr) {
        return JsonFlattener.flatten(jsonStr);
    }

    /**
     * jsonStr 扁平化为 Map
     *
     * @param jsonStr json字符串
     * @return 扁平化后的Map对象
     */
    public static Map<String, Object> jsonFlattenAsMap(String jsonStr) {
        return JsonFlattener.flattenAsMap(jsonStr);
    }

    /**
     * 反扁平化
     * 将扁平化后的 str 转为 json字符串
     *
     * @param flattenStr 扁平化后的字符串
     * @return 立体后的json字符串
     */
    public static String jsonUnFlatten(String flattenStr) {
        return JsonUnflattener.unflatten(flattenStr);
    }

    /**
     * jsonStr 扁平化为 String
     * 并制定级别之间的分隔字符
     *
     * @param jsonStr json字符串
     * @param spliter 自定义分隔符
     * @return 扁平化后的字符串
     */
    public static String jsonFlattenAsStr(String jsonStr, char spliter) {
        return new JsonFlattener(jsonStr).withSeparator(spliter).flatten();
    }

    /**
     * json扁平化为map 并修改分隔符
     * 修改级别之间的分隔字符
     *
     * @param jsonStr json字符串
     * @param spliter 自定义分隔符
     * @return 扁平化后的Map对象
     */
    public static Map<String, Object> jsonFlatten(String jsonStr, char spliter) {
        return new JsonFlattener(jsonStr).withSeparator(spliter).flattenAsMap();
    }

    /**
     * 反扁平化
     * 将扁平化后的 str 转为 json字符串
     *
     * @param flattenStr 扁平化后的字符串
     * @param spliter    自定义分隔符
     * @return j立体后的json字符串
     */
    public static String jsonUnFlatten(String flattenStr, char spliter) {
        return new JsonUnflattener(flattenStr).withSeparator(spliter).unflatten();
    }
}
