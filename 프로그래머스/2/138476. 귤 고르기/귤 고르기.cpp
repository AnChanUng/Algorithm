#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    unordered_map<int, int> um;
    
    for(int i=0; i<tangerine.size(); i++) {
        um[tangerine[i]]++;
    }
    
    vector<int> cnts;
    cnts.reserve(um.size());
    for(auto &kv : um) {
        cnts.push_back(kv.second);
    }
    
    sort(cnts.begin(), cnts.end(), greater<int>());
    
    int useKinds = 0;
    for(int c : cnts) {
        k -= c;
        useKinds++;
        if(k <= 0) {
            break;
        }
    }
    
    return useKinds;
}