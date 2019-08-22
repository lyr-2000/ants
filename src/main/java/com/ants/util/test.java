package com.ants.util;

/**
 * @Author ³¿±ß°¡°¡#CB
 * @Date:created in  2019/8/22 20:49
 * @Version V1.0
 **/

public class test {

    public static void main(String[] args) {
        SensitiveFilter filter = SensitiveFilter.DEFAULT;
        String sentence = "ÎÒ²ÙÄãÂè";
        String filted = filter.filter(sentence, '*');
        if(sentence != filted){
            // ¾ä×ÓÖĞÓĞÃô¸Ğ´Ê
            System.out.println(filted);
        }
    }
}
