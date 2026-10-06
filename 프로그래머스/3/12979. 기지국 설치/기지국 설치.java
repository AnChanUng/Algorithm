import java.util.*;
/*
    5g 기지국을 최소로 설치해 모든 아파트에 전달

    아파트의 개수: n (최대 2억)
    기지국이 설치된 아파트의 번호가 담긴 1차원 배열: stations (정렬되어 있음)
    전파의 도달 거리: w

    시간복잡도: n이 2억이라 O(n) 배열 순회도 위험 -> O(stations.length)로 풀어야 함
    알고리즘: 그리디 (왼쪽부터 전파가 안 닿는 구간을 채움)

    1. start = 1로 두고 stations를 순회합니다.
    2. 기존 기지국 s가 덮는 구간은 [s-w, s+w] 이므로 덮이지 않은 구간은 [start, s-w-1] 입니다.
    3. 그 구간의 길이를 새 기지국 1대의 커버 칸 수(2w+1)로 나눠 올림하면 필요한 대수입니다.
    4. start = s+w+1 로 옮기고 반복합니다.
    5. 마지막 기지국 뒤 구간 [start, n]도 한 번 더 계산합니다.
*/
class Solution {
    static int range;                                       
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        range = w * 2 + 1;                                  
        
        int start = 1;                                      // 아직 전파가 확인되지 않은 가장 왼쪽 아파트
        for(int i=0; i<stations.length; i++) {
            int end = stations[i] - w - 1;                  // 기존 기지국 왼쪽 경계 바로 앞까지가 빈 구간
            answer += count(start, end);                    // 빈 구간에 필요한 새 기지국 수를 더함
            start = stations[i] + w + 1;                    // 기존 기지국이 덮는 구간 다음 칸부터 다시 확인
        }
        answer += count(start, n);                          // 마지막 기지국 오른쪽 끝 구간은 반복문 밖에서 처리해야 함
        return answer;
    }

    // [start, end] 구간을 모두 덮는 데 필요한 새 기지국 수
    private static int count(int start, int end) {
        int len = end - start + 1;                          // 빈 구간의 길이
        if(len <= 0) return 0;                              // 기존 기지국끼리 겹치면 음수가 나오므로 0 처리
        return (len + range - 1) / range;                   // 정수 올림 공식 (실수 연산보다 안전함)
    }
}