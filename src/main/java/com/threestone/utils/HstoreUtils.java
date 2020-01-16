package com.threestone.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * postgresql中的hstore类型处理
 * Created by admin on 2019/12/30.
 */
public class HstoreUtils {
    public static String map2hstore(Map<String, Object> hstoreMap){
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : hstoreMap.keySet()){
            Object object = hstoreMap.get(key);
            if (object == null){
                continue;
            }
            String value = object.toString();
            if(StringUtils.isEmpty(value)){
                continue;
            }
            stringBuilder.append("\"" + key +"\"=>");
            stringBuilder.append("\"" + value +"\",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
