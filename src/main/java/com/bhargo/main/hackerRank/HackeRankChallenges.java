package com.bhargo.main.hackerRank;

import java.io.*;
import java.util.*;
//import java.util.regex.Matcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by barya on 8/3/16.
 */
public class HackeRankChallenges {

    public static void compareTriplets() {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int aliceScore =0,bobScore=0;
        if(a0 > b0) {
            aliceScore++;
        } else if(b0 > a0) {
            bobScore++;
        }
        if(a1 > b1) {
            aliceScore++;
        } else if(b1 > a1) {
            bobScore++;
        }
        if(a2 > b2) {
            aliceScore++;
        } else if(b2 > a2) {
            bobScore++;
        }
        System.out.println(aliceScore + " " + bobScore);
    }

    public static void arraySum() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\n");
        scanner.useDelimiter(pattern);

        String size = scanner.nextLine();

        String[] data = scanner.nextLine().split(" ");
        int[] sum =new int[1];
        Arrays.asList(data).stream().map(n -> Integer.valueOf(n)).forEach(n -> sum[0] = sum[0] + n);
        System.out.println(sum[0]);
    }

    public static void  arrayLeftRotation() throws IOException {
        String temp;
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\n");
        scanner.useDelimiter(pattern);

        String[] metadata = scanner.nextLine().split(" ");
        int numOfRotations = Integer.valueOf(metadata[1]);

        String[] data = scanner.nextLine().split(" ");

        while (numOfRotations > 0){
            String numToSwap = data[0];
            for(int i =data.length -1;i>=0;i--) {
                temp  = data[i];
                data[i] = numToSwap;
                numToSwap = temp;
            }
            numOfRotations--;
        }
        for (String str: data) {
            System.out.print(str + " ");
        }
    }

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
