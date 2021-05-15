package Week02;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AccountDelete {


    public static void Delete() {
        { File file = new File("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt");
            FileReader readFile;

            String getLine;
            String result = "";
            try {
                // 파일경로

                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));


                Scanner sc = new Scanner(System.in);
                System.out.println("삭제하실 순번을 적어주세요");
                int num = sc.nextInt();

                String line;
                //num 전까지 읽기
                for(int i=0; i<num-1; i++) {
                    line = br.readLine();
                    result += (line + "\r\n" );

                }
                //데이터 삭제
                String del =br.readLine();
                result += (num+"_"+"삭제된데이터" + "\r\n");

                //삭제 이후 끝까지 읽기
                while((line = br.readLine())!=null) {
                    result += (line + "\r\n" );

                }


                FileWriter fw = new FileWriter(file);
                fw.write(result);


                fw.close();

                br.close();
            } catch (IOException e) {
                e.printStackTrace();

            } catch (NoSuchElementException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}



