package stringrelated;

import java.util.*;
import java.util.stream.*;

public class StringAndDoubleTest {
    public static void main(String[] args) {

       stringAndDoubleTest();

    }

    

    public static void stringAndDoubleTest(){
        List<Integer> lstInt = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(lstInt);
        List<Integer> lstInt2 = lstInt.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(lstInt2);

        List<Integer> lstInt3 = lstInt.stream().map(n -> n * 2).collect(Collectors.toList());

        String literalA = "abc";
        String literalB = "abc";

        String objectA = new String("abc");
        String objectB = new String("abc");

        System.out.println(literalA == objectA);
        System.out.println(literalA == objectB);
        System.out.println(literalA == literalB);
        double num = 10.99;
        System.out.println((int)num);

        double num1 = -10.99;
        double num2 = -10.01;

        System.out.println((int) num1); // Output: -10
        System.out.println((int) num2);
    }

    public static void StringTest() {
        String text = "The giant panda has an insatiable appetite for bamboo. " +
                "A typical animal eats half the day—a full 12 out of every 24 " +
                "hours—and relieves itself dozens of times a day. It takes 28 " +
                "pounds of bamboo to satisfy a giant panda's daily dietary needs. " +
                "Pandas will sometimes eat birds or rodents as well.";

        String[] sentences = text.split("\\. ");

        System.out.println("The text has " + sentences.length + " sentences.");

        String[] words = text.split(" |-");
        System.out.println("The text has " + words.length + " words.");

        System.out.println(Arrays.asList(words));

        System.out.println("The text has " + text.length() + " characters.");

    }
}
