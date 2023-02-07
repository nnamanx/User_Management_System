package util;

import java.util.Scanner;

public class InputUtil {


//String input
    public static String inputTypeString(String statement){
        Scanner sc = new Scanner(System.in);
        System.out.print(statement);
        return sc.nextLine();
    }

//    Short input
    public static short inputTypeShort(String statement){
        Scanner sc = new Scanner(System.in);
        System.out.print(statement);
        return sc.nextShort();
    }

//    Long input
    public static long inputTypeLong(String statement){
        Scanner sc = new Scanner(System.in);
        System.out.print(statement);
        return sc.nextLong();
    }

}
