//18번:눈 내리는 마을 코드
import javax.swing.*;
import java.awt.*;

class SnowThread extends Thread{
    private JLabel J;
    public SnowThread(JLabel J) {
        this.J=J; //
    }
    public void run(){
        while(true){ //무한 루프
            J.setLocation(J.getX(),10+J.getY());
            if(10+J.getY()>600)
                J.setLocation(J.getX(),0);
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class eighteen extends JFrame{
    MyPanel panel=new MyPanel();
    public eighteen(){
        setTitle("눈 내리는 샤갈의 마을");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel); //배경 화면 띄우기

        for(int i=0;i<20;i++) {
            ImageIcon snow = new ImageIcon("C:\\Users\\chohs\\OneDrive - 한성대학교\\바탕 화면\\코딩캠프\\눈덩이1.png");
            JLabel MyLabel = new JLabel(snow);
            Container c = getContentPane();
            c.setLayout(null);
            MyLabel.setBounds((int)(Math.random()*500), (int)(Math.random()*500), 20, 20);
            c.add(MyLabel);
            SnowThread s = new SnowThread(MyLabel);
            s.start();
        }
        setSize(600,600);
        setVisible(true);
    }
    class MyPanel extends JPanel{
        private ImageIcon back=new ImageIcon("C:\\Users\\chohs\\OneDrive - 한성대학교\\바탕 화면\\코딩캠프\\배경화면.jpg"); //배경 삽입
        private Image img=back.getImage(); //이미지 객체
        public void paintComponent(Graphics g){ //배경을 넣어주고 눈 그림 하나에 그리고 스레드도 넣어주고
            super.paintComponent(g); //컴포넌트 생성
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this); //배경 넣기
        }
    }
    public static void main(String[] args){
        new eighteen();
    }
}
