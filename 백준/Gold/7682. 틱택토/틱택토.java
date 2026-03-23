import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[][] arr = new char[3][3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String line = br.readLine();
            if(line.equals("end")) break;
            
            int idx = 0;
            int oCnt = 0, xCnt = 0;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    arr[i][j] = line.charAt(idx++);
                    if(arr[i][j] == 'X') xCnt++;
                    else if(arr[i][j] == 'O') oCnt++;
                }
            }

            boolean xWin = isWin('X');
            boolean oWin = isWin('O');

            if(xWin && !oWin && xCnt == oCnt + 1) {
                sb.append("valid");
            } else if (oWin && !xWin && xCnt == oCnt) {
                sb.append("valid");
            } else if (!xWin && !oWin && xCnt == 5 && oCnt == 4) {
                sb.append("valid");
            } else {
                sb.append("invalid");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean isWin(char c) {
        for(int i=0; i<3; i++) {
            if(arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) return true;
            if(arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) return true;
        }
        if (arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) return true;
        if (arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) return true;
        return false;
    } 
}