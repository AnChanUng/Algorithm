import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];
        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = inputs[0];
            arr[i][1] = inputs[1];
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
           } 
        });

        for(int i=0; i<n; i++) {
            System.out.print(arr[i][0] + " ");
            System.out.println(arr[i][1]);
        }
    }
}