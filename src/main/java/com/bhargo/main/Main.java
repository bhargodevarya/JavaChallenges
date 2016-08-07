package com.bhargo.main;

import com.bhargo.main.codeEval.CodeEvalChallenges;
import com.bhargo.main.hackerRank.HackeRankChallenges;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by barya on 7/27/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /*Scanner scanner = new Scanner(System.in);
        int it =scanner.nextInt();
        scanner.useDelimiter(" ");
        String str = scanner.next();

        System.out.println(str);
        AtomicInteger integer = new AtomicInteger(0);
        int i = integer.get();
        integer.compareAndSet(i,i+1);
        CodeEvalChallenges.codeevalPrintMatrix();
        System.out.println(Arrays.asList(str.split("")).contains("s"));*/

       // CodeEvalChallenges.longestLine(args);
       // HackeRankChallenges.arrayLeftRotation();
       // HackeRankChallenges.arraySum();
        HackeRankChallenges.compareTriplets();

    }
}
