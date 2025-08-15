#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> priorities, int location) {
    queue<pair<int,int>> q; // {우선순위, 원래 인덱스}
    priority_queue<int> mx; // 현재 큐의 최대 우선순위
    int targetNumber = priorities[location]; // 찾으려는 숫자의 위치
    int maxNumber; // 가장 큰 수
    
    for(int i=0; i<priorities.size(); i++) { 
        q.push({priorities[i], i});
        mx.push(priorities[i]);
    }
    maxNumber = mx.top();
     
    int i = 0;
    while(true) {
        int pr = q.front().first;
        int idx = q.front().second;
        
        if(pr == maxNumber) {
            q.pop();
            mx.pop();
            i++;
            if(idx == location) {
                return i;
            }
            if (!mx.empty()) {
                maxNumber = mx.top();
            }
        } else {
            q.push(q.front());
            q.pop();
        }
    }
}