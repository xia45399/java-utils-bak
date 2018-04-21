package com.summer;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created on 2017/10/9.
 */

public class DataUtils {

    public static String getString(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof String) {
            return (String) obj;
        } else if (!(obj instanceof Date) && !(obj instanceof Timestamp)) {
            return obj.toString();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(obj);
        }
    }

    public static Long getLong(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Long) {
            return (Long) obj;
        } else {
            if ("".equals(obj.toString())) {
                return null;
            }
            return new Long(obj.toString());
        }
    }

    public static long getLongValue(Object obj) {
        Long value = getLong(obj);
        if (value == null) {
            return 0;
        }
        return value;
    }


    public static Integer getInteger(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Integer) {
            return (Integer) obj;
        } else {
            if ("".equals(obj.toString())) {
                return null;
            }
            return new Integer(obj.toString());
        }
    }

    public static int getIntegerValue(Object obj) {
        Integer value = getInteger(obj);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public static Float getFloat(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Float) {
            return (Float) obj;
        } else {
            if ("".equals(obj.toString())) {
                return null;
            }
            return new Float(obj.toString());
        }
    }

    public static float getFloatValue(Object obj) {
        Float value = getFloat(obj);
        if (value == null) {
            return 0f;
        }
        return value;
    }

    public static Double getDouble(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            if ("".equals(obj.toString())) {
                return null;
            }
            return new Double(obj.toString());
        }
    }

    public static double getDoubleValue(Object obj) {
        Double value = getDouble(obj);
        if (value == null) {
            return 0d;
        }
        return value;
    }
}
