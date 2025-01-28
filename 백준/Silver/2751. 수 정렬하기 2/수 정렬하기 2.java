import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        
        for(int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}