import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int test_case=1; test_case<=10; test_case++) {
            int n = Integer.parseInt(br.readLine()); // 원본 암호문의 길이

            List<String> password = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) { 
                password.add(st.nextToken());
            }

            int orderCnt = Integer.parseInt(br.readLine()); // 명령어의 개수
            String[] order = new String[orderCnt];
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                String cmd = st.nextToken(); 
                
                if(cmd.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int i=0; i<y; i++) {
                        password.add(x+i, st.nextToken());
                    }
                } else if (cmd.equals("D")) {
                	int a = Integer.parseInt(st.nextToken());
                	int b = Integer.parseInt(st.nextToken());
                	for(int i=0; i<b; i++) {
                		password.remove(a);
                	}
                }
            }
            
            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<10; i++) {
                sb.append(password.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}