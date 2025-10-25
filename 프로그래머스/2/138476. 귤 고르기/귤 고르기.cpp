#include <bits/stdc++.h>
using namespace std;
int total = 0; 
int answer = 0;

int solution(int k, vector<int> tangerine) {
    int maxNum = *max_element(tangerine.begin(), tangerine.end());
    vector<int> cnt(maxNum+1, 0);
    
    for(int i=0; i<tangerine.size(); i++) {
        cnt[tangerine[i]]++;
    }

    sort(cnt.begin(), cnt.end(), greater<int>());
    
    for(int i=0; i<cnt.size(); i++) {
        total += cnt[i];
        answer++;
        if(total >= k) {
            break;
        }
    }
    
    return answer;
}