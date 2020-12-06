import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JDialog {
    private int x;
    private int y;
    private JPanel content;
    private JButton buttonCancel;
    private JLabel label;
    private JButton button;
    private JPanel panel;

    public MainWindow() {
        setContentPane(content);
        setModal(true);
        panel.setLayout(null);
        button.setBounds(150, 150, 100, 30  );
        panel.setPreferredSize(new Dimension(500, 500));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                button.setLocation(panel.getMousePosition());
            }
        });
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                StringBuffer buf = new StringBuffer();
                buf.append("X = " + e.getX() + "; Y = " + e.getY());
                label.setText(buf.toString());
            }
        });
        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                StringBuffer stringBuffer = new StringBuffer();
                int x = e.getX() + button.getX();
                int y = e.getY() + button.getY();
                stringBuffer.append("X = " + x + "; Y = " + y);
                label.setText(stringBuffer.toString());
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("X = " + e.getX() + "; Y = " + e.getY());
                label.setText(stringBuffer.toString());
            }
        });
        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                getStartOfMainCoordinates();
                if (e.isControlDown())
                    button.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
                StringBuffer stringBuffer = new StringBuffer();
                int x = e.getXOnScreen() - MainWindow.this.x;
                int y = e.getYOnScreen() - MainWindow.this.y;
                stringBuffer.append("X = " + x + "; Y = " + y);
                label.setText(stringBuffer.toString());
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(button.getText());
                    if (stringBuffer.length() != 0)
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    button.setText(stringBuffer.toString());
                }
                else if ((e.getKeyChar() >= '!' && e.getKeyChar() <= '~') || (e.getKeyChar() >= 'А' && e.getKeyChar() <= 'я')) {
                    StringBuffer buf = new StringBuffer();
                    buf.append(button.getText());
                    buf.append(e.getKeyChar());
                    button.setText(buf.toString());
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

    }

    private void onCancel() {
        dispose();
    }

    private void getStartOfMainCoordinates() {
        x = panel.getLocationOnScreen().x;
        y = panel.getLocationOnScreen().y;
    }

    public static void main(String[] args) {
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}