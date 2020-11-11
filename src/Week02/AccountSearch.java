package Week02;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AccountSearch {
    public static void Search() {
        { File file = new File("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt");

            System.out.println("======================");
            String getLine;
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String ret[] = new String[2];
                Scanner sc = new Scanner(System.in);
                System.out.print("분류(날짜, 적요, 수입, 지출, 지불 방법):");
                ret[0] = sc.nextLine();
                System.out.print("내용:");
                ret[1] = sc.nextLine();
                while((getLine = br.readLine())!=null) {
                    if (getLine.contains(ret[0]+":"+ret[1])){
                        System.out.print(getLine+"\r\n");
                    }


                }
                System.out.println("======================");
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
