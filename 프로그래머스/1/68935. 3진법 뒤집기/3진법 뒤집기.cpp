#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> arr;
    while(n) {
        arr.push_back(n % 3);
        n = n/3;
    }
    answer = arr[0];

    for(int i=1; i<arr.size(); i++) {
        answer = (answer * 3) + arr[i];
    }
    return answer;
}