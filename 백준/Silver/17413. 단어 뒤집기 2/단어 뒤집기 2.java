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

            if(flag) { // < 안일 때
                word.append(ch);
                if(ch == '>') {
                    flag = false;
                }
            } else { // < 아닐때
                if(ch == '<') {
                    word.append(out.reverse());
                    out.setLength(0);
                    word.append(ch);
                    flag = true;
                } else if (ch == ' ') {
                    word.append(out.reverse());
                    out.setLength(0);
                    word.append(ch);
                } else {
                    out.append(ch);
                }
            }
        }
        System.out.print(word);
        System.out.print(out.reverse());
    }
}