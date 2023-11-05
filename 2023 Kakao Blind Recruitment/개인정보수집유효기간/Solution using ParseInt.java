import java.util.Vector;
class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        Vector<Integer> vector = new Vector<Integer>();

        //[0] today 년, 월, 일 분리하기 / ParseInt 와 substring 사용
        int t_year = Integer.parseInt(today.substring(0,4));
        int t_month = Integer.parseInt(today.substring(5,7));
        int t_day = Integer.parseInt(today.substring(8,10));


        for(int index = 0; index<privacies.length; index++){
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
                    break;
                }
            }

            //[2]: privacies 년 / 월 / 일 각각 분리하기
            int p_year = Integer.parseInt(p.substring(0,4));
            int p_month =  Integer.parseInt(p.substring(5,7));
            int p_day = Integer.parseInt(p.substring(8,10));

            //[3]: left_months를 가지고 deadline 계산하기
            p_year+=left_months/12;
            p_month+=left_months%12;

            if(p_month>12) {
                p_year+=p_month/12;
                p_month%=12;
            }


            //[4]: 오늘 날짜와 비교해서 유효기간 지났는지 확인
            // [4]-1 연도가 이미 지났을 경우
            if(t_year>p_year){
                vector.add(index+1);
            }
            else if(t_year==p_year){
                //[4]-2 같은 연도에서 유효기간 달이 지났을 경우
                if(t_month>p_month) {
                    vector.add(index+1);
                }
                //[4]-3 같은 연도, 같은 달에서 하루 이상 지났을 경우
                else if(t_month==p_month && t_day>=p_day){
                    vector.add(index+1);
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