package Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PandaStatusPanel extends JPanel {

    JLabel pandaStatusLB, exitLB, exitDecisionLB;
    static JTextArea currentActivityTA, suggestionTA, explainTA;
    static JLabel feedingamountLB;
    Font statusFont = new Font("Courier",Font.PLAIN,20);

    JPanel p1,p2;
    static JTabbedPane tp;

    JButton exitBT;

    public PandaStatusPanel(){
        this.setBounds(600,0,300,425);
        this.setLayout(null);

        p1 = selectStatus();
        p2 = selectExit();

        tp = new JTabbedPane();

        tp.setBounds(0,0,300,425);
        tp.setTabPlacement(JTabbedPane.TOP);
        tp.setFont(new Font("Courier",Font.PLAIN,20));
        tp.setBackground(getBackground());
        tp.setForeground(Color.black);

        p1.setBackground(new Color(144,232,194));
        p2.setBackground(new Color(230,200,216));

        tp.addTab("Status",p1);
        tp.addTab("Exit",p2);

        this.add(tp);

    }

    /*
     * Create template of Status Tab in the simulation
     */
    private JPanel selectStatus(){
        JPanel statusPanel = new JPanel();
        Font taFont = new Font("Courier",Font.PLAIN,17);
        pandaStatusLB = new JLabel(LoginPanel.panda_name +"'s Status",JLabel.CENTER);
        feedingamountLB = new JLabel("Food eatten: ",JLabel.CENTER);

        currentActivityTA = new JTextArea();
        currentActivityTA.setText("Current Activity:");
        currentActivityTA.setEditable(false);
        currentActivityTA.setLineWrap(true);
        currentActivityTA.setWrapStyleWord(true);

        suggestionTA = new JTextArea();
        suggestionTA.setText("Press any button on the panel located at the bottom of the frame");
        suggestionTA.setEditable(false);
        suggestionTA.setLineWrap(true);
        suggestionTA.setWrapStyleWord(true);

        pandaStatusLB.setFont(statusFont);
        currentActivityTA.setFont(taFont);
        suggestionTA.setFont(taFont);
        feedingamountLB.setFont(statusFont);

        currentActivityTA.setBackground(Color.pink);
        suggestionTA.setBackground(Color.white);

        JPanel textareaPanel = new JPanel(new GridLayout(2,1));
        textareaPanel.add(currentActivityTA);
        textareaPanel.add(suggestionTA);

        statusPanel.setLayout(new BorderLayout());
        statusPanel.add(pandaStatusLB, BorderLayout.NORTH);
        statusPanel.add(textareaPanel, BorderLayout.CENTER);
        statusPanel.add(feedingamountLB, BorderLayout.SOUTH);

        return statusPanel;
    }

    /*
     * Create the template of Exit Tab in the simulation
     */
    private JPanel selectExit(){
        JPanel exitPanel = new JPanel();
        JPanel middlePanel = new JPanel(new GridLayout(2,1));
        exitLB = new JLabel("Exit?",JLabel.CENTER);
        exitBT = new JButton("Exit");
        exitDecisionLB = new JLabel(" ",JLabel.CENTER);
        explainTA = new JTextArea();

        Font exitFont = new Font("Courier",Font.BOLD,20);
        exitLB.setFont(exitFont);
        exitBT.setFont(exitFont);
        exitDecisionLB.setFont(exitFont);

        explainTA.setFont(new Font("Courier",Font.PLAIN,20));
        explainTA.setBackground(Color.pink);
        explainTA.setEditable(false);
        explainTA.setLineWrap(true);
        explainTA.setWrapStyleWord(true);

        middlePanel.add(exitBT);
        middlePanel.add(explainTA);

        // Exit the simulation
        exitBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        exitBT.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                exitDecisionLB.setText("Confirm to Exit?");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitDecisionLB.setText("Thank you for playing!");
            }
        });

        exitPanel.setLayout(new BorderLayout());
        exitPanel.add(exitLB,BorderLayout.NORTH);
        exitPanel.add(middlePanel,BorderLayout.CENTER);
        exitPanel.add(exitDecisionLB,BorderLayout.SOUTH);
        return exitPanel;
    }

    protected void paintComponent(Graphics g){
        g.setColor(new Color(245,235,244));
        g.fillRect(0,0,300,425);
    }
}
