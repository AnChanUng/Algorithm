import java.util.*;
/*
    tickets[0][0] -> tickets[0][1]
    1. 항공권을 모두 사용해야함
    2. 가능한 경로가 2개 이상일 때, 알파벳 순서가 앞서는 경로를 return
    
    알고리즘: DFS (graph)
    
*/
class Solution {
    static boolean[] vis;
    static List<String> list;
    static String[] res;
    static boolean flag;
    public String[] solution(String[][] tickets) {
        vis = new boolean[tickets.length];
        res = new String[tickets.length+1];
        list = new ArrayList<>();
        flag = false; // 첫번째 return 값만 출력 나머지는 출력x
        // 가능한 경로가 2개 이상일 때, 알파벳 순서가 앞서는 경로를 return
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        list.add("ICN");
        dfs("ICN", tickets, 1);    

        return res;
    }
    static void dfs(String str, String[][] tickets, int depth) {
        if(flag) return;
        if(depth == tickets.length+1) {
            for(int i=0; i<list.size(); i++) {
                res[i] = list.get(i);
            }
            flag = true;
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(!vis[i]) {
                String a = tickets[i][0];
                String b = tickets[i][1];
                if(str.equals(a)) {
                    vis[i] = true;
                    list.add(b);
                    dfs(b, tickets, depth+1);
                    vis[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}