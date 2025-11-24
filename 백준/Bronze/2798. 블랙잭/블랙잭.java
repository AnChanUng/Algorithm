import java.util.Scanner;
/*
    N장의 카드 중에서 3장을 고른 카드의 합 <= M 최대 합

    문제
    1.1 카드의 개수(n), 합(m) 입력 받기
    1.2 n개의 카드에 쓰여 있는 수 입력 받기
    2   3중 for문
    2.1 arr[i] + arr[i+1] + arr[i+2] 합이 m 미만이면 최대 값 업데이트
    3   최대 값 출력

    접근 방식
    - 모든 경우의 수 완전 탐색 (3중 for문)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = 0;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=i+1; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= m) {
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}