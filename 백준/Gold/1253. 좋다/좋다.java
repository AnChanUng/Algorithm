import java.util.*;
import java.lang.*;
import java.io.*;
/* 
    n개의 수 중 어떤 수가 다른 수 두개의 합으로 나타낼 수 있으면 그 수를 카운트 
*/
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수의 개수

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 배열의 각 원소 arr[i]를 하나씩 기준으로 잡고,
        // 다른 두 수의 합으로 arr[i]를 만들 수 있는가?
        int cnt = 0;  
        for(int i=0; i<n; i++) {
            int left = 0;
            int right = n - 1;
            while(left < right) {                
                if(left == i) { 
                    left++; 
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(arr[i] == sum) {
                    cnt++;
                    break;
                } else if (sum < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}