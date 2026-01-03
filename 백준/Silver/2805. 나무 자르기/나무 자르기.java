import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
    문제
    1.1 나무의 수(N), 나무의 길이(M) 입력 받기
    1.2 나무의 높이 입력 받기
    2.  1부터 입력받은 나무의 최대 길이까지 점점 증가
    2.1 절단기의 나무가 최대값이면 업데이트
    3   최대값 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr[n-1];
        int maxHeight = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            long result = 0;
            for(int i=0; i<n; i++) {
                if(arr[i] >= mid) {
                    result += arr[i] - mid;
                }
            }
            if(result >= m) {
                maxHeight = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(maxHeight);
    }
}