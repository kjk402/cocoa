package Algorithm;

public class LeapYear {
    // programmers 12901  윤년 구하기
    // 윤년이란 2월이 29일까지 있는 년
    // 2016년 1월 1일은 금요일이다. 금요일부터 시작하면 된다.
    public String getDayName(int a, int b) {
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate += date[i];
        }
        allDate += (b - 1); // -1을 안하면 1월 1일도 하루 더해줘서 순서 어긋난다.

        answer = day[allDate % 7];

        return answer;
    }
    public static void main(String[] args)
    {
        LeapYear test = new LeapYear();
        int a=5, b=24;
        System.out.println(test.getDayName(a,b));
    }
}
