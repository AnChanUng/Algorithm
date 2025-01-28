import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputs[0]);
            arr[i][1] = Integer.parseInt(inputs[1]);
        }

        int[] ranks = new int[n];

        for(int i=0; i<n; i++) {
            int rank = 1;
            for(int j=0; j<n; j++) {
                if(i != j) {
                    if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                        rank++;
                    }
                }    
            }
            ranks[i] = rank;
        }

        for(int i=0; i<n; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}