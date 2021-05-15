package threadPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SingleThreadWebServer {
    private static int i = 0;

    public static void main(String[] args) throws IOException, InterruptedException{
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Timer t = new Timer(true);
            TimerTask task1 = new MyTimeTask();
            Socket connection = socket.accept();
            handleRequest(connection);
            t.schedule(task1, 60000);
        }
    }

    private static void handleRequest(Socket connection) throws InterruptedException {
        // request-handling logic here
        Thread.sleep(1000);
        i++;
        System.out.println(i);
    }
}
// tcping -t -i 0.05 127.0.0.1 80
