package threadPackage;

import java.util.TimerTask;

public class MyTimeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("60초 경과했습니다.");
        System.exit(0);
    }

    public TimerTask run2(int i) {
        System.out.println(i + "개실행되었습니다.");
        return null;
    }
}
