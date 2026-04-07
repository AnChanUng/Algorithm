import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // for 키 1부터 N까지
        //  빈자리(0)를 왼쪽부터 세면서, arr[키-1]개 건너뜀
        //  그 다음 빈자리에 자기 키 넣음
        int[] res = new int[n];
        for(int i=1; i<=n; i++) {
            int skip = arr[i-1];
            for(int j=0; j<n; j++) {
                if(res[j] == 0) { 
                    if(skip == 0) {
                        res[j] = i; 
                        break;
                    }
                    skip--;
                }
            }
        }

        for(int i=0; i<n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}