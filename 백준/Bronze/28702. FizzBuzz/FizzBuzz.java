import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        for(int i=0; i<3; i++) {
            String str = br.readLine();
            if(str.charAt(0) == 'F' || str.charAt(0) == 'B') {
                continue;
            } else {
                num = Integer.valueOf(str) + 3 - i;
            }
        }

        if(num % 3 == 0 && num % 5 == 0) {
            System.out.print("FizzBuzz");
        } else if (num % 3 == 0 && num % 5 != 0) {
            System.out.print("Fizz");
        } else if (num % 3 != 0 && num % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(num);
        }
    }
}