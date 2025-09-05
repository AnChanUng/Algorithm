#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int n;
int start_time, end_time;

int compare(pair<int, int> a, pair<int, int> b) {
    if(a.Y == b.Y) {
        return a.X < b.X;
    } else {
        return a.Y < b.Y;
    }
}

int main(void) {
    cin >> n; // 회의 수
    vector<pair<int, int>> info;
    // 회의에 대한 정보
    for(int i=0; i<n; i++) {
        cin >> start_time >> end_time; // 회의 시작시간 끝나는 시간
        info.push_back({start_time, end_time});
    }
    sort(info.begin(), info.end(), compare);
        
    int cnt = 0;
    int cur = 0;
    for(int i=0; i<n; i++) {
        if(cur <= info[i].X) {
            cur = info[i].Y;
            cnt++;
        }   
    }
    cout << cnt;
}