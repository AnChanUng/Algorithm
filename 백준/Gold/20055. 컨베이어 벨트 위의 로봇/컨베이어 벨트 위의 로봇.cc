#include <bits/stdc++.h>
using namespace std;
int n, k, d;        
int step = 0;       // 단계 수
deque<int> dq;      // 내구도

int main() {
    cin >> n >> k;
    for(int i=0; i<2*n; i++) {
        cin >> d;
        dq.push_back(d);
    }
    vector<bool> robot(n, false);
    while(true) {
        step++;
        //1.벨트 회전 
        auto cur = dq.back(); 
        dq.pop_back();
        dq.push_front(cur);

        //2.로봇 회전
        for(int i=n-1; i>0; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = false;
        robot[n-1] = false;

        //3.로봇 이동
        for(int i=n-1; i>0; i--) {
            if(robot[i-1] && !robot[i] && dq[i] > 0) {
                robot[i] = true;
                robot[i-1] = false;
                dq[i]--;
            }
        }
        robot[n-1] = false;
        //4.로봇 올리기
        if(dq[0] > 0) {
            robot[0] = true;
            dq[0]--;
        }
        
        //5.내구도 0개수 세기, k이상이면 break
        int zeroCnt = count(dq.begin(), dq.end(), 0);
        if(zeroCnt >= k) {
            break;
        }
    }
    cout << step;
}