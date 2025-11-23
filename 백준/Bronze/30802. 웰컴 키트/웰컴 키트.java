import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    티셔츠 한장, 펜 한자루 (웰컴 키트)
    티셔츠: S, M, L, XL, XXL, XXXL (6가지 사이즈) -> T장 묶음으로만 주문 가능
    펜: P자루 묶음 or 한 자루씩 주문 가능
    티셔츠 남아도 됨. 펜 남거나 부족하면x
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] tShirt = new int[6]; // 티셔츠 (S, M, L, XL, XXL, XXXL)

        for(int i=0; i<6; i++) {
            tShirt[i] = Integer.parseInt(st.nextToken());
        }
        // 정수 티셔츠, 펜의 묶음 수
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tCount = 0;
        for(int i=0; i<tShirt.length; i++) {
            tCount += (tShirt[i] + t - 1) / t;
        }
        sb.append(tCount).append("\n");
        sb.append(n / p).append(" ").append(n % p);

        System.out.println(sb);
    }
}