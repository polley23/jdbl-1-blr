package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        try {
//            int a = 2/1;
//           throw new RuntimeException("run time error");
//        }catch (ArithmeticException e){
//            System.out.println("arithmetic exp");
//            System.exit(0);
//        }catch (Exception e){
//            System.out.println("exp");
//            throw new RuntimeException("run time error");
//        }
//        finally {
//            System.out.println(" In finally block");
//        }

        throwsException();
        try{
            throwsCheckedException();
        }catch (Exception e){

        }


        System.out.println("Hello world!");

    }

    static void throwsException(){
        throw new CustomException("error");
    }

    static void throwsCheckedException() throws CustomCheckedException{

        throw new CustomCheckedException("error");

    }


}