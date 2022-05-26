#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq(scoville.begin(),scoville.end());
    while (pq.top()<K && pq.size()>1) {
        int first = pq.top();
        pq.pop();
        int second = pq.top();
        pq.pop();
        pq.push(first + 2 * second);
        answer++;
    }
    if (pq.top() < K) return -1;
    return answer;
}