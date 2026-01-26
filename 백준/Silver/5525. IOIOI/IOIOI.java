import java.io.*;

public class Main {
    static int n, m;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        for(int i=0; i<n; i++) {
            sb.append("IO");
        }
        sb.append("I");

        int cnt = 0;
        for(int i=0; i<m-n*2; i++) {
            String str = s.substring(i, n*2+1+i);
            if(str.equals(sb.toString())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}