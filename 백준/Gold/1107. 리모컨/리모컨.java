import java.util.*;
import java.io.*;
/* 
    현재채널 100에서 리모콘의 버튼 + -를 눌러 채널 n 만들기 
    
    1. 현재 채널 100번
    2.1 n과 최대한 가까운 수를 리모콘으로 누른다
    2.2 그 숫자는 arr 배열에 없는 숫자여야한다
    2.3 n과의 차이만큼 ++나 --를 눌러준다.
    3  눌른 횟수 출력
*/
public class Main {
    static int n, m;
    static List<Integer> list;
    static int minNum = 100;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 수빈이가 이동하려고 하는 채널
        m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        // 1.배열에 0~9를 넣고 arr에 해당하는 숫자는 지운다.
        list = new ArrayList<>();
        for(int i=0; i<=9; i++) {
            list.add(i);
        }

        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) { 
                int a = Integer.parseInt(st.nextToken()); // 고장난 버튼
                if(list.contains(Integer.valueOf(a))) {
                    list.remove(Integer.valueOf(a));
                }
            }
        }
    
        // 2.1 배열에 들어있는 수로 n과 가장 가까운 수를 만든다
        // 2.2 만들때에는 숫자를 누를때마다 1씩 카운트한다
        if(n == minNum) { 
            System.out.println(0);
            return;
        } else {
            for(int i=1; i<=String.valueOf(n).length()+1; i++) {
                dfs("", 0, i);
            }
        }
        int ans = Math.abs(n-100);
        if(minDiff != Integer.MAX_VALUE) {
            ans = Math.min(ans, String.valueOf(minNum).length() + minDiff);
        }
        System.out.println(ans);
    }
    static void dfs(String str, int depth, int targetLen) {
        // 초기값이랑 n이랑 같으면 끝
        if(depth == targetLen) {
            int diff = Math.abs(n - Integer.parseInt(str));
            if(diff < minDiff) { // diff가 더 작으면
                minDiff = diff;
                minNum = Integer.parseInt(str);
            }
            return;
        }
        for(int i=0; i<list.size(); i++) {
            dfs(str + list.get(i), depth+1, targetLen);
        }
    }
}