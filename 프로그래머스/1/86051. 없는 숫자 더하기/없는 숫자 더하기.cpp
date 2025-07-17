#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    vector<int> array;

    for(int i=0; i<numbers.size(); i++) {
        answer += numbers[i];
    }
    
    return 45-answer;
}