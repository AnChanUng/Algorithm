import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        } 
        
        if(num == 2) {
            return true;
        } 

        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=m; i<=n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            } 
        }
    }
}