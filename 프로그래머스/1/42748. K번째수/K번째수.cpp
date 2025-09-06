#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    // array의 commands[i][0]부터 commands[i][1]까지 자르기
    for(int i=0; i<commands.size(); i++) {
        vector<int> result;
        for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
            result.push_back(array[j]);
        }
        sort(result.begin(), result.end());
        int number = result[commands[i][2]-1];
        answer.push_back(number);
    }
    
    return answer;
}