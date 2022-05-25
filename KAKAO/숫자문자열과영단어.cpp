#include <map>
#include <string>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

map<string, int> nummap; 


// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(string s) {
    string st = s;
    int answer = 0;
    
    nummap.insert({ "zero",0 });
    nummap.insert({ "one",1 });
    nummap.insert({ "two",2 });
    nummap.insert({ "three",3 });
    nummap.insert({ "four",4 });
    nummap.insert({ "five",5 });
    nummap.insert({ "six",6 });
    nummap.insert({ "seven",7 });
    nummap.insert({ "eight",8 });
    nummap.insert({ "nine",9 });

    for (int i = 0; i < st.size(); i++) {
        if (isdigit(st[i])) { //숫자일 경우 int 변환 후 answer에 더하기           
            int tmpnum = st[i] - '0';
            answer *= 10;
            answer += tmpnum;
        }
        else {//문자일 경우 숫자로 변환해야
            string tmpstr="";
            while (1) {
                tmpstr += st[i];            
                if (nummap.count(tmpstr)) {//tmpstr에 숫자가 완성된 경우
                    int tmpnum = nummap.at(tmpstr);
                    answer *= 10;
                    answer += tmpnum;              
                    break;
                }
                i++;
            }            
        }
    }
   
    return answer;
}