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
        
        int[][] res = new int[n][2];
        // res[i][0] : i에서 보이는 건물 총 개수
        // res[i][1] : 가장 가까운 건물 번호
        
        int[] leftCnt = new int[n];
        int[] leftNear = new int[n];  // 왼쪽에서 가장 가까운 건물 번호 
        int[] rightCnt = new int[n];
        int[] rightNear = new int[n]; // 오른쪽에서 가장 가까운 건물 번호
        
        // 왼쪽 스캔: 단조 감소 스택 (arr[stack] 큰 게 아래)
        int[] stack = new int[n];
        int top = -1;
        for(int i=0; i<n; i++) {
            // arr[i] 이하는 i한테 안 보이니까 pop
            while(top >= 0 && arr[stack[top]] <= arr[i]) {
                top--;
            }
            // 남은 스택이 i에서 왼쪽으로 보이는 건물들
            leftCnt[i] = top + 1;
            leftNear[i] = (top >= 0) ? stack[top] + 1 : 0; // top이 가장 가까움
            stack[++top] = i;
        }
        
        // 오른쪽 스캔: 반대 방향으로 동일
        top = -1;
        for(int i=n-1; i>=0; i--) {
            while(top >= 0 && arr[stack[top]] <= arr[i]) {
                top--;
            }
            rightCnt[i] = top + 1;
            rightNear[i] = (top >= 0) ? stack[top] + 1 : 0;
            stack[++top] = i;
        }
        
        // 왼쪽 + 오른쪽 합치기
        for(int i=0; i<n; i++) {
            res[i][0] = leftCnt[i] + rightCnt[i];
            
            if(res[i][0] == 0) {
                res[i][1] = 0;
            } else if(leftNear[i] == 0) {
                res[i][1] = rightNear[i];
            } else if(rightNear[i] == 0) {
                res[i][1] = leftNear[i];
            } else {
                int leftDist = i - (leftNear[i] - 1);
                int rightDist = (rightNear[i] - 1) - i;
                if(leftDist < rightDist) res[i][1] = leftNear[i];
                else if(rightDist < leftDist) res[i][1] = rightNear[i];
                else res[i][1] = Math.min(leftNear[i], rightNear[i]); // 동률이면 작은 번호
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(res[i][1] == 0) sb.append(0).append('\n');
            else sb.append(res[i][0]).append(' ').append(res[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}