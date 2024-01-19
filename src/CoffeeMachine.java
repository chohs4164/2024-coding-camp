//9번:커피 머신 코드
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CoffeeMachine extends JFrame {
    int cup = 10;
    int coffee = 10;
    int water = 10;
    int sugar = 10;
    int cream = 10;
    MyPanel center = new MyPanel();

    public CoffeeMachine() {
        setTitle("Open Challenge 14");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel title = new JPanel(new FlowLayout());
        JLabel welcomeLabel = new JLabel("Welcome, Hot Coffee!!");
        title.add(welcomeLabel);
        title.setBackground(Color.YELLOW);
        add(title, BorderLayout.NORTH);

        add(center, BorderLayout.CENTER);

        JButton JB1 = new JButton("Black Coffee");
        JButton JB2 = new JButton("Sugar Coffee");
        JButton JB3 = new JButton("Dabang Coffee");
        JButton JB4 = new JButton("Reset");

        MyActionListener listener = new MyActionListener();
        JB1.addActionListener(listener);
        JB2.addActionListener(listener);
        JB3.addActionListener(listener);
        JB4.addActionListener(listener);

        JPanel end = new JPanel(new FlowLayout());
        end.add(JB1);
        end.add(JB2);
        end.add(JB3);
        end.add(JB4);

        add(end, BorderLayout.SOUTH);

        setSize(500, 300);
        setVisible(true);
    }

    private String selectedCoffeeType;

    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            selectedCoffeeType = b.getText();

            if (selectedCoffeeType.equals("Black Coffee")) {
                if (cup == 0 || coffee == 0 || water == 0) //비어 있으면
                    JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요");
                else { //안비어있으면
                    cup--; coffee--; water--;
                    center.repaint();
                    JOptionPane.showMessageDialog(null, "뜨거워요, 즐거운 하루~~");
                }
            }
            if (selectedCoffeeType.equals("Sugar Coffee")) {
                if (cup == 0 || coffee == 0 || water == 0 || sugar == 0) //비어있으면
                    JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요");
                else { //안비어있으면
                    cup--; coffee--; water--;sugar--;
                    center.repaint();
                    JOptionPane.showMessageDialog(null, "뜨거워요, 즐거운 하루~~");
                }
            }

            if (selectedCoffeeType.equals("Dabang Coffee")) { //비어있으면
                if (cup == 0 || coffee == 0 || water == 0 || sugar == 0 || cream == 0)
                    JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요");
                else { //안비어있으면
                    cup--; coffee--; water--;sugar--;cream--;
                    center.repaint();
                    JOptionPane.showMessageDialog(null, "뜨거워요, 즐거운 하루~~");
                }
            }
            if (selectedCoffeeType.equals("Reset")) {
                cup = 10;
                coffee = 10;
                water = 10;
                sugar = 10;
                cream = 10;
                center.repaint();
            }
        }
    }

    private class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

                g.setColor(Color.GRAY);
                g.fillRect(70, 20+(10*(10-cup)), 40, 10 * cup);

                g.setColor(Color.ORANGE);
                g.fillRect(140, 20 + (10*(10-coffee)), 40, 10 * coffee);

                g.setColor(Color.BLUE);
                g.fillRect(210, 20 + (10*(10-water)), 40, 10 * water);

                g.setColor(Color.WHITE);
                g.fillRect(280, 20 + (10*(10-sugar)), 40, 10 * sugar);

                g.setColor(Color.CYAN);
                g.fillRect(350, 20 + (10*(10-cream)), 40, 10 * cream);

            g.setColor(Color.BLACK);
            g.drawString("Cup", 70, 140);
            g.drawString("Coffee", 140, 140);
            g.drawString("Water", 210, 140);
            g.drawString("Sugar", 280, 140);
            g.drawString("Cream", 350, 140);
        }
    }

    public static void main(String[] args) {
        new CoffeeMachine();
    }
}
