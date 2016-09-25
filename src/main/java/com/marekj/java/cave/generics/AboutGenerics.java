// http://courses.caveofprogramming.com/courses/java-for-complete-beginners/lectures/38477
package com.marekj.java.cave.generics;

import java.util.ArrayList;

class Machine {

  void start() {
    System.out.println("start machine...");
  }
}


class Camera extends Machine {

  @Override
  void start() {
    System.out.println("start camera...");
  }
}


class Car extends Machine {
  @Override
  void start() {
    System.out.println("start a car...");
  }
}


class AboutGenerics {

  public static void main(String[] args) {

    Machine m = new Machine();
    m.start();

    // only objects that are machine or extend machine can be added to list
    ArrayList<Machine> list = new ArrayList<>(); // generics thingi

    list.add(new Machine());
    list.add(new Camera());
    list.add(new Car());
    
    showMachine(list);
    showWildcard(list);
    showUnknown(list);

  }

  // example ArrayList of Machines declared
  public static void showMachine(ArrayList<Machine> ms) {

    System.out.println("showMachine");

    for (Machine m : ms) {
      m.start();
    }
  }

  // example accept any subclass of Machine but we operate on a known Machine. Isn't this a bit silly or redundant?
  // it's really the same as showMachine above
  public static void showWildcard(ArrayList<? extends Machine> ms) {

    System.out.println("showWildcard");
    for (Machine m : ms) {
      m.start();
    }
  }

  // unknown Object signaled by wildcard ?
  public static void showUnknown(ArrayList<?> ms) {

    for (Object m : ms) { // ? stands for Unknown so we can only use Object type
      System.out.println(m.getClass());
    }
  }
}
