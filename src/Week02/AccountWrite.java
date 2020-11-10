package Week02;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class AccountWrite {

    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 1;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }
    public static void main(String[] args) {
        //파일 객체 생성
        File file = new File("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt");
        FileReader readFile;
        BufferedReader br;
        try {
            readFile = new FileReader("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt");
            // 파일경로
            br = new BufferedReader(readFile);

            //파일에 문자열을 쓴다.
            //하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
            //파일이 손산될 우려가 있다.
            FileWriter fw = new FileWriter(file, true);
            Scanner sc = new Scanner(System.in);
            System.out.print("날짜:");
            String day = sc.nextLine();
            System.out.print("적요:");
            String summary = sc.nextLine();
            System.out.print("수입:");
            String income = sc.nextLine();
            System.out.print("지출:");
            String spend = sc.nextLine();

            fw.write(countLines("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt")+"_"+"날짜:"+day +" 적요:"+ summary+" 수입:"+income+" 지출:" +spend+"\r\n");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



