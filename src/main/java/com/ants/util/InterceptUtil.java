package com.ants.util;

/**
 * 用于对字符串截取的工具
 *
 * @Author czd
 * @Date:created in 2019/9/10
 * @Version V1.0
 */
public class InterceptUtil {

    /**
     * 截取字符串，以"/n"的形式截取，然后将其截取的结果集以数组形式返回
     *
     * @param str
     * @return
     */
    public  String[] intecepterString(String str) {
        String [] strArray = new String[1];
        if (str == null) {
            return strArray;
        }

        //将字符串以"/n"进行分割，然后返回一个数组
        strArray = str.split("/n");

        return strArray;

    }


}
