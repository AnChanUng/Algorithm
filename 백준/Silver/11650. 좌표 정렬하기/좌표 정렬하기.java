import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 숫자를 2차원 배열에 넣는다
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputs[0]);
            arr[i][1] = Integer.parseInt(inputs[1]);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
           if(o2[0] != o1[0]) {
               return o1[0] - o2[0];
           } else {
               return o1[1] - o2[1];
           }
        });
        
        for(int i=0; i<n; i++) {
            System.out.print(arr[i][0] + " ");
            System.out.println(arr[i][1]);
        }
    }
}