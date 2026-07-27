/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
import java.util.*;
import java.io.*;
/*
 * 모든 나무의 키가 첫날 가장 큰 나무와 같아지는 최소 날
 * 
 * 알고리즘: 이분탐색
 *
 * maxHeight 기준 부족한 개수
 * 1. d[i] = maxHeight - arr[i]
 * 2. 물 주는 순서 상관x
 *     +1 a장, +2 b장으로 d[] 변환
 * 3. b = day/2,  a = day-b
 * 4. check(day)
 *    - d[i] 홀수면 +1
 *    - +2는 짝수만
 */
public class Solution {
    static int[] arr;
    static int[] d;
    static int n;
    static int maxHeight; // 가장 큰 나무 높이
 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//BufferedReader br = new BufferedReader(new StringReader(input));
    	StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=t; tc++) {
        	sb.append("#").append(tc).append(" ");
            n = Integer.parseInt(br.readLine());
            
            arr = new int[n];
            d = new int[n];
            
            maxHeight = Integer.MIN_VALUE;
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i]);
            }
            
            for(int i=0; i<n; i++) {
            	d[i] = maxHeight - arr[i]; 
            }
            
            int low = 0;
            int high = Integer.MAX_VALUE;
            int result = 0;
            
            while(low <= high) {
            	int mid = (low + high) / 2;
            	if(check(mid)) {
            		result = mid;
            		high = mid - 1;
            	} else {
            		low = mid + 1;
            	}
            }
            
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(int day) {
    	int b = day / 2; // 짝수날 개수 = +2카드 장수
    	int a = day - b; // 홀수날 개수 = +1카드 장수
    	
    	int odd = 0;
    	int total = 0;
    	for(int i=0; i<n; i++) {
    		total += d[i];
    		if(d[i] % 2 == 1) {
    			odd++;
    		}
    	}
    	
    	if(odd > a) return false; // +1이 창고보다 많으면 false
    	
    	int need2 = (total - odd) / 2;
    	
    	if (need2 <= b) return true; // +2가 창고보다 많으면 true
    	
    	if((odd + (need2 - b) * 2) <= a) { // +2 -> +1 두 장으로 환산
    		return true;
    	}
    	
    	return false;
    }
}