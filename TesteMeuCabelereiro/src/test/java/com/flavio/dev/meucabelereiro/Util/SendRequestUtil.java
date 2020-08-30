package com.flavio.dev.meucabelereiro.Util;

public class SendRequestUtil {

    private static final String key = String.valueOf(System.nanoTime());

    public static String getKey(){
        return key;
    }

    public static String unique(String name){
        if(name != null && !name.isEmpty())
            return name.concat(key);
        else
            return "";
    }
}
