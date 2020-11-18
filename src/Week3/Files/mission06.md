한글 시계
https://hangulclock.today/#/main 구현
글자 색 입히기 (https://forgiveall.tistory.com/466 참고)
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_RESET = "\u001B[0m";

    public static String pupple(String ret) {
        String color = ANSI_PURPLE + ret+ANSI_RESET;
        return color;
    }

1. Calendar 클래스 사용하기
Calendar 클래스는 날짜와 시간에 관한 정보를 불러올 수 있다.

한글시계에서는 시간과 분을 불러온다.

        Calendar cal = Calendar.getInstance();

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);    
먼저 getInstance() 메소드를 이용한다.
그 밖에는 (https://hyeonstorage.tistory.com/205)
       
       int year = Calendar.YEAR //년
       int month = Calendar.MONTH //월
       int data = Calenfar.DATE //날짜

2. 이차원배열에서 특정열 색칠해서 표현  

    hangulClock[4][0] = pupple(hangulClock[4][0]);

3. 자바에서 이차원배열 전부 선택하는 법은 따로 없고 이중 for문으로 전부
확인해야 한다.

        for (int i = 0; i < hangulClock.length; i++) {
            for (int j = 0; j < hangulClock[i].length; j++) {
                hangulClock[i][j] = white(hangulClock[i][j]);
            }
        }

한글시계에서 현재 시각을 표시하는 글자들 외 전부 흰색으로 바꾸기.
        