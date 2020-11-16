package Week3;



import javax.swing.text.View;
import java.io.File;
import java.util.Scanner;

public class Mission05 {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Java Shell>");

            Scanner sc = new Scanner(System.in);
            String menu = sc.nextLine();
            if (menu.startsWith("cp")){
                String[] coPy = menu.split(" ");
                String ret2 = coPy[1];
                String ret3 = coPy[2];
                System.out.println(ret2);
                System.out.println(ret3);
                FileControl.cp("src\\Week3\\Files\\"+ret2, "src\\Week3\\Files\\"+ret3);
                continue;
            }
            if (menu.startsWith("ping")) {
                String[] str = menu.split(" ");
                String ret2 = str[1];
                Network.ping(ret2);
                continue;
            }

            if (menu.startsWith("nslookup")) {
                String[] str = menu.split(" ");
                String ret2 = str[1];
                Network.nsLookUp(ret2);
                continue;
            }

            if (menu.startsWith("vi")) {
                String[] str = menu.split(" ");
                String ret2 = str[1];
                FileControl.vi("src\\Week3\\Files\\"+ret2);
                continue;
            }
            if (menu.startsWith("rm")) {
                String[] str = menu.split(" ");
                String ret2 = str[1];
                FileControl.rm("src\\Week3\\Files\\"+ret2);
                continue;
            }

            switch (menu) {
                case "ls":
                    FileControl.ls();
                    break;
                case "pwd":
                    Pwd.pwd();
                    break;
                case "ipconfig":
                    Network.ipconfig("ipconfig");
                    break;
                case "test":
                    Test.getHostAddress();
                    break;
                case "exit":
                    return;

                default:
                    System.out.print(menu + "는 없는 명령어");
                    break;

            }
            System.out.println(" ");
        }
    }
}
