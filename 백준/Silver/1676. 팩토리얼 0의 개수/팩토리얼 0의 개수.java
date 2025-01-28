import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(num >= 5) {
            cnt += num / 5;
            num /= 5;
        }
        
        System.out.println(cnt);
    }
}