package com.ants.util;

/**
 * @Author ���߰���#CB
 * @Date:created in  2019/8/22 20:49
 * @Version V1.0
 **/

public class test {

    public static void main(String[] args) {
        SensitiveFilter filter = SensitiveFilter.DEFAULT;
        String sentence = "�Ҳ�����";
        String filted = filter.filter(sentence, '*');
        if(sentence != filted){
            // �����������д�
            System.out.println(filted);
        }
    }
}
