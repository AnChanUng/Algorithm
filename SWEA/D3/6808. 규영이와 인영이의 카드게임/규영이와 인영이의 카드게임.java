import java.util.*;
import java.lang.*;
import java.io.*;
/*
 * 규영이와 인영이가 9장씩 카드를 나눠갖는다.
 * 둘의 카드를 비교하며 더 높은 사람이 두카드의 합 만큼 점수를 얻는다
 * 
 * 규영이가 이기는 경우와 지는 경우 몇 가지 인지 구하시오
 * 
 * 알고리즘: 순열 DFS, 백트래킹
 */
class Solution {
	static List<Integer> number;
	static int[] ky;
	static int[] iy;
	static int[] iiy;
	static boolean[] vis;
	static int kyWin, iyWin;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=t; test_case++) {        	       	
        	ky = new int[9];
        	iy = new int[9];
        	vis = new boolean[9];
        	iiy = new int[9];
        	number = new ArrayList<>();
        	for(int i=1; i<=18; i++) {
        		number.add(i);
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<9; i++) {
        		int n = Integer.parseInt(st.nextToken());
        		ky[i] = n;
        		number.remove(Integer.valueOf(n));
        	}
        	
        	for(int i=0; i<number.size(); i++) {
        		iy[i] = number.get(i);
        	}
        	
        	kyWin = 0;
        	iyWin = 0;
        	dfs(0);
            
        	sb.append("#").append(test_case).append(" ").append(kyWin).append(" ").append(iyWin).append("\n");
        }
        System.out.print(sb);
    }
    
    static void dfs(int depth) {
    	if(depth >= 9) {
    		int kyScore = 0;
    		int iyScore = 0;
    		for(int i=0; i<iiy.length; i++) {
    			if(ky[i] > iiy[i]) {
    				kyScore += ky[i] + iiy[i];
    			} else if (ky[i] < iiy[i]) {
    				iyScore += ky[i] + iiy[i];
    			}
    		}
    		
    		if(kyScore > iyScore) {
    			kyWin++;
    		} else if (kyScore < iyScore) {
    			iyWin++;
    		}
    		return;
    	}

    	for(int i=0; i<9; i++) {
    		if(vis[i]) continue;
    		vis[i] = true;
    		iiy[depth] = iy[i];
    		dfs(depth+1);
    		vis[i] = false;
    	}
    }
}