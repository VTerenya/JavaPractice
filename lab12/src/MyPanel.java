import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener{

    final static Color color = new Color(255,252,3);
    private String txt;

    public MyPanel(){
        setLayout(new GridLayout(5 , 5));
        setPreferredSize(MainWindow.SIZE);
        for (int i = 0 ; i < 25 ; i++){
            txt = "Awesome!";
            JButton button = new JButton(txt);
            button.addMouseListener(this);
            button.setBackground(color);
            add(button);
        }
         txt = "";
    }
    public void mouseEntered(MouseEvent e){
        JButton tempButton;
        tempButton = (JButton) e.getSource();
        tempButton.setBackground(new Color(126, 105, 220));
    }
    public void mouseExited(MouseEvent e)
    {
        JButton tempButton;
        tempButton = (JButton) e.getSource();
        tempButton.setBackground(color);
    }
    public void mousePressed(MouseEvent e)
    {
        JButton tempButton;
        tempButton = (JButton) e.getSource();
        txt = tempButton.getText();
        tempButton.setText("Nice!");
    }
    public void mouseReleased(MouseEvent e)
    {
        JButton tempButton;
        tempButton = (JButton) e.getSource();
        tempButton.setText(txt);
    }
    public void mouseClicked(MouseEvent e) {}
}
