import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.TextUI;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class MyFrame extends JFrame implements ActionListener {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField inputIndexField;
    private JLabel firstRequire;
    private JLabel secondRequire;

    private JComboBox comboBoxSeries;

    private String[] series = {"Lines", "Exponential"};

    private JRadioButton functionSum;
    private JRadioButton functionCalculation;
    private JRadioButton functionShowElements;
    private JRadioButton functionSave;

    private JButton execute;

    private JLabel outField;
    private String type;

//    public void itemStateChanged(ItemEvent e) {
//        type = series[comboBoxSeries.getSelectedIndex()];
//    }
//    public void mouseReleased(MouseEvent e){}

    public void actionPerformed(ActionEvent e) {

        int n = Integer.parseInt(field1.getText());
        double a = Double.parseDouble(field2.getText());
        double d = Double.parseDouble(field3.getText());
        type = series[comboBoxSeries.getSelectedIndex()];
        if (type.equals(series[0])) {
            Liner liner = new Liner(n, d, a);
            if (functionCalculation.isSelected()) {
                double index = liner.calculationElemnt(Integer.parseInt(inputIndexField.getText()));
                outField.setText(String.valueOf(index));
            } else if (functionSum.isSelected()) {
                outField.setText(String.valueOf(liner.sumProgression()));
            } else if (functionSave.isSelected()) {
                try {
                    liner.recordInFile("Output.txt");
                    outField.setText("Success! Check in work directory.");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            } else {
                outField.setText(liner.toString());
            }
        } else {
            Exponential exponential = new Exponential(n, d, a);
            if (functionCalculation.isSelected()) {
                double index = exponential.calculationElemnt(Integer.parseInt(inputIndexField.getText()));
                outField.setText(String.valueOf(index));
            } else if (functionSum.isSelected()) {
                outField.setText(String.valueOf(exponential.sumProgression()));
            } else if (functionSave.isSelected()) {
                try {
                    exponential.recordInFile("Output.txt");
                    outField.setText("Success! Check in work directory.");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            } else {
                outField.setText(exponential.toString());
            }
        }
    }


    MyFrame(String name) {
        super(name);
        setBounds(500, 150, 305, 380);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel("Enter size: ");
        label2 = new JLabel("Enter a1: ");
        label3 = new JLabel("Enter d:");
        label1.setBounds(10, 10, 80, 12);
        label2.setBounds(10, 30, 80, 12);
        label3.setBounds(10, 50, 80, 12);

        field1 = new JTextField();
        field1.setBounds(label1.getX() + 80, label1.getY(), 200, 17);

        field2 = new JTextField();
        field2.setBounds(label2.getX() + 80, label2.getY(), 200, 17);

        field3 = new JTextField();
        field3.setBounds(label3.getX() + 80, label3.getY(), 200, 17);

        firstRequire = new JLabel("Choose type of series: ");
        firstRequire.setBounds(label3.getX(), label3.getY() + 30, 170, 17);

        secondRequire = new JLabel("Choose function(s): ");
        secondRequire.setBounds(firstRequire.getX(), firstRequire.getY() + 30, 160, 17);

        comboBoxSeries = new JComboBox(series);
        comboBoxSeries.setBounds(firstRequire.getX() + firstRequire.getWidth()+10, firstRequire.getY(), 100, 17);
        comboBoxSeries.setSelectedIndex(0);

        ButtonGroup buttonGroup = new ButtonGroup();
        functionCalculation = new JRadioButton("Calculation");
        functionCalculation.setBounds(secondRequire.getX() + 150, secondRequire.getY(), 120, 17);

        inputIndexField = new JTextField();
        inputIndexField.setBounds(functionCalculation.getX() + 20, functionCalculation.getY() + 20, 100, 17);

        functionSum = new JRadioButton("Sum of series");
        functionSum.setBounds(functionCalculation.getX(), functionCalculation.getY() + 40, 120, 17);


        functionSave = new JRadioButton("Save");
        functionSave.setBounds(functionCalculation.getX(), functionSum.getY() + 20, 100, 17);

        functionShowElements = new JRadioButton("Show elements");
        functionShowElements.setBounds(functionSave.getX(), functionSave.getY() + 20, 120, 17);

        outField = new JLabel();
        outField.setBounds(10, functionShowElements.getY() + 20, 235, 70);
        outField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        execute = new JButton("Execute");
        execute.setBounds(functionShowElements.getX() - 60, functionShowElements.getY() + 100, 120, 30);
        add(execute);

      //  execute.setFocusPainted(false);
      //  execute.addItemListener(this);
        execute.addActionListener(this);

        add(label1);
        add(label2);
        add(label3);


        add(field1);
        add(field2);
        add(field3);


        add(firstRequire);
        add(secondRequire);
        add(comboBoxSeries);

        add(functionCalculation);
        add(inputIndexField);
        add(functionSum);
        add(functionSave);
        add(functionShowElements);

        buttonGroup.add(functionCalculation);
        buttonGroup.add(functionSave);
        buttonGroup.add(functionShowElements);
        buttonGroup.add(functionSum);

        add(outField);

        setVisible(true);
    }
}
