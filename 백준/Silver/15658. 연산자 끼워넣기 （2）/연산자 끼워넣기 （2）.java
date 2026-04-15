import java.util.*;
import java.io.*;
/*
  n 자리 숫자를 계산 했을 때, 최대값 최소값
  숫자는 n개, 자리수 고정
  연산자는 위치 바뀔 수 있음
*/
class Main {
  static int n;
  static int[] arr;
  static int[] oper;
  static boolean[] vis;
  static int maxNum = Integer.MIN_VALUE;
  static int minNum = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n];  // 
    oper = new int[4]; // + - x / 개수
    vis = new boolean[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<4; i++) {
      oper[i] = Integer.parseInt(st.nextToken());
    }

    dfs(arr[0], 1);
    System.out.println(maxNum);
    System.out.println(minNum);
  }

  static void dfs(int sum, int depth) {
    if(depth == n) {
      maxNum = Math.max(maxNum, sum);
      minNum = Math.min(minNum, sum);
      return;
    }
    for(int j=0; j<4; j++) {
      if(oper[j] > 0) {
        oper[j]--;
        if(j == 0) dfs(sum + arr[depth], depth+1);
        else if (j == 1) dfs(sum - arr[depth], depth+1);
        else if (j == 2) dfs(sum * arr[depth], depth+1);
        else if (j == 3) dfs(sum / arr[depth], depth+1);
        oper[j]++;
      }
    }
  }
}