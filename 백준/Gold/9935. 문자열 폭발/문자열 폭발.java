import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String str = br.readLine();
    String bomb = br.readLine();
    int bombLen = bomb.length();
      
    for(int i=0; i<str.length(); i++) {
        sb.append(str.charAt(i));
        boolean flag = false;
        if(sb.length() >= bombLen) {
            for(int j=0; j<bombLen; j++) {
                if(sb.charAt(sb.length()-bombLen+j) != bomb.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) { 
                sb.delete(sb.length()-bombLen, sb.length());
            }
        }
    }

    if(sb.length() == 0) System.out.println("FRULA");
    else System.out.println(sb); 
  }
}