package week01;
import java.io.*;
import java.util.Scanner;

public class WedIndienName {
    public static int[] getBirth() {
        int ret[] = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.print("출생 년도:");
        ret [0] = sc.nextInt();
        System.out.print("출생 달:");
        ret [1] = sc.nextInt();
        System.out.print("출생 일:");
        ret [2] = sc.nextInt();
        sc.close();
        return ret;

    }

    public static void main(String[] args) {

        int[] arr = getBirth();
        String year = String.valueOf(arr[0]%10);
        String month = String.valueOf(arr[1]);
        String day = String.valueOf(arr[2]);

        FileReader readFile;
        BufferedReader br;
        String getLine;
        try {

            readFile = new FileReader("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\week01\\IndienName.txt");		// 파일경로
            br = new BufferedReader(readFile);
            String result = "";

            while((getLine = br.readLine()) != null){		// 한줄씩 읽기

                int idx = getLine.indexOf(":");
                if (Integer.parseInt(day) !=4 &&Integer.parseInt(day) !=5 && Integer.parseInt(day) !=6) {
                    if(getLine.startsWith(day+"일")){
                        result += getLine.substring(idx+1);
                    }
                }
                if(getLine.startsWith(month+"월")){
                    result += " " + getLine.substring(idx+1);
                }
                if(getLine.startsWith(year+"년")){
                    result += getLine.substring(idx+1);
                }

            }

            System.out.println("당신의 인디언식 이름은 "+ result + " 입니다.");


        } catch (FileNotFoundException e){ //파일 없을 때
            e.printStackTrace();
        } catch (IOException e) { //입력 실패
            e.printStackTrace();
        }

    }
}
