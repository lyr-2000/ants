package com.ants.util;

import com.sun.javafx.collections.MappingChange;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author 晨边啊啊#CB
 * @Date:created in  2019/8/22 20:49
 * @Version V1.0
 **/

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("../webapp/img/slideCode");
       System.out.println( test.class.getClass().getResource("/").getPath());
       System.out.println(ResourceUtils.getURL("classpath:").getPath());
       System.out.println(Class.class.getClass().getResource("/").getPath());
        System.out.println(file.length());
    }
}
