import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    몸무게, 키가 큰 순서대로 내림차순 정렬
    몸무게 > 키, 키 < 몸무게일 경우 등수 동점

    문제
    1.1 전체 사람 수(n) 입력 받기
    1.2 n개의 줄에 몸무게(x), 키(y) 입력 받기
    2   몸무게, 키 순 내림차순 정렬
    3   입력받은대로 등수 출력
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            String parts[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(parts[0]);
            arr[i][1] = Integer.parseInt(parts[1]);
        }

        int rank[] = new int[n];
        Arrays.fill(rank, 1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    rank[i]++;
                }
            }
        }
        for(int i=0; i<rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}