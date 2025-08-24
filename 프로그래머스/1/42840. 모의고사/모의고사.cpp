#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int i = 0; 

vector<int> solution(vector<int> answers) {
    vector<int> answer1;
    vector<int> answer2;
    vector<int> answer3;
    
    while(i <= 10000) {
        i++;
        if(i % 5 == 0) {
            answer1.push_back(5);
        } else {
            answer1.push_back(i % 5);
        }
        // index  : 1 2 3 4 5 6 7 8 9 10
        // number : 2 1 2 3 2 4 2 5 2 1
        if(i % 8 == 2) {
            answer2.push_back(1);
        } else if (i % 8 == 4) {
            answer2.push_back(3);
        } else if (i % 8 == 6) {
            answer2.push_back(4);
        } else if (i % 8 == 0) {
            answer2.push_back(5);
        } else {
            answer2.push_back(2);
        }
        // index  : 1 2 3 4 5 6 7 8 9 10
        // number : 3 3 1 1 2 2 4 4 5 5
        if(i % 10 == 1 || i % 10 == 2) {
            answer3.push_back(3);
        } else if (i % 10 == 3 || i % 10 == 4) {
            answer3.push_back(1);
        } else if (i % 10 == 5 || i % 10 == 6) {
            answer3.push_back(2);
        } else if (i % 10 == 7 || i % 10 == 8) {
            answer3.push_back(4);
        } else {
            answer3.push_back(5);
        }
    }
    
    int count1 = 0, count2 = 0, count3 = 0;
    for(int i=0; i<answers.size(); i++) {
        if(answers[i] == answer1[i]) {
            count1++;
        }
        
        if(answers[i] == answer2[i]) {
            count2++;
        }
        
        if(answers[i] == answer3[i]) {
            count3++;
        }
    }
    
    int maxScore = max({count1, count2, count3});
    
    vector<int> result;
    if(count1 == maxScore) {
        result.push_back(1);
    }
    if(count2 == maxScore) {
        result.push_back(2);
    }
    if(count3 == maxScore) {
        result.push_back(3);
    }
    
    return result;
}