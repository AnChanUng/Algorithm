import java.util.*;
import java.lang.*;
import java.io.*;
/*
    초기값 100에서 n으로 만드는데 버튼을 눌러야하는 횟수
    - 고장난 버튼의 숫자를 제외 (0~9)
    
    1. list에 고장난 버튼을 제외하고 넣기
    2. n과 가장 가까운수 만들기
    3. n - 가장가까운수 만큼 카운트
*/
class Main {
    static int n, m;
    static List<Integer> list;
    static int minDiff = Integer.MAX_VALUE;
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        // 0~9 list에 넣기
        for(int i=0; i<=9; i++) {
            list.add(i);
        }

        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                int a = Integer.parseInt(st.nextToken());
                list.remove(Integer.valueOf(a));
            }
        }

        // n과 가장 가까운수 만들기 dfs
        if(n == 100) {
            System.out.println(0);
            return;
        } else {
            for(int i=1; i<=String.valueOf(n).length()+1; i++) {
                dfs("", 0, i);
            }
        }

        // str이랑 n의 절대값 차이 + str의 길이
        int ans = Math.abs(n-100);
        if(minDiff != Integer.MAX_VALUE) {
            int result = String.valueOf(minNum).length() + Math.abs(n - minNum);
            ans = Math.min(ans, result);
        }
        System.out.println(ans);
        
    }
    static void dfs(String str, int depth, int targetLen) {
        if(depth == targetLen) {
            int diff = Math.abs(n - Integer.parseInt(str));
            if(diff < minDiff) {
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