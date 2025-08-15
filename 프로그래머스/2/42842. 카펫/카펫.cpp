#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int sum = brown + yellow;
    for(int w=1; w<=sum; w++) {
        for(int h=1; h<=sum; h++) {
            if(w * h != sum) {
                continue;
            }
            if(w < h) {
                continue;
            }
            if(w < 3 || h < 3) {
                continue;
            }
            
            if((w - 2) * (h - 2) == yellow) {
                answer.push_back(w);
                answer.push_back(h);
                return answer;
            }
        }
    }
}