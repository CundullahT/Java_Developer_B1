package com.cybertek.core;

public class Methods {

    public void methodA(){

        System.out.println("methodA() is called");

    }

    public void methodA(String str){

        System.out.println("methodA(String str) is called");

    }

    public String methodB(){

        return "methodB() is called";

    }

    public String methodB(int x){

        return "methodB(int x) is called";

    }

    public static void methodC(){               //  If there is no instance field requirement in method just make it static.
                                                //  Utility classes' methods are static.
        System.out.println("methodC() is called");

    }

}
