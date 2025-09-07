#include <bits/stdc++.h>
using namespace std;

int solution(int n, vector<vector<int>> edge) {
    vector<vector<int>> graph(n+1);
    vector<int> counts(n+1, 0);
    vector<bool> vis(n+1, false);
    queue<int> q;
    int answer = 0;
    for(int i=0; i<edge.size(); i++) {
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }
    q.push(1);
    vis[1] = true;
    
    while(!q.empty()) {
        int node = q.front(); q.pop();
        for(int i=0; i<graph[node].size(); i++) {
            if(vis[graph[node][i]] == false) {
                int cur = counts[node] + 1;
                vis[graph[node][i]] = true;
                counts[graph[node][i]] = cur;
                q.push(graph[node][i]);
            }
        }
    }
    
    sort(counts.begin(), counts.end(), greater<int>());
    for(auto cnt : counts) {
        if(counts[0] != cnt) break;
        answer++;
    }
    
    return answer;
}