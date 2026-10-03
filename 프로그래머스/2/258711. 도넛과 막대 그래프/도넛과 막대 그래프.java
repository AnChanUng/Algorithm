import java.util.*;
/*
    생성한 정점의 번호, 정점을 생성하기 전 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수

    1. edges를 돌면서 최대 노드 번호 구하기
    2. in, out 차수 배열 채우기
    3. 정점 돌면서 조건으로 판별
       - 생성 정점 : in 0, out >= 2
       - 막대      : in >= 1, out 0
       - 8자       : in >= 2, out 2
    4. 도넛 = 생성 정점의 out - 막대 - 8자
*/
class Solution {
    static int[] in, out;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int max = 0;
        for(int i=0; i<edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }

        in = new int[max+1];
        out = new int[max+1];

        for(int i=0; i<edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            out[a]++; // a에서 나가는 간선 +1
            in[b]++;  // b로 들어오는 간선 +1
        }

        for(int i=1; i<=max; i++) {
            if(in[i] == 0 && out[i] >= 2) {
                answer[0] = i; // 아무도 가리키지 않고, 그래프 2개 이상을 가리키는 정점은 생성 정점뿐
            } else if(in[i] >= 1 && out[i] == 0) {
                answer[2]++; // 막대의 끝은 더 갈 곳이 없음. in >= 1은 쓰이지 않은 번호를 거르기 위함
            } else if(in[i] >= 2 && out[i] == 2) {
                answer[3]++; // out이 2인 건 8자 가운데뿐. in >= 2로 생성 정점과 구분
            }
        }

        answer[1] = out[answer[0]] - answer[2] - answer[3]; // 생성 정점의 out = 전체 그래프 수, 나머지가 도넛
        return answer;
    }
}