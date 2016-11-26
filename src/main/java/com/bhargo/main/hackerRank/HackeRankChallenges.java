package com.bhargo.main.hackerRank;

import com.bhargo.main.model.Shop;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
//import java.util.regex.Matcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by barya on 8/3/16.
 */
public class HackeRankChallenges {

    public static void kaprekarNumbers() {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = scanner.nextInt();
        int upperBound = scanner.nextInt();
        BigInteger square = null;
        BigInteger value = null;
        int count=0;
        int sum = 0;
        for(int i = lowerBound;i<=upperBound;i++) {
            value = new BigInteger(new Integer(i).toString());
            square = value.multiply(value);
           if(square.toString().equals("1") ||square.toString().length() > 1) {
                if(!square.toString().equals("1")) {
                    sum =Integer.valueOf(square.toString().substring(0,square.toString().length()/2)) +
                            Integer.valueOf(square.toString().substring(square.toString().length()/2,square.toString().length()));
                }
                if(sum == i || square.toString().equals("1")) {
                    count++;
                    System.out.print(i + " ");
                }
            }
        }
        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }

    public static void findDigits() {
        int[] data = readIntAsIntArr();
        int[] count = new int[]{0};
        Arrays.stream(data).forEach(n -> {
            count[0] = 0;
            Arrays.stream(new Integer(n).toString().split("")).forEach(m -> {
                if(!"0".equals(m) && n % Integer.valueOf(m) == 0) {
                    count[0] += 1;
                }
            });
            System.out.println(count[0]);
        });
    }

    private static int[] readIntAsIntArr() {
        Scanner scanner = new Scanner(System.in);
        int numOfTc = scanner.nextInt();
        int[] data =new int[numOfTc];
        for(int i =0;i<numOfTc;i++) {
            data[i] = scanner.nextInt();
        }
        return data;
    }

    public static void utopianTre() {
        int[] data = readIntAsIntArr();

        int[] init = new int[]{1};
        Arrays.stream(data).forEach(n ->{
            init[0] = 1;
            if(n !=0)  {
                if(n == 1) {
                    System.out.println(init[0]*2);
                }
                else if(n % 2 == 0) {
                    for (int j =0;j<n/2;j++) {
                        init[0] = init[0]*2+1;
                    }
                } else {
                    for (int j =0;j<=n/2;j++) {
                        init[0] = init[0]*2+1;
                    }
                    init[0] = init[0]-1;
                }
            }
            if(n != 1)
            System.out.println(init[0]);
        });
    }

    public static void designerPdfViewer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = null;
        String word = null;
        for(int i =0;i<=1;i++) {
            if(i == 0){
                data = br.readLine().split(" ");
            }
            else {
                word = br.readLine();
            }
        }
        Map<Character, String> charToHeightMap = new HashMap<>();

        class alphabet implements Comparable<alphabet> {

            private char c;
            private int height;

            public alphabet(char c, int height) {
                this.c = c;
                this.height = height;
            }

            public int getHeight() {
                return height;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                alphabet alphabet = (alphabet) o;
                return c == alphabet.c;
            }

            @Override
            public int hashCode() {
                return Objects.hash(c);
            }

            @Override
            public int compareTo(alphabet o) {
                if(this.getHeight() == o.getHeight()) {
                    return 0;
                } else if(this.getHeight() < o.getHeight()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

        List<alphabet> list = new ArrayList<alphabet>();
        int index=0;
        for(char c ='a';c<='z';c++) {
            charToHeightMap.put(c,data[index]);
            index++;
        }
        Arrays.stream(word.split("")).forEach(n -> list.add(new alphabet(n.charAt(0),Integer.valueOf(charToHeightMap.get(n.charAt(0))))));
        Collections.sort(list);

        System.out.println(list.get(list.size()-1).getHeight()*list.size());


    }

    public static void timeConversion() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String data = bufferedReader.readLine();
        int newHour;
        if(data.contains("P")) {
            String hours = data.split(":")[0];
            if(hours.substring(0,1).equals("0")) {
                newHour = 12+Integer.valueOf(hours.substring(1,2));
            } else {
                if(hours.equals("12")) {
                    newHour = Integer.valueOf(hours);
                } else {
                    newHour = 12+Integer.valueOf(hours);
                }
            }
            System.out.println(newHour+":"+data.split(":")[1]+":"+data.split(":")[2].replace("PM",""));
        } else  {
            if(data.substring(0,2).equals("12")) {
                System.out.println("00"+":"+data.split(":")[1]+":"+data.split(":")[2].replace("AM",""));
            } else {
                System.out.println(data.replace("AM",""));
            }
        }
    }

