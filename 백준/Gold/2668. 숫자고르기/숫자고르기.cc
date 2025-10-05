#include <bits/stdc++.h>
using namespace std;
int n;
int arr[101];
bool vis[101];
bool finished[101];
vector<int> result;

void dfs(int cur, int start) {
    vis[cur] = true;
    int next = arr[cur];
    
    if(!vis[next]) {
        dfs(next, start);
    } else if(next == start) {
         result.push_back(start);   
    }  
    finished[cur] = true;
}

int main() {
    cin >> n;
    for(int i=1; i<=n; i++) {
        cin >> arr[i];
    }
    for(int i=1; i<=n; i++) {
        fill(vis, vis+n+1, false);
        dfs(i, i);
    }
    sort(result.begin(), result.end());

    cout << result.size() << "\n";
    for(int i=0; i<result.size(); i++) {
        cout << result[i] << "\n";
    }
}