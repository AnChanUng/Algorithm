#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<bool> vis(n, false);
    
    for(int i=0; i<n; i++) {
        if(vis[i] == true) continue;
        answer++;
        queue<int> q;
        q.push(i);
        vis[i] = true;
        
        while(!q.empty()) {
            int cur = q.front(); q.pop();
            for(int j=0; j<n; j++) {
                if(computers[cur][j] == 1 && vis[j] == false) {
                    vis[j] = true;
                    q.push(j);
                }
            }
        }
    }
    return answer;
}