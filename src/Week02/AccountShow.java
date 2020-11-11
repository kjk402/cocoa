package Week02;

import java.io.*;
import java.util.NoSuchElementException;


public class AccountShow {
    public static void Show() {
        { File file = new File("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week02\\Account.txt");


            String getLine;
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while((getLine = br.readLine())!=null) {
                    System.out.print(getLine+"\r\n");

                }

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
