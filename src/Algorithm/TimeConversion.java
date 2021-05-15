package Algorithm;
// https://www.hackerrank.com/challenges/time-conversion/problem
// 시간 출력받고 AM과 PM 구분해서 PM 이면 시간에 12 더해서 출력


import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String time = scan.next();
        String tArr[] = time.split(":");
        String AmPm = tArr[2].substring(2,4);
        int hh,mm,ss;
        hh = Integer.parseInt(tArr[0]);
        mm = Integer.parseInt(tArr[1]);
        ss = Integer.parseInt(tArr[2].substring(0,2));

        String checkPM = "PM",checkAM ="AM";
        int h = hh;
        if(AmPm.equals(checkAM) && hh==12)
            h=0;
        else if(AmPm.equals(checkPM)&& hh<12)
            h+=12;

        System.out.printf("%02d:%02d:%02d",h,mm,ss);
    }
}
