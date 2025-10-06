#include <bits/stdc++.h>
using namespace std;
int comNum, networkInfo;
int a, b;
int arr[101][101];
int vis[101];
int cnt = 0;

void dfs(int x) {
    vis[x] = true;
    for(int i=1; i<=comNum; i++) {
        if(arr[x][i] == 1 && !vis[i]) {
            cnt++;
            dfs(i);
        }
    }
} 

int main() {
    cin >> comNum;
    cin >> networkInfo;
    for(int i=1; i<=networkInfo; i++) {
        cin >> a >> b;
        arr[a][b] = 1;
        arr[b][a] = 1;
    }
    dfs(1);
    cout << cnt;
}