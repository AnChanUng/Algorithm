#include <string>
#include <vector>
#include <set>
using namespace std;

set<int> numberSet;

bool isPrime(int number) {
    if(number <= 1) {
        return false;
    }
    
    for(int i=2; i*i<=number; i++) {
        if(number % i == 0) {
            return false;
        }
    }
    return true;
}

void makeCombination(string comb, string others) {
    if(comb != "") {
        numberSet.insert(stoi(comb));
    }
    for(int i=0; i<others.size(); i++) {
        makeCombination(comb + others[i], others.substr(0, i) + others.substr(i+1));
    }
}

int solution(string numbers) {
    makeCombination("", numbers);
    
    int answer = 0;
    for(int number : numberSet) {
        if(isPrime(number)) {
            answer++;
        }
    }
    return answer;
}