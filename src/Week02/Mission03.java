package Week02;
import jdk.dynalink.beans.StaticClass;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Mission03 {
    public static void main(String[] args) {


        FileReader readFile;
        BufferedReader br;
        BufferedWriter bw;
        String getLine;
        try {

            readFile = new FileReader("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Mission03Data.txt");
            // 파일경로
            br = new BufferedReader(readFile);


            while ((true)) {
                String str = br.readLine();
                if(str == null) {
                    File file = new File("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Mission03Data.txt");
                    bw = new BufferedWriter(new FileWriter(file));
                    if (file.isFile() && file.canWrite()) {
                        //쓰기
                        System.out.println("사용자정보가 없습니다. 새로 등록하세요.");
                        String ret[] = new String[2];
                        Scanner sc = new Scanner(System.in);
                        System.out.print("이름:");
                        ret[0] = sc.nextLine();
                        bw.write("이름:" + ret[0]);

                        bw.newLine();
                        System.out.print("비밀번호:");
                        ret[1] = sc.nextLine();
                        bw.write("비밀번호:" + ret[1]);
                        bw.close();
                        sc.close();
                    }

                }

                while (br.readLine() != null) {
                    String ret[] = new String[2];
                    Scanner sc = new Scanner(System.in);
                    System.out.print("이름:");
                    ret[0] = sc.nextLine();
                    System.out.print("비밀번호:");
                    ret[1] = sc.nextLine();
                    sc.close();

                    String name = ret[0];
                    String password =ret[1];
                    if(str.contains(name)){
                        if(str.contains(name) || str.contains(password)){
                            System.out.println("입력하신 정보가 맞습니다.");
                            System.out.println("작업 번호를 선택해주세요.");
                            System.out.println("1.데이터입력 2.데이터삭제 3.데이터수정 4.전체 보기 5.종료");
                            AccountWrite accountWrite = new AccountWrite();

                            }
                        }
                    else {
                        System.out.println("입력하신 정보가 맞지 않습니다.");
                    }
                }
                break;
            }
        } catch (FileNotFoundException e){ //파일 없을 때
            e.printStackTrace();
        } catch (IOException e) { //입력 실패
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }
}
