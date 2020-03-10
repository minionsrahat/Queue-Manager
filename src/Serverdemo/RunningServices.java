package Serverdemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import Populate.*;

public class RunningServices extends JFrame {

    public JPanel p[] = new JPanel[10];
    public Container c;
    public Font f[] = new Font[10];
    public JTextField jtf[] = new JTextField[30];
    public JLabel jl[] = new JLabel[30];
    TitledBorder border[] = new TitledBorder[10];

    public RunningServices() {

        initcomponents();
        panel();
        border();
        textfield();
    }

    public void initcomponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 60, 1100, 900);
        c = this.getContentPane();
        c.setLayout(null);
    }

    public void panel() {
        p[1] = new JPanel();
        c.add(p[1]);
        p[1].setBounds(30, 30, 310, 300);
        p[1].setBackground(new Color(204, 204, 255));
        p[1].setLayout(null);
        jl[1] = new JLabel("Client Name");
        p[1].add(jl[1]);
        jl[1].setBounds(100, 30, 100, 50);
        jl[2] = new JLabel("Serial No:");
        p[1].add(jl[2]);
        jl[2].setBounds(20, 120, 100, 50);
        jl[3] = new JLabel("Updated Message:");
        p[1].add(jl[3]);
        jl[3].setBounds(80, 180, 150, 50);

        p[2] = new JPanel();
        c.add(p[2]);
        p[2].setBounds(680, 30, 310, 300);
        p[2].setBackground(new Color(204, 204, 255));
        p[2].setLayout(null);
        jl[4] = new JLabel("Client Name");
        p[2].add(jl[4]);
        jl[4].setBounds(100, 30, 100, 50);
        jl[5] = new JLabel("Serial No:");
        p[2].add(jl[5]);
        jl[5].setBounds(20, 120, 100, 50);
        jl[6] = new JLabel("Updated Message:");
        p[2].add(jl[6]);
        jl[6].setBounds(80, 180, 150, 50);

        p[3] = new JPanel();
        c.add(p[3]);
        p[3].setBounds(30, 360, 310, 300);
        p[3].setBackground(new Color(204, 204, 255));
        p[3].setLayout(null);
        jl[7] = new JLabel("Client Name");
        p[3].add(jl[7]);
        jl[7].setBounds(100, 30, 100, 50);
        jl[8] = new JLabel("Serial No:");
        p[3].add(jl[8]);
        jl[8].setBounds(20, 120, 100, 50);
        jl[9] = new JLabel("Updated Message:");
        p[3].add(jl[9]);
        jl[9].setBounds(80, 180, 150, 50);

        p[4] = new JPanel();
        c.add(p[4]);
        p[4].setBounds(680, 360, 310, 300);
        p[4].setBackground(new Color(204, 204, 255));
        p[4].setLayout(null);
        jl[10] = new JLabel("Client Name");
        p[4].add(jl[10]);
        jl[10].setBounds(100, 30, 100, 50);
        jl[11] = new JLabel("Serial No:");
        p[4].add(jl[11]);
        jl[11].setBounds(20, 120, 100, 50);
        jl[12] = new JLabel("Updated Message:");
        p[4].add(jl[12]);
        jl[12].setBounds(80, 180, 150, 50);

        p[5] = new JPanel();
        c.add(p[5]);
        p[5].setBounds(355, 250, 310, 300);
        p[5].setBackground(new Color(204, 204, 255));
        p[5].setLayout(null);
        jl[13] = new JLabel("Client Name");
        p[5].add(jl[13]);
        jl[13].setBounds(100, 30, 100, 50);
        jl[14] = new JLabel("Serial No:");
        p[5].add(jl[14]);
        jl[14].setBounds(20, 120, 100, 50);
        jl[15] = new JLabel("Updated Message:");
        p[5].add(jl[15]);
        jl[15].setBounds(80, 180, 150, 50);

    }

    public void border() {
        f[3] = new Font("Arial", Font.BOLD, 18);
        border[1] = new TitledBorder("RUNNING SERVICE DESK 1");
        border[1].setTitleJustification(TitledBorder.LEFT);
        border[1].setTitlePosition(TitledBorder.TOP);
        border[1].setTitleColor(Color.RED);
        border[1].setTitleFont(f[3]);
        p[1].setBorder(border[1]);

        border[2] = new TitledBorder("RUNNING SERVICE DESK 2");
        border[2].setTitleJustification(TitledBorder.LEFT);
        border[2].setTitlePosition(TitledBorder.TOP);
        border[2].setTitleColor(Color.RED);
        border[2].setTitleFont(f[3]);
        p[2].setBorder(border[2]);

        border[3] = new TitledBorder("RUNNING SERVICE DESK 3");
        border[3].setTitleJustification(TitledBorder.LEFT);
        border[3].setTitlePosition(TitledBorder.TOP);
        border[3].setTitleColor(Color.RED);
        border[3].setTitleFont(f[3]);
        p[3].setBorder(border[3]);

        border[4] = new TitledBorder("RUNNING SERVICE DESK 4");
        border[4].setTitleJustification(TitledBorder.LEFT);
        border[4].setTitlePosition(TitledBorder.TOP);
        border[4].setTitleColor(Color.RED);
        border[4].setTitleFont(f[3]);
        p[4].setBorder(border[4]);

        border[5] = new TitledBorder("RUNNING SERVICE DESK 5");
        border[5].setTitleJustification(TitledBorder.LEFT);
        border[5].setTitlePosition(TitledBorder.TOP);
        border[5].setTitleColor(Color.RED);
        border[5].setTitleFont(f[3]);
        p[5].setBorder(border[5]);
    }

    public void textfield() {
        //panel 1
        f[5] = new Font("Arial", Font.BOLD, 16);
        jtf[1] = new JTextField();
        jtf[1].setFont(f[5]);
        p[1].add(jtf[1]);
        jtf[1].setEditable(false);
        jtf[1].setBounds(50, 70, 200, 40);

        jtf[2] = new JTextField();
        jtf[2].setFont(f[5]);
        p[1].add(jtf[2]);
        jtf[2].setEditable(false);
        jtf[2].setBounds(100, 125, 50, 40);

        jtf[3] = new JTextField();
        jtf[3].setFont(f[5]);
        p[1].add(jtf[3]);
        jtf[3].setEditable(false);
        jtf[3].setBounds(40, 235, 220, 60);

        //panel 2
        jtf[4] = new JTextField();
        jtf[4].setFont(f[5]);
        p[2].add(jtf[4]);
        jtf[4].setEditable(false);
        jtf[4].setBounds(50, 70, 200, 40);

        jtf[5] = new JTextField();
        jtf[5].setFont(f[5]);
        p[2].add(jtf[5]);
        jtf[5].setEditable(false);
        jtf[5].setBounds(100, 125, 50, 40);

        jtf[6] = new JTextField();
        jtf[6].setFont(f[5]);
        p[2].add(jtf[6]);
        jtf[6].setEditable(false);
        jtf[6].setBounds(40, 235, 220, 60);

        //panel 3
        jtf[7] = new JTextField();
        jtf[7].setFont(f[5]);
        p[3].add(jtf[7]);
        jtf[7].setEditable(false);
        jtf[7].setBounds(50, 70, 200, 40);

        jtf[8] = new JTextField();
        jtf[8].setFont(f[5]);
        p[3].add(jtf[8]);
        jtf[8].setEditable(false);
        jtf[8].setBounds(100, 125, 50, 40);

        jtf[9] = new JTextField();
        jtf[9].setFont(f[5]);
        p[3].add(jtf[9]);
        jtf[9].setEditable(false);
        jtf[9].setBounds(40, 235, 220, 60);

        //panel 4
        jtf[10] = new JTextField();
        jtf[10].setFont(f[5]);
        p[4].add(jtf[10]);
        jtf[10].setEditable(false);
        jtf[10].setBounds(50, 70, 200, 40);

        jtf[11] = new JTextField();
        jtf[11].setFont(f[5]);
        p[4].add(jtf[11]);
        jtf[11].setEditable(false);
        jtf[11].setBounds(100, 125, 50, 40);

        jtf[12] = new JTextField();
        jtf[12].setFont(f[5]);
        p[4].add(jtf[12]);
        jtf[12].setEditable(false);
        jtf[12].setBounds(40, 235, 220, 60);

        //panel 5
        jtf[13] = new JTextField();
        jtf[13].setFont(f[5]);
        p[5].add(jtf[13]);
        jtf[13].setEditable(false);
        jtf[13].setBounds(50, 70, 200, 40);

        jtf[14] = new JTextField();
        jtf[14].setFont(f[5]);
        p[5].add(jtf[14]);
        jtf[14].setEditable(false);
        jtf[14].setBounds(100, 125, 50, 40);

        jtf[15] = new JTextField();
        jtf[15].setFont(f[5]);
        p[5].add(jtf[15]);
        jtf[15].setEditable(false);
        jtf[15].setBounds(40, 235, 220, 60);
    }

    public void populate_desk_1(Populate t1) {
        jtf[1].setText("");
        jtf[2].setText("");
        jtf[3].setText("");
        ////
        jtf[1].setText(t1.cn);
        jtf[2].setText(t1.sn);
    }

    public void populate_desk_2(Populate t1) {
        jtf[4].setText("");
        jtf[5].setText("");
        jtf[6].setText("");
        ////
        jtf[4].setText(t1.cn);
        jtf[5].setText(t1.sn);
    }

    public void populate_desk_3(Populate t1) {
        jtf[7].setText("");
        jtf[8].setText("");
        jtf[9].setText("");
        ////
        jtf[7].setText(t1.cn);
        jtf[8].setText(t1.sn);
    }

    public void populate_desk_4(Populate t1) {
        jtf[10].setText("");
        jtf[11].setText("");
        jtf[12].setText("");
        ////
        jtf[10].setText(t1.cn);
        jtf[11].setText(t1.sn);
    }

    public void populate_desk_5(Populate t1) {
        jtf[13].setText("");
        jtf[14].setText("");
        jtf[15].setText("");
        ////
        jtf[13].setText(t1.cn);
        jtf[14].setText(t1.sn);
    }

    public static void main(String[] args) {
        RunningServices frame = new RunningServices();
        // frame.setVisible(true);

    }
}
