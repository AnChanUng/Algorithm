import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];
       
        for(int i=0; i<n; i++) {
            String inputs = br.readLine();
            arr[i] = inputs.split("");
        }

        String[][] arr1 = new String[8][8]; // W로 시작
        String[][] arr2 = new String[8][8]; // B로 시작
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i+j) % 2 == 0) {
                    arr1[i][j] = "W";
                    arr2[i][j] = "B"; 
                } else {
                    arr1[i][j] = "B";
                    arr2[i][j] = "W";
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int a=0; a<n-7; a++) { 
            for(int b=0; b<m-7; b++) { 
                int count1 = 0;
                int count2 = 0;
                for(int i=a; i<a+8; i++) { 
                    for(int j=b; j<b+8; j++) {
                        if(!arr[i][j].equals(arr1[i-a][j-b])) {
                            count1++;
                        }
                        if(!arr[i][j].equals(arr2[i-a][j-b])) {
                            count2++;
                        }
                    }
                }
                res = Math.min(res, Math.min(count1, count2));
            }
        }
        System.out.println(res);
    }
}