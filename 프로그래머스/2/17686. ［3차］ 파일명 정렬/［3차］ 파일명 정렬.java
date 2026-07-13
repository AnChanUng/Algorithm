import java.util.*;
/*
    파일명: HEAD, NUMBER, TAIL
    
    [정렬 기준]
    1. HEAD 기준 파일명 정렬 (문자열), 대소문자 구분x -> 모두 소문자로 변경
    2. HEAD 부분이 같을 경우 NUMBER 숫자 순으로 정렬
    3. HEAD 부분과 NUMBER가 같을 경우 원래 입력에 주어진 순서를 유지 (먼저 들어온 순)
    
    1. files 배열을 HEAD, NUMBER, TAIL로 각각 나눈다
    2. 1~3의 기준으로 정렬
    3. 1차원 배열에 정렬한 숫자 저장
    
    알고리즘: 문자열 정렬
*/
class Solution {
    public String[] solution(String[] files) {
        String[][] arr = new String[files.length][3]; // 최종 결과
        String[] result = new String[files.length]; // 최종 결과
        
        for(int i=0; i<files.length; i++) {
            String HEAD = "";
            String NUMBER = "";
            String TAIL = "";
            boolean flag = false;
            boolean tailFlag = false;
            for(int j=0; j<files[i].length(); j++) {
                char ch = files[i].charAt(j);
                if (tailFlag) {
                    TAIL += ch;
                } else if (ch >= '0' && ch <= '9') {
                    NUMBER += ch;
                    flag = true;
                } else if (!flag) {
                    HEAD += ch;
                } else {
                    TAIL += ch;
                    tailFlag = true;
                }
            }
            arr[i][0] = HEAD;
            arr[i][1] = NUMBER;
            arr[i][2] = TAIL;
        }
        
        // 1~3순으로 정렬
        Arrays.sort(arr, (a, b) -> {
            if(a[0].equalsIgnoreCase(b[0])) {
                // 두번째 원소를 숫자로 변경 후, 작은 순으로 정렬
                int x = Integer.parseInt(a[1]);
                int y = Integer.parseInt(b[1]);
                return Integer.compare(x, y);
            }
            return a[0].compareToIgnoreCase(b[0]);
        });
        
        for(int i=0; i<arr.length; i++) {
            String str = "";
            str += arr[i][0] + arr[i][1] + arr[i][2];
            result[i] = str;
        }
        
        return result;
    }
}