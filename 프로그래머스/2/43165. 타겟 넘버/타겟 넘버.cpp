#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int answer = 0;

void dfs(int index, int sum, int target, vector<int> numbers) {
    if(index == numbers.size()) {
        if(sum == target) {
            answer++;
        }
        return;
    }
    dfs(index+1, sum+numbers[index], target, numbers);
    dfs(index+1, sum-numbers[index], target, numbers);
}

int solution(vector<int> numbers, int target) {
    answer = 0;
    dfs(0, 0, target, numbers);
    return answer;
}