package com.runar;

import java.lang.reflect.*;
import java.util.List;
import java.util.ArrayList;
import com.runar.MegaClass;

public class ReflectionTest {
  public static void main(String[] argv){
    System.out.println("Hello World");
    System.out.println(argv[0]);
    List<String> listi = new ArrayList<String>();
    Class myClass = listi.getClass();
    System.out.println(myClass.getName());
    Method[] methods = myClass.getMethods();
    for (Method m : methods) {
      System.out.println(m);
    }
    System.out.println("##################");

    MegaClass myMega = new MegaClass("Runar");
    System.out.println(myMega.mega);
  }
}
