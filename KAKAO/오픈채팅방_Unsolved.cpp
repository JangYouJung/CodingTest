#include <iostream>
#include <string>
#include <vector>
#include <regex>
using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;

    regex Enter("Enter");
    regex Leave("Leave");
    regex Change("Change");

    smatch match;
    for (auto& log : record) {
        if (regex_match(log, match, Change)) {
            regex id = 
        }
    }
    return answer;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL);

    //vector<string> record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"];
    
    return 0;
}