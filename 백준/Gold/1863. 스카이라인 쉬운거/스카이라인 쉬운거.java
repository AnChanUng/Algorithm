import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
        1. 입력 값 y가 현재의 y보다 크다면 새로운 건물로 추정
         1.1 크다면 stack에 y 삽입
         1.2 작다면 건물이 끝나는 지점 stack.pop
         1.3 끝나는 지점이라고 추정되는 건물이 없을 때가지 반복
         1.4 반복이 종료된 후, 건물의 높이가 이전 건물의 높이와 같지 않으면 스택에 삽입
        2. 남은 건물의 높이가 0이 아니라면 카운트
        */
        Stack<Integer> stack = new Stack<>();
        int answer = 0; // 완성된 건물 개수    
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                answer++;
            }
            // 높이가 같으면 같은 건물로 추정
            if(!stack.isEmpty() && stack.peek() == y) continue;

            // 이전 높이보다 크거나 비어있으면 새로운 건물로 추정 push
            stack.push(y);
        }
        // 남은 건물 카운트
        for(int v : stack) {
            if(v == 0) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}