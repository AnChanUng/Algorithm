#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;
int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int cnt = 0;
    int result = 0;
    int idx = 0;
    queue<int> q;
    for(int i=0; i<bridge_length; i++) {
        q.push(0);
    }
    while(!q.empty()) {
        cnt++;
        result -= q.front();
        q.pop();
        if(idx < truck_weights.size()) {
            if(result + truck_weights[idx] <= weight) {
                result += truck_weights[idx];
                //cout << "result: " << result << "\n"; 
                q.push(truck_weights[idx]);
                idx++;
                //cout << "idx: " << idx << "\n";
            } else {
                q.push(0);
            }
        }
    }
    return cnt;
}