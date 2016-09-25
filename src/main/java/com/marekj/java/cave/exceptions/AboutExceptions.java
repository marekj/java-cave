// http://courses.caveofprogramming.com/courses/java-for-complete-beginners/lectures/38480
package com.marekj.java.cave.exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class BrokenMachine {

    // checked exception. tell a client that this method will throw exception 
    // and a client must check for it with try/catch block
    void foo() throws Exception {

        //indeed let's throw it
        throw new Exception();
    }


    /// this is silly and you should never use Error hierarchy
    void bar() throws Error {
        // and indeed let's throw it
        throw new Error();
    }

    // runtime exception thrown
    void npe() {
        throw new NullPointerException();
    }
}


public class AboutExceptions {

    public static void main(String[] args) {

        File file = new File("out.txt");

        // by itself the following line cause compile error
        // because FileWriter constructor throws Exception
        // FileWriter fileWriter = new FileWriter(file);
        // Someone has to catch this exception

        // call some method that throws exception
        // and yes we have to catch it here because we are the caller
        // unless we add throws IEException to the main method above
        // FileWriter fileWriter = fwriterBubblesException(file);


        // or call some method that handles exception there so we don't have to catch it here
        FileWriter fileWriter = fwriterThatHandlesException(file);


        // another concept. construct an example class BrokenMachine and try it here.

        BrokenMachine m = new BrokenMachine();

        // like in FileWriter this method call can't be here without try-catch
        // m.foo();

        // ok, so let's wrap it with try catch and it's all better
        try {
            m.foo();
        } catch (Exception e) {
            // this will indeed happen
            //e.printStackTrace();
            System.out.println("foo exception catcher");
        }


        // I don't have to wrap this in try catch cause it's throwing Error and not Exception hierarchy
        // but then we blow up
        //m.bar();

        //so let's catch it
        try {
            m.bar();
        } catch (Error e) {
            System.out.println("bar error");
        }


        // add finally
        try {
            m.foo();
        } catch (Exception e) {
            System.out.println("foo exception catcher");
        } finally {
            System.out.println("foo exception finally block");
        }


    }

    //make this method responsible to bubble up exception
    // add throws IOException to the method sig and no need to catch it.
    static FileWriter fwriterBubblesException(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        return fileWriter;
    }

    static FileWriter fwriterThatHandlesException(File file) {
        FileWriter fileWriter = null;

        // surround with try catch block
        try {

            fileWriter = new FileWriter(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // and finally return
        return fileWriter;
    }

}


/*
About Exceptions:
Throwable class has 2 subclass trees: Error and Exception
Exception can be Checked Exception or Runtime Exceptions

Checked Exceptions must be caught or declared in the method's throws sig.
http://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html

 */
