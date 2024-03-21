package views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class QueryRequestView {

    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 900;
    private final JFrame frame;

    private JButton buttonViewQuery1;
    private JButton buttonViewQuery2;
    private JButton buttonViewQuery3;
    private JButton buttonViewQuery4;
    private JButton buttonViewQuery5;
    private JButton buttonViewQuery6;
    private JButton buttonViewQuery7;
    private JButton buttonViewQuery8;

    HintTextField hintTextFieldGenreQuery1;
    HintTextField hintTextFieldMinPagesQuery1;
    HintTextField hintTextFieldMaxPagesQuery1;
    HintTextField hintTextFieldOverdueQuery2;
    HintTextField hintTextFieldGenreQuery3;
    HintTextField hintTextFieldNumberOfDaysQuery3;
    HintTextField hintTextFieldKeywordQuery5;

    public QueryRequestView() {
        this.frame = new JFrame();

        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Library Manager");

        addComponents();

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addComponents() {
        JLabel label1 = new JLabel("Găsiți cărți dintr-un gen cu pagini dintr-un anumit interval");
        JLabel label2 = new JLabel("Gasiti imprumuturile ce nu au fost restituite cu întârziere peste X zile");
        JLabel label3 = new JLabel("Găsiți utilizatori care au împrumutat cărți dintr-un anumit gen");
        JLabel label4 = new JLabel("Găsiți cărți cu mai mulți autori");
        JLabel label5 = new JLabel("Găsiți cărți care au un anumit cuvânt cheie în titlu");
        JLabel label6 = new JLabel("Găsiți cărțile și autorii acestora care au cele mai multe exemplare");
        JLabel label7 = new JLabel("Găsiți utilizatori care nu și-au returnat cărțile împrumutate");
        JLabel label8 = new JLabel("Vedeți statisticile pentru fiecare gen");

        label1.setBounds(50, 50, 400, 20);
        label2.setBounds(50, 150, 400, 20);
        label3.setBounds(50, 250, 400, 20);
        label4.setBounds(50, 350, 400, 20);
        label5.setBounds(50, 450, 400, 20);
        label6.setBounds(50, 550, 400, 20);
        label7.setBounds(50, 650, 400, 20);
        label8.setBounds(50, 750, 400, 20);

        hintTextFieldGenreQuery1 = new HintTextField("Genre");
        hintTextFieldMinPagesQuery1 = new HintTextField("Min");
        hintTextFieldMaxPagesQuery1 = new HintTextField("Max");
        hintTextFieldOverdueQuery2 = new HintTextField("Overdue");
        hintTextFieldGenreQuery3 = new HintTextField("Genre");
        hintTextFieldNumberOfDaysQuery3 = new HintTextField("Days");
        hintTextFieldKeywordQuery5 = new HintTextField("Keyword");

        hintTextFieldGenreQuery1.setBounds(50, 75, 100, 20);
        hintTextFieldMinPagesQuery1.setBounds(200, 75, 100, 20);
        hintTextFieldMaxPagesQuery1.setBounds(200, 100, 100, 20);
        hintTextFieldOverdueQuery2.setBounds(150, 200, 100, 20);
        hintTextFieldGenreQuery3.setBounds(50, 300, 100, 20);
        hintTextFieldNumberOfDaysQuery3.setBounds(200, 300, 100, 20);
        hintTextFieldKeywordQuery5.setBounds(150, 500, 100, 20);

        frame.add(hintTextFieldGenreQuery1);
        frame.add(hintTextFieldMinPagesQuery1);
        frame.add(hintTextFieldMaxPagesQuery1);
        frame.add(hintTextFieldOverdueQuery2);
        frame.add(hintTextFieldGenreQuery3);
        frame.add(hintTextFieldNumberOfDaysQuery3);
        frame.add(hintTextFieldKeywordQuery5);

        buttonViewQuery1 = new JButton("View");
        buttonViewQuery2 = new JButton("View");
        buttonViewQuery3 = new JButton("View");
        buttonViewQuery4 = new JButton("View");
        buttonViewQuery5 = new JButton("View");
        buttonViewQuery6 = new JButton("View");
        buttonViewQuery7 = new JButton("View");
        buttonViewQuery8 = new JButton("View");

        buttonViewQuery1.setBounds(350, 100, 80, 20);
        buttonViewQuery2.setBounds(350, 200, 80, 20);
        buttonViewQuery3.setBounds(350, 300, 80, 20);
        buttonViewQuery4.setBounds(350, 400, 80, 20);
        buttonViewQuery5.setBounds(350, 500, 80, 20);
        buttonViewQuery6.setBounds(350, 600, 80, 20);
        buttonViewQuery7.setBounds(350, 700, 80, 20);
        buttonViewQuery8.setBounds(350, 800, 80, 20);

        frame.add(buttonViewQuery1);
        frame.add(buttonViewQuery2);
        frame.add(buttonViewQuery3);
        frame.add(buttonViewQuery4);
        frame.add(buttonViewQuery5);
        frame.add(buttonViewQuery6);
        frame.add(buttonViewQuery7);
        frame.add(buttonViewQuery8);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(label8);
    }

    public String getHintTextFieldGenreQuery1() {
        return hintTextFieldGenreQuery1.getText();
    }

    public String getHintTextFieldMinPagesQuery1() {
        return hintTextFieldMinPagesQuery1.getText();
    }

    public String getHintTextFieldMaxPagesQuery1() {
        return hintTextFieldMaxPagesQuery1.getText();
    }

    public String getHintTextFieldOverdueQuery2() {
        return hintTextFieldOverdueQuery2.getText();
    }

    public String getHintTextFieldGenreQuery3() {
        return hintTextFieldGenreQuery3.getText();
    }

    public String getHintTextFieldNumberOfDaysQuery3() {
        return hintTextFieldNumberOfDaysQuery3.getText();
    }

    public String getHintTextFieldKeywordQuery5() {
        return hintTextFieldKeywordQuery5.getText();
    }

    public void setButtonViewQuery1ActionListener(ActionListener actionListener) {
        buttonViewQuery1.addActionListener(actionListener);
    }

    public void setButtonViewQuery2ActionListener(ActionListener actionListener) {
        buttonViewQuery2.addActionListener(actionListener);
    }

    public void setButtonViewQuery3ActionListener(ActionListener actionListener) {
        buttonViewQuery3.addActionListener(actionListener);
    }

    public void setButtonViewQuery4ActionListener(ActionListener actionListener) {
        buttonViewQuery4.addActionListener(actionListener);
    }

    public void setButtonViewQuery5ActionListener(ActionListener actionListener) {
        buttonViewQuery5.addActionListener(actionListener);
    }

    public void setButtonViewQuery6ActionListener(ActionListener actionListener) {
        buttonViewQuery6.addActionListener(actionListener);
    }

    public void setButtonViewQuery7ActionListener(ActionListener actionListener) {
        buttonViewQuery7.addActionListener(actionListener);
    }

    public void setButtonViewQuery8ActionListener(ActionListener actionListener) {
        buttonViewQuery8.addActionListener(actionListener);
    }
}
