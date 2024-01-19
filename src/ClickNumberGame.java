//11번:1~9까지 숫자를 순서대로 클릭하여 지우기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClickNumberGame extends JFrame{
    int rm=1; //현재 지우고자하는 숫자
    Container c =getContentPane();
    public ClickNumberGame(){
        setTitle("Ten 레이블 클릭");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setLayout(null);
        for(int i=1;i<10;i++) { //랜덤한 위치에 1~10 뿌리기
            JLabel JL = new JLabel("" + i); //글자 생성하고
            int x = (int) (Math.random() * 500); //랜덤 x값
            int y = (int) (Math.random() * 500); //랜덤 y값
            JL.setBounds(x, y, 50, 50); //위치 설정
            JL.addMouseListener(new MyMouseListener());
            c.add(JL); //컨테이너에 삽입
        }

        setSize(600,600);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            //만약 현재 지우고자 하는 값과 내가 누른 값이 같으면 삭제
            JLabel MyLabel=(JLabel)e.getSource(); //내 마우스 위의 글자
            if(Integer.parseInt(MyLabel.getText())==rm) {
                c.remove(MyLabel);
                c.repaint();
                rm++;
                if(Integer.parseInt(MyLabel.getText())==9){ //마지막 숫자를 눌렀다면
                    //다 지우면 콘솔창 출력
                    JOptionPane.showMessageDialog(null,"축하드립니다!","성공",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    public static void main(String[] args){
        new ClickNumberGame();
    }
}