    public static void veryBigSum() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] data = bufferedReader.readLine().split(" ");
        System.out.println(doSum(data));
    }

    public static void cutTheSticks() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfSticks = Integer.valueOf(bufferedReader.readLine());
        List<String> data = Arrays.stream(bufferedReader.readLine().split(" ")).map(n -> n).collect(Collectors.toList());

        Integer[] minimum=new Integer[1];
        Integer[] counter = new Integer[]{new Integer(0)};
        while(data.stream().distinct().count() != 1L || !data.stream().distinct().collect(Collectors.toList()).get(0).equals("0")){
            minimum[0] = data.stream().map(n -> Integer.valueOf(n)).filter(n -> n != 0).min(Comparator.naturalOrder()).get();
            if(minimum[0] != null) {
                counter[0] = 0;
                data = data.stream().filter(n -> !n.equals("0")).map(n -> {
                    counter[0] = counter[0]+1;
                    return Integer.toString(Integer.valueOf(n) - Integer.valueOf(minimum[0]));
                }).collect(Collectors.toList());
                System.out.println(counter[0]);
            }
        }
    }

    public static void beautifulDays() {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        String[] arr = data.split(" ");
        int count =0;
        for(Integer i = Integer.valueOf(arr[0]);
            i.compareTo(Integer.valueOf(arr[1])) <=0;
            i = Math.incrementExact(i)) {
            if(Math.abs(
                    i - Integer.valueOf(trimLeadingZeroes(doReverse(i.toString())))
            )%Integer.valueOf(arr[2]) == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static String trimLeadingZeroes(String str) {
        StringBuffer sb = new StringBuffer();
        boolean initialZero=true;
        for (int i =0;i<=str.length()-1;i++) {
            if(initialZero){
                if(!str.substring(i, i+1).equals("0")) {
                    initialZero = false;
                    sb.append(str.substring(i, i+1));
                }
            } else {
                sb.append(str.substring(i, i+1));
            }
        }
        return sb.toString();
    }

    public static void sumNumbers(boolean readFromFile) throws IOException {
        String[] arr=null;
        if(readFromFile) {
            File file = new File("C:\\Users\\barya\\data.txt.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data = null;
            while((data = bufferedReader.readLine()) != null) {
                arr = data.split(" ");
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();arr = data.split(" ");
        }

        Arrays.sort(arr);
        String[] ans =doDiff(doSum(arr),arr[0]);
        for(int j = 0;j<ans.length;j++) {
            System.out.print(ans[j]);
        }
        System.out.println();
        ans = doDiff(doSum(arr),arr[4]);
        for(int j = 0;j<ans.length;j++) {
            System.out.print(ans[j]);
        }
    }

    private static String doSum(String[] arr) throws IOException {
        String temp = "0",sum;
        String[] result = null;

        String[] total = new String[]{"0"};
        StringBuffer sb;

        for(int i =0;i<=arr.length-1;i++) {
            if(arr[i].length() > total[0].length()) {
                total[0] = append(arr[i], total[0]);
            } else if(arr[i].length() < total[0].length()){
                arr[i] = append(arr[i], total[0]);
            }

            result = new String[total[0].length()];
            for (int j =total[0].length()-1; j>=0; j--) {
                sum = sum(Integer.valueOf(total[0].substring(j, j+1)),
                        Integer.valueOf(arr[i].substring(j, j+1)), temp);
                if(sum.length() == 2) {
                    if(j == 0) {
                        result[j] = sum;
                        temp = "0";
                    } else {
                        temp = sum.substring(0,1);
                        result[j] = sum.substring(1,2);
                    }
                } else {
                    result[j] = sum;
                    temp = "0";
                }
            }

            sb = new StringBuffer("");
            for(String str: result) {
                sb.append(str);
            }
            total[0] = sb.toString();
        }
        return total[0];
    }

    public static String[] doDiff(String first, String second) {
        Integer firstInt, secondInt;
        boolean flag=false;
        if(first.length() < second.length()) {
            first = append(first, second);
        } else if(second.length() < first.length()) {
            second = append(second, first);
        }

        String[] result = new String[second.length()];
        for(int i =second.length()-1;i>=0;i--) {
            firstInt = Integer.valueOf(first.substring(i,i+1));
            secondInt = Integer.valueOf(second.substring(i,i+1));
            if(flag) {
                if(firstInt-1>=secondInt) {
                    if(secondInt != 0) {
                        result[i] =diff(firstInt-1, secondInt);
                        //System.out.print();
                    } else {
                        result[i] = Integer.toString(firstInt-1);
                        //System.out.print(firstInt-1);
                    }
                    flag = false;
                } else {
                    flag = true;
                    result[i] = diff(firstInt-1+10, secondInt);
                    //System.out.print(diff(firstInt-1+10, secondInt));
                }
            } else {
                if(firstInt>=secondInt) {
                    result[i] = diff(firstInt, secondInt);
                    //System.out.print(diff(firstInt, secondInt));
                    flag = false;
                } else {
                    flag = true;
                    result[i] = diff(firstInt+10, secondInt);
                    //System.out.print(diff(firstInt+10, secondInt));
                }
            }
        }
        return result;
    }

    private static String append(String first, String second) {
        StringBuffer temp = new StringBuffer("");
        for (int i =1;i<=Math.abs(first.length() - second.length());i++) {
            temp.append(0);
        }
        if(first.length() < second.length()){
            return temp.toString().concat(first);
        }else {
            return temp.toString().concat(second);
        }
    }

    private static String sum(int i, int j, String temp) {
        return Integer.toString(i+j+Integer.valueOf(temp));
    }

    public static String diff(int i, int j) {
        return Integer.toString(i -j);
    }

    public static void stairCase() {
        int n = new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            int j = 1;
            for (; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= n - j; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void walMartChallenge() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int numOfJunctions = Integer.parseInt(line);

        int numOfQueues  = Integer.parseInt(br.readLine());
        Map<Node, List<qSpec>> data = new HashMap<>();
        List<List<String>> qData = new ArrayList<>();
        for (int i = 0; i < numOfQueues; i++) {
            qData.add(Arrays.asList(br.readLine().split(" ")));
        }
        Map<String, List<String>> map = new HashMap<>();

        //qData.stream().collect(Collectors.groupingBy(n -> n.get(1))).keySet().stream().sorted((s1,s2) -> -s1.compareTo(s2)).collect(Collectors.toSet());

        List<String> temp;
        for (List<String> list:qData) {
            if(map.containsKey(list.get(1))) {
                temp = map.get(list.get(1));
                temp.add(list.get(0).concat("-").concat(list.get(2)));
                map.put(list.get(1), temp);

            } else {
                temp = new ArrayList<>();
                temp.add(list.get(0).concat("-").concat(list.get(2)));
                map.put(list.get(1), temp);
            }

        }

        //map.forEach((k,v) -> System.out.println(k  + " " + v));

        Set<String> s = map.keySet().stream().sorted((k1,k2) -> k2.compareTo(k1)).collect(Collectors.toSet());
        TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());
        //ts.stream().forEach(System.out::println);

        int[] in =new int[]{0};



        //Set<String> set = map.keySet().stream().sorted((k1,k2) -> k2.compareTo(k1)).collect(Collectors.toSet());
        ts.addAll(map.keySet());
        ts.stream().forEach(key -> {
                Node node = new Node(key);
                List<qSpec> qSpecList = new ArrayList<qSpec>();
                map.get(key).forEach(l -> {
                    Node fromNode = new Node(l.split("-")[0]);
                    Queue<String> q = new PriorityQueue<String>();
                    int t = in[0]+Integer.valueOf(l.split("-")[1]);
                    for (int i =in[0]+1; i<=t;i++) {
                        if(i == in[0]+Integer.valueOf(l.split("-")[1])) {
                            in[0] =i;
                        }
                        q.add(Integer.toString(i));
                    }
                    qSpec value = new qSpec(fromNode, q);
                    if(fromNode.value.equals("3")) {
                        q.add("-1");
                    }
                    qSpecList.add(value);
                });
                data.put(node,qSpecList);

        });
        data.forEach((k,v) -> {
            System.out.println(k + " " + v);
        });

        /*map.entrySet().stream().forEach(n -> {
            Node node = new Node(n.getKey());
            List<qSpec> qSpecList = new ArrayList<qSpec>();
            n.getValue().forEach(l -> {
                Node fromNode = new Node(l.split("-")[0]);
                Queue<String> q = new PriorityQueue<String>();
                for (int i =in[0]+1; i<=in[0]+Integer.valueOf(l.split("-")[1]);i++) {
                    if(i == Integer.valueOf(l.split("-")[1])) {
                        in[0] =i;
                    }
                    q.add(Integer.toString(i));
                }
                qSpec value = new qSpec(fromNode, q);
                if(fromNode.value.equals("3")) {
                    q.add("-1");
                }
                qSpecList.add(value);
            });
            data.put(node,qSpecList);
        });*/

        move(data,"7");

    }

    private static void move(Map<Node, List<qSpec>> data, String root) {
        int turn =0;
        int time =0;
        List<qSpec> list;
        while (true) {
            time++;
            list = data.get(new Node(root));
            if(turn == 0) {
                if(list.get(0).queue.poll().equals("-1"))break;
                if(data.containsKey(list.get(0).fromNode)) {
                    move(data,list.get(0).fromNode.value);
                } else {
                    list.get(0).queue.poll();
                }
                turn = 1;
            } else if(turn == 1) {
                if(list.get(1).queue.poll().equals("-1"))break;
                if(data.containsKey(list.get(1).fromNode)) {
                    move(data,list.get(1).fromNode.value);
                } else {
                    list.get(0).queue.poll();
                }
                turn = 0;
            }
        }
        System.out.println(time);
    }

    static class Node {
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    private static class qSpec {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            qSpec qSpec = (qSpec) o;
            return Objects.equals(fromNode, qSpec.fromNode) &&
                    Objects.equals(queue, qSpec.queue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromNode, queue);
        }

        private Node fromNode;
        private Queue<String> queue;

        public qSpec(Node fromNode, Queue<String> queue) {
            this.fromNode = fromNode;
            this.queue = queue;
        }

        public void addToQueue(String in) {
            queue.add(in);
        }

        public String removeFromQueue() {
            if(queue.size() != 0)
            return queue.poll();
            return null;
        }

        @Override
        public String toString() {
            return "qSpec{" +
                    "fromNode=" + fromNode +
                    ", queue=" + queue +
                    '}';
        }
    }

    static Integer counter = new Integer(0);

    private static boolean decreaseRec(List<Integer> upperList, List<Integer> lowerList, int index, int[] count) {
        int valueUpper = upperList.get(index);
        int valueLower = lowerList.get(index);
        if(index == 0 && valueUpper != 0 && valueLower != 0) {
            upperList.set(index, valueUpper -1);
            lowerList.set(index, valueLower -1);
            return true;
        } else if(index ==0 && valueUpper == 0 && valueLower == 0) {
            return false;
        }
        if(valueUpper == 0 && valueLower == 0)
            return false;
        else {
            upperList.set(index, valueUpper -1);
            lowerList.set(index, valueLower -1);
            decreaseRec(upperList,lowerList, index -1, count);
        }
        return false;
    }

    private static boolean isEverythingSame(List<Integer> list, int num) {
        Set<Integer> set = list.stream().distinct().collect(Collectors.toSet());
        return set.size() ==1 && set.contains(num);
    }

    public static void dynamicFactorial() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long N = Long.parseLong(line);
        List<Long> list = new ArrayList<>();
        list.add(0,1L);list.add(1,1L);list.add(2,2L);
        for (int i = 0; i < N; i++) {
            System.out.println(fact(Integer.parseInt(br.readLine()), list));
        }
    }

    private static long fact(int n, List<Long> list) {
        if(n == 0 || n == 1)
            return list.get(0);
        else if(n ==2)
            return list.get(2);
        if(list.size() >n)
            return list.get(n);

        for(int j =3;j<=n;j++) {
            list.add(j,j*list.get(j-1));
        }
        return list.get(n);

        /*if(list.size() <= n+1) {
            list.add(n,n*fact(n-1, list));
            return list.get(n);
        } else {
            return list.get(n);
        }*/

    }

    /**
     * Dynamic programming example
     */
    public static void samuAndShopping() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int  numOfTestCases = Integer.parseInt(line);
        List<Shop> shopList = new ArrayList<>();

        String[] temp;
        for(int i =1;i<=numOfTestCases;i++) {
            int numOfShops = Integer.valueOf(br.readLine());
            for (int j =1;j<=numOfShops;j++) {
                temp = br.readLine().split(" ");
                shopList.add(new Shop(Integer.valueOf(temp[0]),Integer.valueOf(temp[1]),Integer.valueOf(temp[2])));
            }
        }
        shopList.forEach(System.out::println);

    }


    public static void hopClouds() {
        int count =0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int initLoc = 0;
        while(initLoc < n-1) {
            if(initLoc+2 < n && c[initLoc + 2] == 0) {
                count++;
                initLoc = initLoc +2;
            } else if(initLoc+1 < n && c[initLoc + 1] == 0) {
                count++;
                initLoc = initLoc +1;
            }
        }
        System.out.println(count);
    }

    public static void stringConstruction() {
        String s="";
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            s = in.next();
            String p ="";
            int i =0,cost =0;
            String sub;
            while (p.length() != s.length()) {
                sub = Character.toString(s.charAt(i));
                p=p.concat(sub);
                cost++;
                if(s.substring(i+1,s.length()).startsWith(p)) {
                    p = p.concat(p);
                }
                i++;
            }
            System.out.println(cost);
        }

    }

    public  static void sos(String s) {
        int length = s.length();
        int count=0;
        int i =1;String sub;
        while(i<=length) {
            sub = s.substring(i-1,i+2);
            if(!"SOS".equals(sub)) {
                if(sub.charAt(0) != 'S') {
                    count++;
                }
                if(sub.charAt(2) != 'S') {
                    count++;
                }
                if(sub.charAt(1) != 'O') {
                    count++;
                }

            }
            i =i+3;
        }
        System.out.println(count);
    }

    public static void camelCase(String s) {
        int i =0,count =0;
        while (i<s.length()) {
            if(Character.valueOf(s.charAt(i)).compareTo(s.substring(i,i+1).toUpperCase().charAt(0)) == 0) {
                count++;
            }
            i++;
        }
        System.out.println(++count);
    }

    public static void queueUsningStack(String[] args) throws IOException {
        List<String> opsList = new ArrayList<>();
        int numOfOps=0;

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int numOfFLines=0; boolean isFirstLine=true;
        List<String> sentenceList = new ArrayList<>();
        while ((line = buffer.readLine()) != null) {
            if(isFirstLine) {
                isFirstLine = false;
                numOfOps = Integer.valueOf(line);
            } else {
                opsList.add(line);
            }

        }

        /*Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\n");
        scanner.useDelimiter(pattern);

        numOfOps = scanner.nextInt();

        for(int i =0;i<=numOfOps;i++) {
            opsList.add(scanner.nextLine());
        }
        opsList.remove(0);*/

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        List<String> temp = new ArrayList<>();
        Stack<String>[] stackPushPop = new Stack[]{stack1,stack2};
        int[] i =new int[]{1};

        opsList.forEach(n ->{
            if(n.substring(0,1).equals("1")) {
                while(stack2.size() >0) {
                    stack1.push(stack2.pop());
                }
                stack1.push(n.split(" ")[1]);
            } else if(n.substring(0,1).equals("2")) {
                while( stack1.size() > 1) {
                    stack2.push(stack1.pop());
                }
                if(stack1.size() > 0) {
                    stack1.pop();
                } else
                    stack2.pop();
            } else if(n.substring(0,1).equals("3")) {
                while( stack1.size() > 1) {
                    stack2.push(stack1.pop());
                }
                if(stack1.size() > 0)
                System.out.println(stack1.peek());
                else System.out.println(stack2.peek());
            }
        });
    }

    private static String ops(Stack<String> stack, String code) {
        String value;
        switch (code) {
            case "2": value = stack.pop();break;
            case "3": value = stack.peek();break;
            default: value = "";
        }
        return value;
    }

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

    public static void  arrayLeftRotation(boolean readFromFile) throws IOException {
        int numOfQueries=0, numOfRotations=0, originalIndex=0;
        int[] queriesArr=null;
        String[] data=null, metadata = null;
        if(!readFromFile){
            Scanner scanner = new Scanner(System.in);
            Pattern pattern = Pattern.compile("\\n");
            scanner.useDelimiter(pattern);

            metadata = scanner.nextLine().split(" ");
            numOfRotations = Integer.valueOf(metadata[1]);

            data = scanner.nextLine().split(" ");

            if(data.length != Integer.valueOf(metadata[0])) {
                throw new IllegalArgumentException();
            }


            numOfQueries = Integer.valueOf(metadata[2]);
            queriesArr = new int[numOfQueries];
            for (int i =0;i<numOfQueries;i++) {
                queriesArr[i] = scanner.nextInt();
            }
        } else {
            File file = new File("");
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(file));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                metadata = line.split(" ");
            }
        }

        for (int index: queriesArr) {
            if(numOfRotations % data.length == 0 || numOfRotations == 0) {
                originalIndex = index;
            } else {
                originalIndex =index - numOfRotations;
                if(originalIndex < 0) {
                    originalIndex += data.length;
                }
            }
            System.out.println(data[originalIndex]);
        }
    }

    public static void diagonalDifference() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\n");
        scanner.useDelimiter(pattern);

        int matrixSize = scanner.nextInt();

        String[][] matrix = new String[matrixSize][matrixSize];

        for(int i =-1;i<=matrixSize-1;i++) {
            if(i == -1){
                scanner.nextLine();
            }
            else
                matrix[i] = scanner.nextLine().split(" ");
        }

        int temp1=0,temp2=matrixSize-1;

        int[] resultArr = new int[matrixSize];
        for(int i =0;i<matrixSize;i++) {
            if(temp1 != temp2) {
                resultArr[i] = Integer.valueOf(matrix[i][temp1]) - Integer.valueOf(matrix[i][temp2]);
            }
            temp1++;temp2--;
        }

        System.out.println(Math.abs(Arrays.stream(resultArr).sum()));
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

    private static String doReverse(String str) {
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        while(length>0) {
            sb.append(reverse(str.substring(0,length)));
            length--;
        }
        return sb.toString();
    }

    private static char reverse(String str) {
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

    private static List<String> readFile(String fileLoc) throws IOException {
        File file = new File(fileLoc);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<String> list = new ArrayList<>();
        while((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        bufferedReader.close();
        return list;
    }
}
