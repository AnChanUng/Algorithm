import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            String strNum = String.valueOf(i);
            boolean flag = false;
            for(int j=0; j<strNum.length(); j++) {
                char ch = strNum.charAt(j);
                if(ch == '3' || ch == '6' || ch == '9') {
                    System.out.print("-");
                    flag = true;
                }
            }
            if(!flag) System.out.print(i);
            System.out.print(" ");
        }
    }
}