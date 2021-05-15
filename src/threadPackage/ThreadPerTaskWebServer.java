package threadPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ThreadPerTaskWebServer {
    private static int i = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Timer t = new Timer(true);
            TimerTask task1 = new MyTimeTask();
            t.schedule(task1, 60000);
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    try {
                        handleRequest(connection);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) throws InterruptedException {
        // request-handling logic here
        Thread.sleep(1000);
        i++;
        System.out.println(i);
    }
}
