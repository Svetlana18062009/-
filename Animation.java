import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Animation extends JComponent implements KeyListener, ActionListener {
    private int x=0, y=0,H=25,W=25;
    Rectangle rectangle=new Rectangle(x,y,H,W);

    Timer t= new Timer(5,this);
    public static void main(String[] args) {
        Animation main = new Animation();
        JFrame f=new JFrame("Game");
        f.setSize(400,400);
        f.setVisible(true);
        f.setLocation(750,400);
        f.add(main);
        f.addKeyListener(main);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
 public void paint(Graphics g){
        Graphics2D g1=(Graphics2D)g;
       g1.fill(rectangle);
       t.start();

 }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(x<400-(W+10))
            rectangle.setLocation(rectangle.x+3,rectangle.y);
            x+=3;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(x>0)
                rectangle.setLocation(rectangle.x - 3, rectangle.y);
                x -= 3;

        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(y<400-(H+40))
            rectangle.setLocation(rectangle.x,rectangle.y+3);
            y+=3;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            if(y>0)
                rectangle.setLocation(rectangle.x,rectangle.y-3);
            y-=3;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN && e.getKeyCode()==KeyEvent.VK_RIGHT){
            rectangle.setLocation(rectangle.x+2,rectangle.y+2);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
