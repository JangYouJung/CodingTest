#include <string>
#include <vector>
#include <map>
#include <set>
using namespace std;

map<string, int> reportCnt; // 유저별 신고 당한 횟수
map<string, set<string>> reportLog; // 유저별 신고한 타 유저 리스트

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    
    for(string s: report) {
        // 문자열 파싱
        int blank = s.find(' ');         
        string from = s.substr(0, blank);  
        string to = s.substr(blank+1);      
        
        // from -> to 를 신고한 이력이 없다면 반영
        if(reportLog[from].find(to) == reportLog[from].end()) {
            reportCnt[to]++;
            reportLog[from].insert(to);
        }
    }
    
    for(string s: id_list) {
        int res = 0;
        
        // k번 이상 신고 당했다면 결과 메일 +1
        for(string str: reportLog[s])
            if(reportCnt[str] >= k) res++;
        
        answer.push_back(res);
    }
    
    return answer;
}