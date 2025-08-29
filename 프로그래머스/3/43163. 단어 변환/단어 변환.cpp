#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

bool canChange(string a, string b) {
    int diff = 0;
    for(int i=0; i<a.size(); i++) {
        if(a[i] != b[i]) diff++;
        if(diff > 1) return false;
    }
    return diff == 1;
}

int solution(string begin, string target, vector<string> words) {
    vector<bool> vis(words.size(), false);
    queue<pair<string, int>> q;
    q.push({begin, 0});
    while(!q.empty()) {
        auto cur = q.front();
        q.pop();
        if(cur.X == target) return cur.Y;
        
        for(int i=0; i<words.size(); i++) {
            if(!vis[i] && canChange(cur.X, words[i])) {
                vis[i] = true;
                q.push({words[i], cur.Y+1});
            }
        }
    }
    return 0;
}