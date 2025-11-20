#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int n, nn;
/*
	
*/
int main()
{
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		cin >> nn;
		v.push_back(nn);
	}
	sort(v.begin(), v.end(), greater<int>());

	int total = 0;
	for (int i = 0; i < v.size(); i++) {
		if ((i + 1) % 3 == 0) {
			continue;
		} else {
			total += v[i];
		}
	}
	cout << total;
	return 0;
}