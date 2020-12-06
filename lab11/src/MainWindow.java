import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;

public class MainWindow extends JFrame{
    private JButton open;
    private JButton save;
    public JScrollPane pane;
    private MyPanel panel;
    private JRadioButton red;
    private JRadioButton green;
    private JRadioButton blue;
    private JRadioButton black;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private Color color;
    private JFileChooser fileChooser;
    private File file;

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    MainWindow(){
        super("Paint");
        open = new JButton("Open...");
        save = new JButton("Save...");

        panel = new MyPanel();
        pane = new JScrollPane(panel);

        int width = 1320;
        int height = 730;
        pane.setPreferredSize(new Dimension(width, height));
        pane.setBackground(Color.WHITE);
        red = new JRadioButton("Red");
        green = new JRadioButton("Green");
        blue = new JRadioButton("Blue");
        black = new JRadioButton("Black");
        ButtonGroup colorGroup = new ButtonGroup();
        color = Color.RED;
        colorGroup.add(black);
        colorGroup.add(green);
        colorGroup.add(blue);
        colorGroup.add(red);
        red.setSelected(true);
        secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(1, 4));
        secondPanel.add(black);
        secondPanel.add(green);
        secondPanel.add(blue);
        secondPanel.add(red);
        thirdPanel= new JPanel();
        thirdPanel.setLayout(new GridLayout(1,2));
        thirdPanel.add(save);
        thirdPanel.add(open);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(secondPanel, BorderLayout.SOUTH);
        getContentPane().add(thirdPanel,BorderLayout.NORTH);

        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        panel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent mouseEvent){
                x1 = mouseEvent.getX();
                y1 = mouseEvent.getY();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent mouseEvent){
                x2 = mouseEvent.getX();
                y2 = mouseEvent.getY();

                Graphics panelGraphics = panel.getGraphics();
                Graphics buffer = panel.getBuffer().getGraphics();
                chooseColor();
                buffer.setColor(color);
                panelGraphics.setColor(color);

                buffer.drawLine(x1, y1, x2, y2);
                panelGraphics.drawLine(x1, y1, x2, y2);

                x1 = x2;
                y1 = y2;
            }
        });

        open.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent){
                fileChooser.setDialogTitle("Choose image, that you want to open: ");
                int returnValue = fileChooser.showOpenDialog(MainWindow.this);
                if (returnValue == JFileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    try{
                        BufferedImage bufferedImage = ImageIO.read(file);
                        panel.loadImage(bufferedImage);
                    } catch (IOException exception){
                        System.out.println(exception.getMessage());
                    }
                }
            }
        });

        save.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent){
                fileChooser.setDialogTitle("Save image: ");
                int ret = fileChooser.showSaveDialog(null);
                file = fileChooser.getSelectedFile();
                if (ret == fileChooser.APPROVE_OPTION){
                    try{
                        ImageIO.write(panel.getBuffer(), "png", file);

                    } catch (IOException exception){
                        exception.getMessage();
                    }
                }
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void chooseColor(){
        if (red.isSelected()){
            color = Color.RED;
        } else if (green.isSelected()){
            color = Color.GREEN;
        } else if (blue.isSelected()){
            color = Color.BLUE;
        } else if(black.isSelected()){
            color=Color.BLACK;
        }
    }
}
