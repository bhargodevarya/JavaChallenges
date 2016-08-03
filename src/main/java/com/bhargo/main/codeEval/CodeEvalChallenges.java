package com.bhargo.main.codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by barya on 8/3/16.
 */
public class CodeEvalChallenges {

    static void codeevalCipher(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        String word;
        String binaryText;
        List<String> dataList;
        char ch;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            dataList = Arrays.asList(line.split(" "));
            word = dataList.get(0);binaryText = dataList.get(1);
            StringBuffer sb = new StringBuffer();
            for(int i =0;i<word.length();i++) {
                ch = binaryText.charAt(i);

                switch (new Character(ch).toString()) {
                    case "0":
                        sb.append(word.charAt(i));
                        break;
                    case "1":
                        sb.append(new String(new Character(word.charAt(i)).toString()).toUpperCase());
                        break;
                }
            }
            System.out.println(sb.toString());
        }
    }

    static void codeevalPrintMatrix() {
        String num;
        int length;
        for(int i =1;i<=5;i++) {
            for(int j =1;j<=5;j++) {
                num = Integer.toString(i*j);
                length = num.length();
                System.out.print((i*j));
                for(int s =1;s<(5-length);s++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }

    static void codeevalFizzBuzzChallenge(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        List<Integer> intList = null;
        int firstDivider = 0;
        int secondDivider = 0;
        int upperLimit = 0;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            intList = Arrays.asList(line.split(" ")).stream()
                    .map(n -> Integer.valueOf(n)).collect(Collectors.toList());
            firstDivider = intList.get(0); secondDivider = intList.get(1); upperLimit = intList.get(2);

            for(int i =1;i<=upperLimit;i++) {
                if( i % firstDivider == 0 && i % secondDivider == 0) {
                    System.out.print("FB ");
                } else if(i % firstDivider == 0) {
                    System.out.print("F ");
                } else if(i % secondDivider == 0) {
                    System.out.print("B ");
                } else {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
