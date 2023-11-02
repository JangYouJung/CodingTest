import java.util.Arrays;
import java.util.Vector;

class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {

        Vector<Integer> vector = new Vector<Integer>();

        //[0] today 년, 월, 일 분리하기
        int t_year = (today.charAt(0)-'0')*1000 + (today.charAt(1)-'0')*100 + (today.charAt(2)-'0')*10 + (today.charAt(3)-'0');
        int t_month = (today.charAt(5)-'0')*10 + (today.charAt(6)-'0');
        int t_day = (today.charAt(8)-'0')*10 + (today.charAt(9)-'0');

        System.out.println("오늘 날짜: "+t_year+ " . " + t_month+ " . "+ t_day);

        for(int index = 0; index<privacies.length; index++){
            System.out.println();////////////////////////////////////////////////////////////////////////////////////
            String p = privacies[index];

            int left_months = 0; //유효 기간

            // [1] terms에서 개인정보 약관 종류 찾아서 유효기간 가져오기
            for(String t : terms ) {
                double digit = 0;
                if (t.charAt(0) == p.charAt(p.length() - 1)) {
                    for (int i = t.length()-1; ; i--) {
                        if(t.charAt(i)==' ')break;
                        else{
                            double num = (t.charAt(i) - '0') * Math.pow(10, digit);
                            left_months += (int) num;
                            digit++;
                        }
                    }
                    System.out.println(index + " 번째 유효기간: " + left_months);///////////////////////////////////////////
                    break;
                }
            }

            //[2]: privacies 년 / 월 / 일 각각 분리하기
            int p_year = (p.charAt(0)-'0')*1000 + (p.charAt(1)-'0')*100 + (p.charAt(2)-'0')*10 + (p.charAt(3)-'0');
            int p_month =  (p.charAt(5)-'0')*10 + (p.charAt(6)-'0');
            int p_day = (p.charAt(8)-'0')*10 + (p.charAt(9)-'0');

            System.out.println("개인정보 수집 일자: "+p_year+"년 "+p_month+"월 ");///////////////////////////////////////////////

           //[3]: left_months를 가지고 deadline 계산하기
            p_year+=left_months/12;
            p_month+=left_months%12;

            if(p_month>12) {
                p_year+=p_month/12;
                p_month%=12;
            }
            System.out.println("deadline: "+p_year+"년 "+p_month+"월 "+p_day);//////////////////////////////////////////////////

            //[4]: 오늘 날짜와 비교해서 유효기간 지났는지 확인
            if(t_year>p_year){ // 연도가 이미 지났을 경우
                vector.add(index+1);
                System.out.println("vector 삽입 발생");////////////////////////////////////////////////////////////////////////////
            }
            else if(t_year==p_year){
                //같은 연도에서 유효기간 달이 지났을 경우
                if(t_month>p_month) {
                    vector.add(index+1);
                    System.out.println("vector 삽입 발생");//////////////////////////////////////////////////////////////////////
                }
                else if(t_month==p_month && t_day>=p_day){
                    vector.add(index+1);
                    System.out.println("vector 삽입 발생");//////////////////////////////////////////////////////////////////////////
                }
            }
        }

        int[] answer = new int[vector.size()];
        for(int i =0; i<vector.size(); i++){
            answer[i]=vector.elementAt(i);
        }
        return answer;
    }
}