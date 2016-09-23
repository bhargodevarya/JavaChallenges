package com.bhargo.main.hackerearth.sepCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by barya on 9/19/16.
 */
public class SepCircuitsChallenges {

    public static void fredoAndLargeNumbers() {

    }

    public static void printHackerEarth() throws IOException {
        List<String> shouldOccurTwiceList = Arrays.asList(new String[]{"h","a","e","r"});
        List<String> shouldOccurOnceList = Arrays.asList(new String[]{"c","k","t"});
        Map<String, Integer> singleOccuranceMap = new HashMap<>();
        Map<String, Integer> doubleOccuranceMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String str = br.readLine();
        Arrays.asList(str.split("")).stream().forEach(n -> {
            if(shouldOccurOnceList.contains(n)) {
                if(singleOccuranceMap.keySet().contains(n)) {
                    int count = singleOccuranceMap.get(n);
                    singleOccuranceMap.put(n, ++count);
                } else {
                    singleOccuranceMap.put(n, 1);
                }
            } else if(shouldOccurTwiceList.contains(n)) {
                if(doubleOccuranceMap.keySet().contains(n)) {
                    int count = doubleOccuranceMap.get(n);
                    doubleOccuranceMap.put(n, ++count);
                } else {
                    doubleOccuranceMap.put(n, 1);
                }
            }
        });

        if(singleOccuranceMap.keySet().size() <3 || doubleOccuranceMap.keySet().size() < 4
                || doubleOccuranceMap.values().contains(1)) {
            System.out.println(0);
            return;
        }

        int minEvenOcc = minOccurance(doubleOccuranceMap)/2;
        List<Integer> list =singleOccuranceMap.values().stream().collect(Collectors.toList());
        Collections.sort(list);
        int minSingleOcc = list.get(0);

        int max = minEvenOcc >= minSingleOcc ? minEvenOcc : minSingleOcc;

        System.out.println(max);

    }

    private static int minOccurance(Map<String, Integer> doubleOccuranceMap) {
        List<Integer> list = new ArrayList<>();
        doubleOccuranceMap.values().stream().forEach(n -> {
            if(n % 2 != 0) {
                list.add(n-1);
            } else {
                list.add(n);
            }
        });
        Collections.sort(list);
        return list.get(0);
    }
}
