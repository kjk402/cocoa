package Week02;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AccountChange {
    public static void Change() {
        { File file = new File("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt");

            String result = "";
            try {
                // 파일경로

                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));


                Scanner sc = new Scanner(System.in);
                System.out.println("수정하실 순번을 적어주세요");
                int num = sc.nextInt();

                System.out.println("내용적어주세요");
                String ss = sc.nextLine();
                System.out.print("날짜:");
                String day = sc.nextLine();
                System.out.print("적요:");
                String summary = sc.nextLine();
                System.out.print("수입:");
                String income = sc.nextLine();
                System.out.print("지출:");
                String spend = sc.nextLine();
                System.out.print("지불방법:");
                String payType = sc.nextLine();


                String line;

                for(int i=0; i<num-1; i++) {

                    line = br.readLine(); //읽으며 이동

                    result += (line + "\r\n" );

                }
                String del =br.readLine();
                result += (num+"_"+"날짜"+day +" 적요:"+ summary+" 수입:"+income+" 지출:" +spend +" 지불방법:"+payType+ "\r\n");

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

