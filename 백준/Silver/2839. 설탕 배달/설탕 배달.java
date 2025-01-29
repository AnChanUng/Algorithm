import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n > 0) {
            if(n % 5 == 0) {
                cnt += n/5;
                break;
            } else {
                n -= 3;
                cnt++;
            }

            if(n < 0) {
                cnt = -1;
            }
        }

        System.out.print(cnt);
    }
}