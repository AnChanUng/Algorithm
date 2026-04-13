import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringBuilder word = new StringBuilder();
        
        String s = br.readLine();
        boolean flag = false;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(flag) {
                out.append(ch);
                if(ch == '>') flag = false;
            } else {
                if(ch == '<') {
                    out.append(word.reverse());
                    word.setLength(0);
                    out.append(ch);
                    flag = true;
                } else if (ch == ' ') {
                    out.append(word.reverse());
                    word.setLength(0);
                    out.append(ch);
                } else {
                    word.append(ch);
                }
            }
        }
        out.append(word.reverse());
        System.out.print(out);
    }
}