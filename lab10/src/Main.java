import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main extends JPanel implements MouseMotionListener, ActionListener
{
    private JButton nope;
    private JButton yeap;
    private JLabel label;
    private JLabel nice;
    Main()
    {
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(this);
        this.setLayout(null);

        label = new JLabel("Are agree with your salary?");
        label.setBounds(200,0,200,20);

        nice = new JLabel("Nice!");
        nice.setBounds(250,250,100,50);
        yeap = new JButton("Course!");
        yeap.setBounds(150, 50, 100, 30);
        this.add(yeap);
        nope =new JButton("Nope.");
        nope.setBounds(350,50, 100,30);
        this.add(nope);
        yeap.addActionListener(this);
        nope.addActionListener(this);
        this.add(label);
        nope.setFocusPainted(false);
        frame.getContentPane().addMouseMotionListener(this);
        frame.setVisible(true);
    }
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(yeap.isEnabled()){
            JOptionPane.showMessageDialog(this,nice);
//            System.exit(0);
        }
    }
    public void mouseMoved(MouseEvent e)
    {
        this.MoveGetdirection(e.getX(), e.getY());
    }
    public void MoveGetdirection(int positionX,int positionY)
    {
        int centerButtonX=this.nope.getLocation().x+(this.nope.getWidth()/2);//Абсцисса середины кнопки
        int centerButtonY=this.nope.getLocation().y+(this.nope.getHeight()/2);//Абсцисса середины кнопки
        int r=(int)(this.nope.getWidth()*1.3);//радиус окружности в которой находится кнопка
        int distance=(int) (2*Math.sqrt(Math.pow(positionX-centerButtonX, 2)+Math.pow(positionY-centerButtonY, 2)));
        if (distance < r)
        {
            int dx = r - distance;//приращение по икс
            int dy = r - distance;//приращение по игрек
            //меняем на обратное если вверх и влево
            if(positionX>centerButtonX){dx=-dx;}
            if(positionY>centerButtonY){dy=-dy;}
            this.MoveDCmd(dx, dy, centerButtonX, centerButtonY);//Далее двигаем кнопку, проверяя есть место для перемещения
        }
    }

    public void MoveDCmd(int dx, int dy, int centerButtonX, int centerButtonY)
    {
        //если двигать вправо
        if (dx > 0) {//если справа есть место
            if (centerButtonX + this.nope.getWidth() / 2 + dx < this.getWidth()) {
                this.nope.setLocation(this.nope.getLocation().x += dx, this.nope.getLocation().y);//Двигаем
            }
        }
        //если двигать вниз
        if (dy > 0) {//если внизу есть место
            if (centerButtonY + this.nope.getHeight() / 2 + dy < this.getHeight()) {
                this.nope.setLocation(this.nope.getLocation().x, this.nope.getLocation().y += dy);//Двигаем
            }
        }
        //если двигать влево
        if (dx < 0) {//если слева есть место
            if (centerButtonX - this.nope.getWidth() / 2 > -dx) {
                this.nope.setLocation(this.nope.getLocation().x += dx, this.nope.getLocation().y);//Двигаем
            }
        }
        //если двигать вверх
        if (dy < 0) {//если вверху есть место
            if (centerButtonY - (this.nope.getHeight() / 2) > -dy) {
                this.nope.setLocation(this.nope.getLocation().x, this.nope.getLocation().y += dy);//Двигаем
            }
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}