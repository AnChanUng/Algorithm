import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<num; i++) {
            String str = sc.next();
            if(!list.contains(str)) {
                list.add(str);
            }
        }
        
        Collections.sort(list, (s1, s2) -> {
            int lengthCompare = Integer.compare(s1.length(), s2.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.compareTo(s2);
        });
           
        for(String str : list) {
            System.out.println(str);
        }
    }
}