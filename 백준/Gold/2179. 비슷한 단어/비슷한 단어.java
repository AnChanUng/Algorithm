import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] res = new String[n];
        int[] idx = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = br.readLine();
            idx[i] = i;
        }

        String[] arr = new String[n];
        arr = res.clone();
        
        Arrays.sort(arr);

        String a2 = "";
        String b2 = "";
        int maxLen = 0;
        for(int i=0; i<n-1; i++) {
            if(arr[i].charAt(0) != arr[i+1].charAt(0)) continue;

            int a = arr[i].length();
            int b = arr[i+1].length();            
            int minLen = Math.min(a, b);
            
            // substring(0 ~ 길이최소 다를때까지 비교)
            for(int j=1; j<=minLen; j++) {
                String a1 = arr[i].substring(0, j);
                String b1 = arr[i+1].substring(0, j);
                if(a1.equals(b1)) {
                    if(j > maxLen) {
                        a2 = arr[i];
                        b2 = arr[i+1];
                        maxLen = j;
                    }
                } else {
                    break;
                }
            }
        }
        //System.out.println(a2 + " " + b2);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int minLen = Math.min(res[i].length(), res[j].length());
                if(minLen < maxLen) continue;
                String a1 = res[i].substring(0, maxLen);
                String b1 = res[j].substring(0, maxLen);
                if(a1.equals(b1)) {
                    System.out.println(res[i]);
                    System.out.println(res[j]);
                    return;
                }
            }
        }
    }
}