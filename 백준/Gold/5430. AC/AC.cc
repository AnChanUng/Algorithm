#include <bits/stdc++.h>
using namespace std;
string s, p;
int t, n;
int main(void) {
    cin >> t;
    for(int i=0; i<t; i++) {
        cin >> p; // 함수
        vector<char> pp;
        for(int j=0; j<p.size(); j++) {
            pp.push_back(p[j]);
        }
        cin >> n; // 배열에 들어있는 수의 개수
        cin >> s; // 배열에 들어있는 정수
        deque<int> arr;
        string num = "";
        for(int j=0; j<s.size(); j++) {
            if(isdigit(s[j])) {
                num += s[j];
            } else {
                if(!num.empty()) {
                    arr.push_back(stoi(num));
                    num = "";
                }
            }
        }
        bool rev = false;
        bool error = false; 
        for(int j=0; j<pp.size(); j++) {
            if(pp[j] == 'R') {
                rev = !rev;
            } else if(pp[j] == 'D') {
                if(arr.empty()) {
                    error = true;
                    break;
                }
                if(rev == false) {
                    arr.pop_front();
                } else {
                    arr.pop_back();
                }
            }
        }
        if(error == true) {
            cout << "error" << "\n";
        } else {
            cout << "[";
            if(rev == false) {
                for(int j=0; j<arr.size(); j++) {
                    cout << arr[j];
                    if(j != arr.size()-1) {
                        cout << ",";
                    }
                }
            } else {
                for(int j=arr.size()-1; j>=0; j--) {
                    cout << arr[j];
                    if(j != 0) {
                        cout << ",";
                    }
                }
            }
            cout << "]\n";
        }
    }
}