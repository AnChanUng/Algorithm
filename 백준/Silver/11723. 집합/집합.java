import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int set = 0;

        for(int i=0; i<m; i++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          String a = st.nextToken();

          if(a.equals("all")) {
          set = (1 << 20) - 1;
          } else if(a.equals("empty")) {
              set = 0;
          } else {
              int b = Integer.parseInt(st.nextToken());
              int mask = 1 << (b - 1);
              
              if(a.equals("add")) {
                  set |= mask;
              } else if(a.equals("remove")) {
                  set &= ~mask;
              } else if(a.equals("check")) {
                  sb.append((set & mask) != 0 ? 1 : 0).append('\n');
              } else if(a.equals("toggle")) {
                  set ^= mask;
              }
          }
        }
        System.out.print(sb);
    }
}