import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
    길이가 짧은 것부터, 같으면 사전 순으로 오름차순 정렬. 중복된 단어는 제거

    문제
    1.1 n 입력 받기
    1.2 n개만큼 문자 입력 받기. 입력 받은 문자 배열에 저장, 중복 되면 저장x
    2   길이가 짧은 것부터 길이가 같으면 사전 순 정렬
    3   하나씩 출력

    접근 방식
    - 1차원 배열
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr[] = new String[n];

        int idx = 0;
        for(int i=0; i<n; i++) {
            String str = sc.next();
            boolean flag = false;

            for(int j=0; j<idx; j++) {
                if(arr[j].equals(str)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                arr[idx++] = str;
            }
        }
        // 길이가 짧은 것부터 오름차순 정렬, 길이가 같으면 사전 순 정렬
        Arrays.sort(arr, 0, idx, (a, b) -> {
           if(a.length() != b.length()) {
               return a.length() - b.length(); // 길이 비교
           }
           return a.compareTo(b); // 사전순 비교
        });

        for(int i=0; i<idx; i++) {
            System.out.println(arr[i]);
        }
    }
}