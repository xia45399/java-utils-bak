package com.summer;

import com.alibaba.fastjson.JSONObject;


public class APIUtils {

    public static JSONObject buildBoolean(boolean success) {
        if (success) {
            return buildSuccess();
        } else {
            return buildError();
        }
    }

    public static JSONObject buildBoolean(boolean success, String msg) {
        if (success) {
            return buildSuccess(msg);
        } else {
            return buildError(msg);
        }
    }

    public static JSONObject buildBoolean(boolean success, Object data) {
        if (success) {
            return buildSuccess(data);
        } else {
            return buildError(data);
        }
    }

    public static JSONObject buildBoolean(boolean success, Object data, String msg) {
        if (success) {
            return buildSuccess(data, msg);
        } else {
            return buildError(data, msg);
        }
    }


    public static JSONObject buildSuccess() {
        return buildResult(1);
    }

    public static JSONObject buildSuccess(Object data) {
        return buildResult(1, data);
    }

    public static JSONObject buildSuccess(String msg) {
        return buildResult(1, msg);
    }

    public static JSONObject buildSuccess(Object data, String msg) {
        return buildResult(1, data, msg);
    }

    public static JSONObject buildError() {
        return buildResult(0);
    }

    public static JSONObject buildError(Object data) {
        return buildResult(0, data);
    }

    public static JSONObject buildError(String msg) {
        return buildResult(0, msg);
    }

    public static JSONObject buildError(Object data, String msg) {
        return buildResult(0, data, msg);
    }

    public static JSONObject buildResult(int result) {
        return buildResult(result, null, null);
    }

    public static JSONObject buildResult(int result, Object data) {
        return buildResult(result, data, null);
    }

    public static JSONObject buildResult(int result, String msg) {
        return buildResult(result, null, msg);
    }

    public static JSONObject buildResult(int result, Object data, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        if (data != null) {
            jsonObject.put("data", data);
        }
        if (msg != null) {
            jsonObject.put("msg", msg);
        }
        return jsonObject;
    }

}
