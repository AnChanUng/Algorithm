#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    for(int i=0; i<numbers.size()-1; i++) {
        for(int j=i+1; j<numbers.size(); j++) {
            int total = numbers[i] + numbers[j];
            
            if(find(answer.begin(), answer.end(), total) == answer.end()) {
                answer.push_back(total);    
            }
        }
    }
    
    sort(answer.begin(), answer.end());
    
    return answer;
}