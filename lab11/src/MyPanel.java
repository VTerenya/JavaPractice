import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


class MyPanel extends JPanel{
    private BufferedImage buffer;

    MyPanel(){
        int bufferWidth = 1320;
        int bufferHeight = 730;
        buffer = new BufferedImage(bufferWidth, bufferHeight, BufferedImage.TYPE_INT_ARGB);
        setPreferredSize(new Dimension(bufferWidth, bufferHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics){
        graphics.drawImage(buffer, 0, 0, null);
    }

    public BufferedImage getBuffer(){
        return buffer;
    }

    public void loadImage(BufferedImage bufferedImage){
        buffer.createGraphics().setColor(Color.WHITE);
        buffer.createGraphics().drawImage(bufferedImage,0,0,null);
        repaint();
    }
}
