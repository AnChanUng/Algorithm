import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, countRepaint(i, j));
            }
        }

        System.out.println(answer);
    }

    static int countRepaint(int x, int y) {
        int firstWhite = 0;
        int firstBlack = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                char current = board[x+i][y+j];

                if ((i + j) % 2 == 0) {
                    if(current != 'W') firstWhite++;
                    if(current != 'B') firstBlack++;
                } else {
                    if(current != 'B') firstWhite++;
                    if(current != 'W') firstBlack++;
                }
            }
        }

        return Math.min(firstWhite, firstBlack);
    }
}