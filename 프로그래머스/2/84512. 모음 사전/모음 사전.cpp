#include <string>
#include <vector>

using namespace std;

int solution(string word) {    
    int weight[5] = {781, 156, 31, 6, 1};
    string V = "AEIOU";
    int answer = 0;
    for(int i=0; i<(int)word.size(); i++) {
        int pos = V.find(word[i]);
        answer += pos * weight[i] + 1;
    }
    
    return answer;
}