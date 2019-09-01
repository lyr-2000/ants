package com.ants.util;

import com.sun.javafx.collections.MappingChange;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author ³¿±ß°¡°¡#CB
 * @Date:created in  2019/8/22 20:49
 * @Version V1.0
 **/

public class test {

    public static void main(String[] args) {
        int[] dormitory = {901, 902, 903, 904, 906};
        Set<Integer> result = new HashSet<>();


        while (true){
            int index = (int) (Math.random() * 5);
            result.add(dormitory[index]);
            if (result.size() == 2){
                break;
            }
        }

        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
            System.out.println("±»³éµ½µÄËÞÉáºÅÎª£º"+iterator.next());
        }


    }
}
