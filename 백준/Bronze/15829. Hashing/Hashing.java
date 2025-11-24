import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    r: 26보다 큰 소수, m: 1234567891
    항의 번호에 해당하는 만큼 특정한 숫자를 거듭제곱해서 곱해준 다음 더하는 것

    문제:
    1.1 문자열의 길이(l) 입력 받기
    1.2 문자열 입력 받기
    2   total += 문자열을 숫자로 변환 x 31 ** i
    3   total 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long m = 1234567891;
        long pow = 1;
        long total = 0;
        for(int i=0; i<l; i++) {
            int word = str.charAt(i) - 'a' + 1;
            total = (total + word * pow) % m;
            pow = (pow * 31) % m;
        }
        System.out.println(total);
    }
}