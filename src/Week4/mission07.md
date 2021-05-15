AWT 연습하기

AWT :GUI프로그래밍 도구이다. 
Swing : AWT 확장판. AWT보다 다양하고 풍부한 기능을 제공한다.
        (JButton, JFrame)
        

JButton에 이미지 삽입하기
ImageIcon 이용
    bat = new JButton(new ImageIcon("src\\Week4\\batsym.gif"));

Graphics 그림그려주는 클래스, 픽셀단위 
(Graphics g)로 메소드를 재정의 하면된다.
버튼은 이미지 삽입이라 이미지를 넣어도 x,y 로 위치 조정
그래픽은 이미지자체를 삽입한 것이라 픽셀단위로 위치 조정해줘야한다.


