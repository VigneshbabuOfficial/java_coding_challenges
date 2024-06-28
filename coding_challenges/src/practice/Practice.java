package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Practice {


    public static void main(String[] args) {

        List<String> strList = Arrays.asList("aaaa","bbbb","cccc");

        System.out.println("====================MRClass::showMethod==============================");
        strList.stream().map(MRClass::showMethod).forEach(System.out::println);

        System.out.println("====================MRInterface::showMethod==============================");
        strList.stream().map(MRInterface::showMethod).forEach(System.out::println);

        System.out.println("====================AbstractClass::showMethod==============================");
        strList.stream().map(AbstractClass::showMethod).forEach(System.out::println);





        String[] str = new String[5];
        String value = Optional.ofNullable(str[2]).orElse("DEFAULT_VAL");
        System.out.println(value); // O/P : DEFAULT_VAL

    }
}


class MRClass {

    static String showMethod(String str) {
        return "MRClass - "+str+" - ";
    }
}

interface MRInterface {

    void voidMethod();

    static void voidMethod1() {

    }

    static String showMethod(String str) {
        return "MRInterface - "+str+" - ";
    }
}

abstract class AbstractClass{

    abstract void voidMethod();

    static void voidMethod1() {

    }

    static String showMethod(String str) {
        return "AbstractClass - "+str+" - ";
    }
}