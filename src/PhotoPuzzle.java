//그림 퍼즐 코드
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PhotoPuzzle extends JFrame {
    public BufferedImage img; // 받아올 이미지
    int r = 4; // 가로 분할 갯수
    int c = 4; // 세로 분할 갯수
    public BufferedImage sub_img[][] = new BufferedImage[c][r]; // 분할된 이미지
    public int answer_index[][]=new int[c][r]; //정답 인덱스
    int check[][] = new int[c][r];

    int count=0; //각 패널의 인덱스
    MyPanel panel_arr[][]=new MyPanel[c][r];
    Container contentPane;
    public PhotoPuzzle() { // 생성자
        setTitle("그림 퍼즐");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(c,r,2,2));
        ImgDiv(); // 이미지 분할 함수
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                //분할된 이미지를 panel에 삽입
                panel_arr[i][j]=new MyPanel(sub_img[i][j],count++);
                check[i][j]=0;
            }
        }
        int panel_index=0;
        int rand_c,rand_r;
        while(panel_index<16){
            rand_c=(int)(Math.random()*c);
            rand_r=(int)(Math.random()*r);
            if(check[rand_c][rand_r]==1){
                continue;
            }
            contentPane.add(panel_arr[rand_c][rand_r]);
            check[rand_c][rand_r]=1;
            panel_arr[rand_c][rand_r].setCurr_index(panel_index);
            panel_index++;
        }

        MyMouseListener listener = new MyMouseListener();
        contentPane.addMouseListener(listener);

        setSize(700, 700);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter{
        int selected1;
        int selected2;
        MyPanel JP1;
        MyPanel JP2;
        
       public void mousePressed(MouseEvent e){
           Container p=(Container)e.getSource();
           JP1=(MyPanel) p.getComponentAt(e.getPoint());
           selected1=JP1.curr_index;
       }
        public void mouseReleased(MouseEvent e) {
            Container p=(Container)e.getSource();
            JP2=(MyPanel)p.getComponentAt(e.getPoint());
            selected2=JP2.curr_index;

            JP2.setCurr_index(selected1);
            JP1.setCurr_index(selected2);
            
            contentPane.removeAll();
            int count=0;
            while(count<c*r){
                for(int i=0;i<c;i++){
                    for(int j=0;j<r;j++){
                        if(panel_arr[i][j].curr_index==count) {
                            contentPane.add(panel_arr[i][j]);
                            break;
                        }
                    }
                }
                count++;
            }
            contentPane.revalidate();
            contentPane.repaint();

            if(checkAnswer()){
                JOptionPane.showMessageDialog(null,"축하드립니다!","성공",JOptionPane.ERROR_MESSAGE);
            }
       }
    }
    public boolean checkAnswer(){
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                if(panel_arr[i][j].getAns_index()!=panel_arr[i][j].getCurr_index()){
                    return false;
                }
            }
        }
        return  true;
    }
    public void ImgDiv() {
        try { // 이미지를 받아온다.
            img = ImageIO.read(new File("C:\\Users\\chohs\\OneDrive - 한성대학교\\바탕 화면\\코딩캠프\\퍼즐이미지.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ans_index=0;
        int width = img.getWidth() / r; // 이미지의 너비
        int height = img.getHeight() / c; // 이미지의 높이
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                // 분할된 이미지 저장
                sub_img[i][j] = img.getSubimage(j * width, i * height, width, height);
                answer_index[i][j]=ans_index++;
            }
        }
    }
    class MyPanel extends JPanel {
        BufferedImage b;
        int ans_index;
        int curr_index;
        public MyPanel(BufferedImage b,int n){
            this.b=b;
            this.ans_index=n;
        }
        public void setCurr_index(int c){
            curr_index=c;
        }
        public int getCurr_index(){
            return curr_index;
        }
        public int getAns_index(){
            return ans_index;
        }
        public void paintComponent(Graphics g) {
            g.drawImage(b,0,0,MyPanel.this.getWidth(),MyPanel.this.getHeight(),this);
        }
    }
    public static void main(String[] args) {
        new PhotoPuzzle();
    }
}
