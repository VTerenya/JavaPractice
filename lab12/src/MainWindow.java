import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainWindow extends JFrame{
    JTabbedPane mainPane;
    JPanel panelTask1;
    MyPanel panelTask2;
    Task3 panelTask3;
    ButtonGroup radioButtonGroup;
    JRadioButton[] radioButtons;
    JList leftList, rightList;
    DefaultListModel leftListModel, rightListModel;
    JButton moveToLeftList, moveToRightList;
    public final static Dimension SIZE = new Dimension(800, 500);
    public final static Dimension LIST_SIZE = new Dimension(300, 500);


    MainWindow(){

        super("Lab12");
        mainPane = new JTabbedPane();
        panelTask1 = new JPanel();
        JPanel panelButtons = new JPanel(new BorderLayout());

        leftListModel = new DefaultListModel();
        rightListModel = new DefaultListModel();
        leftList = new JList(leftListModel);
        rightList = new JList(rightListModel);
        radioButtonGroup = new ButtonGroup();
        moveToLeftList = new JButton("<<<");
        moveToRightList = new JButton(">>>");
        panelTask2 = new MyPanel();
        panelTask3 = new Task3();

        panelTask1.setLayout(new BorderLayout());
        panelTask1.add(leftList, BorderLayout.WEST);
        panelTask1.add(rightList, BorderLayout.EAST);
        panelButtons.add(moveToLeftList, BorderLayout.SOUTH);
        panelButtons.add(moveToRightList, BorderLayout.NORTH);
        panelTask1.add(panelButtons, BorderLayout.CENTER);
        panelTask1.setPreferredSize(SIZE);
        leftList.setPreferredSize(LIST_SIZE);
        rightList.setPreferredSize(LIST_SIZE);

        leftListModel.addElement("\\_(/\\ - /\\)_/");
        leftListModel.addElement(1);
        leftListModel.addElement(321.123);
        leftListModel.addElement("xxxxxxxDDDD");
        leftListModel.addElement("Heellooww, world ff!");
        rightListModel.addElement("Salam aleuky");
        rightListModel.addElement("Nixao, myjiki!");
        leftListModel.addElement("I am an applepen!");

        mainPane.add(panelTask1, "Task 1");
        mainPane.add(panelTask2, "Task 2");
        mainPane.add(panelTask3, "Task 3");
        add(mainPane);

        moveToLeftList.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int[] temp = rightList.getSelectedIndices();
                if (temp.length == 0){
                    for (Object item : rightListModel.toArray()){
                        leftListModel.addElement(item);
                    }
                    rightListModel.clear();
                } else if (temp.length != 0){
                    int i = 0;
                    for (int index : temp){
                        leftListModel.addElement(rightListModel.get(index - i));
                        rightListModel.removeElementAt(index - i);
                        i++;
                    }

                }
            }
        });

        moveToRightList.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int[] temp = leftList.getSelectedIndices();
                if (temp.length == 0){
                    for (Object item : leftListModel.toArray()){
                        rightListModel.addElement(item);
                    }
                    leftListModel.clear();
                } else if (temp.length != 0){
                    int i = 0;
                    for (int index : temp){
                        rightListModel.addElement(leftListModel.get(index - i));
                        leftListModel.removeElementAt(index - i);
                        i++;
                    }
                }
            }
        });



        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                onClose();
            }
        });
    }

    private void onClose(){
        dispose();
    }

}
