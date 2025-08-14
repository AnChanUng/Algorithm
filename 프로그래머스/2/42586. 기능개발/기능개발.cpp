#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> workSpeed;
    int cnt = 1;
    for(int i=0; i<progresses.size(); i++) {
        int n = 1;
        while(true) {
            if(((100 - progresses[i]) - (speeds[i] * n)) <= 0) {
                workSpeed.push_back(n);
                break;
            }
            n++;
        }
    }
    int pivot = workSpeed[0];
    for(int i=1; i<workSpeed.size(); i++) {
        // 5 10 1 1 20 1 
        if(pivot < workSpeed[i]) {
            answer.push_back(cnt);
            pivot = workSpeed[i];
            cnt = 1;
        } else {
            cnt++;
        }
    }
    answer.push_back(cnt);
    // for(int i=0; i<workSpeed.size(); i++) {
    //     cout << workSpeed[i] << " ";
    // }
    return answer;
}