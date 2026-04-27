import java.util.*;
import java.lang.*;
import java.io.*;
/*
    n번째 감소하는 수 출력
    없으면 -1 출력
*/
class Main {
    static List<Long> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetNum = Integer.parseInt(br.readLine());
        
        // 0~9로 시작하는 모든 감소수 만들기
        for(int i = 0; i <= 9; i++) {
            dfs(i, i);
        }
        
        Collections.sort(list);
        
        if(targetNum >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(targetNum));
        }
    }
    
    // num: 지금까지 만든 감소수
    // last: 마지막 자릿수 (다음에 올 숫자는 이것보다 작아야 함)
    static void dfs(long num, int last) {
        list.add(num);
        for(int i = 0; i < last; i++) {
            dfs(num * 10 + i, i);
        }
    }
}