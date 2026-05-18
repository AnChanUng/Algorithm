import java.util.*;
import java.io.*;
/*
  가장 많이 나온 점수 (최빈수)
  점수: 0~100점

  1. 0~100점 칸인 101칸의 배열 생성
  2. 각 배열이 들어오면 1씩 증가
  3. 배열 전체에서 가장 큰 수의 인덱스 출력 (인덱스=점수)
*/
class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for(int test=1; test<=t; test++) {
      int tn = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
      int[] arr = new int[101];

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = st.countTokens();

      for(int i=0; i<n; i++) {
        int input = Integer.parseInt(st.nextToken());
        arr[input]++;
      }

      int maxNum = Integer.MIN_VALUE;
      int maxCnt = Integer.MIN_VALUE;
      for(int i=0; i<arr.length; i++) {
        if(maxCnt <= arr[i]) {
          maxCnt = arr[i];
          maxNum = i;
        }
      }

      System.out.println("#" + tn + " " + maxNum);
    }
  } 
}