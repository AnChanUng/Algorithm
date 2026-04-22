import java.util.*;
import java.lang.*;
import java.io.*;
/*
    한개이상의 모음과 두개이상의 자음으로 이루어진
    오름차순 문자열 출력

    알고리즘: 조합 dfs
    자료구조: 배열
*/
class Main {
    static int l, c;
    static String[] arr;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[c];
        vis = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++) {
            arr[i] = st.nextToken();
        }
        
        Arrays.sort(arr);
        
        dfs("", 0, 0);
    }
    static void dfs(String str, int start, int depth) {
        // l개의 문자 일때 출력
        if(depth == l) { // 한개이상의 모음과 두개이상의 자음 출력
            int moeum = 0;
            int jaeum = 0;
            for(int i=0; i<str.length(); i++) {    
                char ch = str.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') moeum++;
                else jaeum++;
            }
            if(moeum >= 1 && jaeum >= 2)
            System.out.println(str);
            return;
        }
        for(int i=start; i<c; i++) {
            //if(!vis[i]) {
            //vis[i] = true;
            dfs(str + arr[i], i+1, depth+1); 
        }
    }
}