import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;

            int cntx = 0;
            int cnto = 0;

            for(int i=0; i<9; i++) {
                if(s.charAt(i) == 'X') cntx++;
                else if(s.charAt(i) == 'O') cnto++;
            }

            boolean xflag = false;
            boolean oflag = false;

            // 가로
            for(int i=0; i<=6; i+=3) {
                if(s.charAt(i) == 'X' && s.charAt(i+1) == 'X' && s.charAt(i+2) == 'X') xflag = true;
                if(s.charAt(i) == 'O' && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'O') oflag = true;
            }

            // 세로
            for(int i=0; i<3; i++) {
                if(s.charAt(i) == 'X' && s.charAt(i+3) == 'X' && s.charAt(i+6) == 'X') xflag = true;
                if(s.charAt(i) == 'O' && s.charAt(i+3) == 'O' && s.charAt(i+6) == 'O') oflag = true;
            }

            // 대각선
            for(int i=0; i<3; i++) {
                if(i == 1) continue;
                if(i == 0) {
                    if(s.charAt(i) == 'X' && s.charAt(i+4) == 'X' && s.charAt(i+8) == 'X') xflag = true;
                    if(s.charAt(i) == 'O' && s.charAt(i+4) == 'O' && s.charAt(i+8) == 'O') oflag = true;
                }

                if(i == 2) {
                    if(s.charAt(i) == 'X' && s.charAt(i+2) == 'X' && s.charAt(i+4) == 'X') xflag = true;
                    if(s.charAt(i) == 'O' && s.charAt(i+2) == 'O' && s.charAt(i+4) == 'O') oflag = true;
                }
            }
            if(cntx != cnto && cntx != cnto+1) {
                System.out.println("invalid");
                continue;
            }
            
            // 무승부 + 꽉참
            if(!xflag && !oflag && cntx == 5 && cnto == 4) {
                System.out.println("valid");
                continue;
            }

            if(oflag && !xflag) {
                if(cnto == cntx) System.out.println("valid");
                else System.out.println("invalid");
                continue;
            } else if (xflag && !oflag) {
                if(cntx - 1 == cnto) System.out.println("valid");
                else System.out.println("invalid");
                continue;
            } else {
                System.out.println("invalid");
            }
        }
    }
}