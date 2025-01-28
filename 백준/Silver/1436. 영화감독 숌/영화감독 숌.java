import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int number = 665;
        while(true) {
            number++;
            if(String.valueOf(number).contains("666")) {
                cnt++;
            }

            if(cnt == n) {
                System.out.println(number);
                break;
            }
        }
    }
}