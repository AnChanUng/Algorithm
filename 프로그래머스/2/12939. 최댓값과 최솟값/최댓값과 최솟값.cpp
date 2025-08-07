#include <string>
#include <vector>
#include <algorithm>
#include <climits>
#include <sstream>
using namespace std;

string solution(string s) {
    stringstream ss(s);
    string number;
    int min_val = INT_MAX;
    int max_val = INT_MIN;
    
    while (ss >> number) {
        int num = stoi(number);
        min_val = min(min_val, num);
        max_val = max(max_val, num);
    }
    
    return to_string(min_val) + " " + to_string(max_val);
}