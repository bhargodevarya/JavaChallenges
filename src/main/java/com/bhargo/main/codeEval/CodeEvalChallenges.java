package com.bhargo.main.codeEval;

import com.bhargo.main.codeEval.model.CharCount;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by barya on 8/3/16.
 */
public class CodeEvalChallenges {

    public static void huffmansCode(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line="";
        char ch;
        Map<String,Integer> charToCountMap = new HashMap<>();
        while ((line = buffer.readLine()) != null) {

            charToCountMap.clear();
            Arrays.asList(line.split("")).stream().forEach(n -> {
                if(charToCountMap.keySet().contains(n)) {
                    charToCountMap.put(n,charToCountMap.get(n)+1);
                } else {
                    charToCountMap.put(n,1);
                }
            });
            List<CharCount> list = new ArrayList<>();
            charToCountMap.entrySet().stream().forEach(en -> list
                    .add(new CharCount(en.getKey(),en.getValue())));

            Collections.sort(list);

        }
    }

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

    public static void codeevalPrintMatrix() {
        int length;
        for(int i =1;i<=12;i++) {
            for(int j =1;j<=12;j++) {
                length = Integer.toString(i*j).length();
                if(j!=1) {
                    for(int s =1;s<(5-length);s++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(i*j);
            }
            System.out.println();
        }

    }

    public static void reverseSentence(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        String[] arr;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here
            arr = line.split(" ");
            for(int i = arr.length-1;i>=0;i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }

    public static void codeevalFizzBuzzChallenge(String[] args) throws Exception{
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

    public static void removeCharacters(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        List<String> stringList;
        String[] sentence = new String[1];
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            stringList =Arrays.asList(line.split(","));
            sentence[0] = stringList.get(0);
            Arrays.asList(stringList.get(stringList.size()-1).split(""))
                    .stream().filter(n -> !n.equals(" ")).forEach(n ->
                sentence[0] = sentence[0].replaceAll(n,""));
            for (String str: sentence) {
                System.out.println(str);
            }
        }
    }

    public static void longestLine(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int numOfFLines=0; boolean isFirstLine=true;
        List<String> sentenceList = new ArrayList<>();
        while ((line = buffer.readLine()) != null) {
            if(isFirstLine) {
                isFirstLine = false;
                numOfFLines = Integer.valueOf(line);
            }
            sentenceList.add(line);
        }
        sentenceList.stream().sorted((n1,n2) -> -Integer.valueOf(n1.length())
                .compareTo(Integer.valueOf(n2.length()))).limit(numOfFLines).forEach(System.out::println);
    }
}
