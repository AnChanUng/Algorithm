#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    
    vector<int> height(n);    // 탑 높이 저장
    vector<int> answer(n, 0); // 탑 위치 저장
    stack<pair<int, int>> st; // 탑 높이, 인덱스
    
    for(int i=0; i<n; i++) {
        cin >> height[i];

        while(!st.empty() && st.top().first <= height[i]) {
            st.pop();
        }

        if(!st.empty()) {
            answer[i] = st.top().second;
        }

        st.push({height[i], i+1});
    }

    for(int i=0; i<n; i++) {
        cout << answer[i] << " ";
    }
}