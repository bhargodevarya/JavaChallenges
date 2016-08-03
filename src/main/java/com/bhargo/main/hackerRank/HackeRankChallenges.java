package com.bhargo.main.hackerRank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by barya on 8/3/16.
 */
public class HackeRankChallenges {

    static void hackerRankDataType() {
        int i =4;
        double d =4.0;
        String s ="HackerRank";
        Scanner scan = new Scanner(System.in);
        /* Declare second integer, double, and String variables. */
        int readInt =0;
        double readDouble = 0.0;
        String readString = "";
        /* Read and save an integer, double, and String to your variables.*/
        readInt = scan.nextInt();
        readDouble = scan.nextDouble();
        readString = scan.next();
        //readString = scan.next(Pattern.compile(" "));
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+readInt);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d+readDouble);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s+" "+readString);
    }

    static void distributeChocolates() {
        Scanner scanner = new Scanner(System.in);

        String numOfTestCases = scanner.nextLine();
        String numOfColleagues = scanner.nextLine();
        String chocoloates = scanner.nextLine();
        String[] chocoArr = chocoloates.split(" ");
        List<Integer> chocoList = Arrays.asList(chocoArr).stream()
                .map(n -> Integer.parseInt(n)).collect(Collectors.toList());
        Integer max = chocoList.stream().max((n1,n2) -> n1.compareTo(n2)).get();
        Map<Integer,Integer> diffMap = new HashMap<>();
        int diff = 0;
        while (true) {



        }
    }

    static boolean equals(List<Integer> list) {
        return list.stream().distinct().toArray().length == 1;
    }

    static List<Integer> calculateAdd() {
        return Arrays.asList(new Integer[]{1,2,5,3,6,7,8});
    }

    static void doReverse() {
        String str = "I love to code";
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        while(length>0) {
            sb.append(reverse(str.substring(0,length)));
            length--;
        }
    }

    static char reverse(String str) {
        return str.charAt(str.length()-1);
    }

    static void largestWord(String string) {
        String[] strArr = string.split(" ");
        int max =0;
        String word = "";
        Pattern p = Pattern.compile("\\W");
        for (String str: strArr) {
            Matcher m = p.matcher(str);
            if(!m.find()) {
                if (str.length() > max) {
                    max = str.length();
                    word = str;
                }
            }
        }
        System.out.println(word);
    }
}
