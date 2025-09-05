#include <bits/stdc++.h>
using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    vector<int> ord(dungeons.size());
    iota(ord.begin(), ord.end(), 0);
    int answer = 0;
    do { 
        int cur = k; // 현재 피로도
        int cleared = 0; // 클리어한 던전 수
        for(int i=0; i<dungeons.size(); i++) {
            int idx = ord[i]; // i번째로 방문할 던전 번호
            int need = dungeons[idx][0]; // 최소 필요 피로도
            int cost = dungeons[idx][1]; // 소모 피로도
            if(cur >= need) { // 최소 필요치 이상이면
                cur -= cost; // 피로도 차감
                cleared++; // 클리어 수 증가
            }
        }
        answer = max(answer, cleared); // 순열 결과로 최대값 갱신
    } while (next_permutation(ord.begin(), ord.end()));
    // {0, 1, 2} {1, 0, 2} ... {2, 1, 0} 전부 시도
    return answer;
}