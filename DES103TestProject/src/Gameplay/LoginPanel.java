package Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class LoginPanel extends JPanel {

    public static String panda_name = "Po";
    JTextField pet_nameTF = new JTextField(30);
    JButton random_nameBT = new JButton("Random");

    JLabel displaynameLB = new JLabel(" ",JLabel.CENTER);
    JLabel exitStatusLB = new JLabel(" ",JLabel.CENTER);

    CardLayout cl = new CardLayout();

    JPanel card = new JPanel(cl);
    JPanel namePanel = new JPanel();
    JPanel informationPanel = new JPanel();
    JPanel exitPanel = new JPanel();

    JButton nameBT = new JButton("Name");
    JButton informationBT = new JButton("Information");
    JButton exitBT = new JButton("Exit");
    JButton confirmBT = new JButton("Confirm");

    Timer backgroundTimer = new Timer(1000,new ControlBackgroundListener());
    Random r = new Random();

    public LoginPanel(){
        // Setting Up login panel
        this.setLayout(null);
        this.setBounds(0,0,900,600);

        // Setting Button to switch between Panel in Card
        nameBT.setBounds(325,490,100,50);
        nameBT.addActionListener(new ControlActionListener());
        this.add(nameBT);

        informationBT.setBounds(475,490,100,50);
        informationBT.addActionListener(new ControlActionListener());
        this.add(informationBT);

        exitBT.setBounds(625,490,100,50);
        exitBT.addActionListener(new ControlActionListener());
        this.add(exitBT);

        // Adding JPanel to different Card Panel (CardLayout)
        card.add(informationPanel,"information");
        card.add(namePanel,"name");
        card.add(exitPanel,"exit");
        card.setBounds(125,175,650,275);
        this.add(card);

        // Adding componenet to differenct JPanel located in the Card

        // Name Panel
        namePanel.setLayout(new GridLayout(3,1));
        namePanel.add(displaynameLB);
        namePanel.add(pet_nameTF);
        namePanel.add(random_nameBT);
        pet_nameTF.addActionListener(new PetNameListener());
        random_nameBT.addActionListener(new PetNameListener());

        Font petFont = new Font("Courier",Font.BOLD,25);
        displaynameLB.setFont(petFont);
        pet_nameTF.setFont(petFont);
        pet_nameTF.setText("Enter the Panda's name");
        pet_nameTF.setHorizontalAlignment(JTextField.CENTER);
        random_nameBT.setFont(petFont);

        // Information Panel
        JLabel informationLB = new JLabel("Information");
        informationLB.setFont(new Font("fantasy",Font.BOLD,25));
        informationLB.setBounds(260,5,200,50);
        JTextArea informationTA = instructionText();
        informationTA.setBounds(20,60,610,210);
        informationPanel.setLayout(null);
        informationPanel.add(informationLB);
        informationPanel.add(informationTA);

        // Exit Panel
        JLabel exitLB = new JLabel("Click the Confirm button to Exit the game",JLabel.CENTER);
        exitLB.setFont(new Font("Time New Roman",Font.BOLD,25));
        exitStatusLB.setBounds(350,350,200,100);
        exitStatusLB.setFont(new Font("Time New Roman",Font.BOLD,25));

        exitPanel.setLayout(new BorderLayout());
        exitPanel.add(exitLB,BorderLayout.NORTH);
        exitPanel.add(exitStatusLB,BorderLayout.SOUTH);
        exitPanel.add(confirmBT,BorderLayout.CENTER);

        confirmBT.setFont(new Font("fantasy",Font.BOLD,50));
        // Exit the program when press this confirmBT button
        confirmBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        confirmBT.addMouseListener(new mouseonExitBTListener());

        // Start the Timer for colorful background
        backgroundTimer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawColorfulBackground(g);

        // Border for the whole page
        g.setColor(new Color(214,247,173));
        g.fillRoundRect(25,25,850,525,150,150);

        // Welcome text
        g.setFont(new Font("Time New Roman",Font.BOLD,120));
        g.setColor(Color.black);
        g.drawString("Welcome!",165,130);

        // Border card
        g.setColor(new Color(138,173,94));
        g.fillRoundRect(100,150,700,325,50,50);

        // Border Buttons
        g.setColor(new Color(79,97,58));
        g.fillRoundRect(172,487,106,54,15,15);
        g.fillRoundRect(322,487,106,54,15,15);
        g.fillRoundRect(472,487,106,54,15,15);
        g.fillRoundRect(622,487,106,54,15,15);

        //drawGrid(g);

    }

    /*
     * Create the template of Information Card
     */
    private JTextArea instructionText(){
        String gameIntruction = "Welcome! This is a Life of a Panda simulation where" +
                " player will have various interaction with the panda." +
                " The simulation will run for eternity endless someless you did something horribly wrong!." +
                " (Hint: Feeding the Panda too much food?)" +
                " You can keep feeding your Panda as much as you wish, but be awared of the status of the panda before" +
                " proceding to the next action!" +
                " This will ensure that you can maintain the health and hunger level of your pet." +
                " There is no money system in the game!" +
                " You can do whatever you want!" +
                " To get start with the game, click the START button." +
                " You also have an option to name your panda by clicking the NAME button." +
                " You are unsure about how this simulation works, click the INFORMATION button (it is this page!)." +
                " Lastly, if you would like to exit the game, click the EXIT button and follow the prompt." +
                " Enjoy!";


        JTextArea instructionTA = new JTextArea();
        instructionTA.setEditable(false);
        instructionTA.setLineWrap(true);
        instructionTA.setWrapStyleWord(true);
        instructionTA.setText(gameIntruction);
        instructionTA.setFont(new Font("cursive",Font.PLAIN,15));

        return instructionTA;
    }

    /*
     * Method used in paintComponent to help draw random strips of random color
     */
    private void drawColorfulBackground(Graphics g){
        for(int i = 0; i < 900; i+= 25){
            g.setColor(new Color(r.nextInt(250),r.nextInt(250),r.nextInt(250)));
            g.fillRect(i,0,25,575);
        }
    }

    /*
     * Listen to ActionEvent fires from backgroundTimer and called the repaint();
     */
    class ControlBackgroundListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }
    }

    /*
     * Change the displayed Card of the
     */
    class ControlActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Name")){
                // Flipping to the component that was added with this specific name
                cl.show(card,"name");
            }
            if(e.getActionCommand().equals("Information")){

                cl.show(card,"information");
            }
            if(e.getActionCommand().equals("Exit")){

                cl.show(card,"exit");
            }
        }
    }

    /*
     * In Name Tab of the LoginPanel, users have an option to choose the name of the Panda
     *
     * If the user press Random (random_nameBT) button:
     * The program generates a three letter long name
     * Using Math.random() to generate random number between 65 and 90 (A - Z) and convert to
     * String value to be used as the first letter of the name
     * Middle String is a vowels.
     * Ending character use the same number generator process but from 97 to 122 (a - z) instead
     *
     * If the user enter a name in the JTextField and press entered:
     * The program assigns that String input as a name of the Panda
     */
    class PetNameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            // Random name for the Panda
            if(e.getSource() == random_nameBT){
                String[] vowel = {"a","e","i","o","u"};

                int first = (int) Math.floor(Math.random()*26+65);
                String firstChar = Character.toString((char) first);

                /*
                 * Math.random(): 0.00 - 0.9999
                 * Math.random() * 26: 0.00 - 25.9999
                 * Math.random() * 26 + 97: 97.000 - 122.9999
                 * Math.floor(Math.random() * 26 + 97): 97 - 122
                 */
                int second = (int) Math.floor(Math.random()*26+97);
                String endChar = Character.toString((char) second);

                panda_name = firstChar + vowel[(int)(Math.random()*5)] + endChar;
            }

            // Set Panda name according to the user input
            if(e.getSource() == pet_nameTF){
                panda_name = pet_nameTF.getText();
            }
            displaynameLB.setText("Your pet's name is "+ panda_name + "!");

        }
    }

    /*
     * Change the text of a label when hover the mouse cursor inside the exi button
     * and change the text again when mouse exit the boundary of the exit button
     */
    class mouseonExitBTListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        // When mouse hover over the Confirm Button...
        @Override
        public void mouseEntered(MouseEvent e) {
            exitStatusLB.setText("Please don't leave!");
        }

        // When mouse leaves the Confirm Button...
        @Override
        public void mouseExited(MouseEvent e) {
            exitStatusLB.setText("Back to the game?");
        }
    }

}
