// CaveOfProgramming Java learning.
// http://courses.caveofprogramming.com/courses/java-for-complete-beginners

package com.marekj.java.cave;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;

// example class to operate on and find methods with introspection
class Person {
}

public class Main {

  public static void main(String[] args) {
  
    Method[] methods = Person.class.getMethods();

    System.out.println(methods.length); // 9 methods in naked class

    for (Method m : methods) {
      System.out.println(m.getName());
      /*
          wait
          wait
          wait
          equals
          toString
          hashCode
          getClass
          notify
          notifyAll
       */
    }
  }
}
