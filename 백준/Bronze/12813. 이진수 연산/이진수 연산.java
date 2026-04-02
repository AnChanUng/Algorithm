import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        StringBuilder f1 = new StringBuilder();
        StringBuilder f2 = new StringBuilder();
        StringBuilder f3 = new StringBuilder();
        StringBuilder f4 = new StringBuilder();
        StringBuilder f5 = new StringBuilder();
        
        for(int i=0; i<a.length(); i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            int a1 = x - '0';
            int b1 = y - '0';

            // A & B
            if(a1 == 1 && b1 == 1) {
                f1.append(1);
            } else {
                f1.append(0);
            }
            
            // A | B
            if(a1 == 1 || b1 == 1) {
                f2.append(1);
            } else {
                f2.append(0);
            }
            
            // A ^ B (XOR)
            if(a1 == 1 && b1 == 0 || a1 == 0 && b1 == 1) {
                f3.append(1);
            } else {
                f3.append(0);
            }
            
            // ~A 
            if(a1 == 0) {
                f4.append(1);
            } else {
                f4.append(0);
            }
            
            // ~B
            if(b1 == 0) {
                f5.append(1);
            } else {
                f5.append(0);
            }
        }
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
    }
}