using namespace std;

long long solution(int price, int money, int count)
{
    long long answer = 0;
    long long result = 0;
    for(int i=1; i<=count; i++) {
        answer += price * i;
    }
    
    if(money - answer < 0) {
        result = answer - money;
    } else {
        result = 0;
    }
    
    return result;
}