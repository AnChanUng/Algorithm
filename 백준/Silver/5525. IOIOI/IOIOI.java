import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int ans = 0;
        int k = 0; 

        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                k++;
                if (k >= n) ans++;     
                i++;                   
            } else {
                k = 0;
            }
        }

        System.out.println(ans);
    }
}
