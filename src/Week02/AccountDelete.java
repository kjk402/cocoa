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

                for(int i=0; i<num-1; i++) {

                    line = br.readLine(); //읽으며 이동

                    result += (line + "\r\n" );

                }
                String del =br.readLine();
                result += (num+"_"+"삭제된데이터" + "\r\n");

                //3. 삭제하고자 하는 position 이후부터 dummy에 저장
                while((line = br.readLine())!=null) {
                    result += (line + "\r\n" );

                }
                //4. FileWriter를 이용해서 덮어쓰기

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



