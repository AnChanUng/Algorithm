import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int total = 0;
        int a = 1;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != '*' && i % 2 == 0) {
                total += str.charAt(i) - '0';   
            } else if (str.charAt(i) != '*' && i % 2 == 1) {
                total += (str.charAt(i) - '0') * 3;
            } else {
                if(i % 2 == 0) {
                    a = a * 1; 
                } else {
                    a = a * 3;
                }
            }
        }
        int r = (10 - total % 10);
        int x = 0;
        if(a == 1) {
            x = r;
        } else {
            x = (7 * r) % 10;
        }
        System.out.print(x);
    }
}