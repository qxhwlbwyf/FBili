package com.taru.Bili.util;

/**
 * 控制空值返回""不是null
 */
public class StringUtil {
    public static String valueOf(Object obj){
        return(obj==null) ? "" : obj.toString();
    }
}
