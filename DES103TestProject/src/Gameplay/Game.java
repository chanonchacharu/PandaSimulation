package Gameplay;

import GameComponent.Background;
import GameComponent.FunPanel;
import GameComponent.PandaPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame frame;
    JButton startBT;

    LoginPanel loginPanel;

    JPanel interactivePanel;
    JPanel pandastatusPanel;

    /*
     * graphicsDrawnPanel will be created as FunPanel object in the createGameScreen() method
     * However, it refers to as JPanel (FunPanel extends JPanel)
     *
     * Explicit casting: JPanel graphicsDrawPanel = new FunPanel();
     */
    static JPanel graphicsDrawnPanel;

    static Timer timeofdayTimer = new Timer(1000, new DayandNightHandler());
    static int timeTracker = 1;


    public Game(){
        frame = new JFrame("Panda Simulation");
        frame.setSize(900,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false); // cannot resize the JFrame
        frame.setVisible(true);

        loginPanel = new LoginPanel();

        frame.add(loginPanel);

        // Create Button to start game
        startBT = new JButton("Start");
        startBT.setBounds(175,490,100,50);
        startBT.addActionListener(new TitleScreenHandler());

        // Add button to the login panel
        loginPanel.add(startBT);
    }

    /*
     * createGameScreen():
     * create the simulation screen after pressing start button in the
     * login interface of type LoginPanel
     *
     */
    public void createGameScreen(){

        // LoginPanel is no longer visible in the frame
        loginPanel.setVisible(false);

        // Panda status panel
        pandastatusPanel = new PandaStatusPanel();
        pandastatusPanel.setBounds(600,0,300,425);

        // Interactive Panel
        interactivePanel = new InteractivePanel();
        interactivePanel.setBounds(0,425,900,150);

        // Graphics Panel
        graphicsDrawnPanel = new FunPanel();
        graphicsDrawnPanel.setLayout(null);
        graphicsDrawnPanel.setBounds(0,0,600,425);

        frame.add(graphicsDrawnPanel);
        frame.add(interactivePanel);
        frame.add(pandastatusPanel);

        timeofdayTimer.start();

    }

    /*
     * TitleScreenHandler: inner class nested in Game class, implemented ActionListener interface
     * A listener to change the screen from login interface to the simulation
     * when the user press start button
     *
     * startBT register this as its ActionListener
     */
    class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            // Stop the timer for changing background
            loginPanel.backgroundTimer.stop();
            createGameScreen();
        }
    }

    /*
     * DayandNightHandler: inner class nested in Game class, implemented ActionListener interface
     * Repaint the graphics depending on time of the day
     *
     * Listen to timeofdayTimer ActionEvent
     */
    static class DayandNightHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            /*
             * Every 15 second, the program will called the repaint
             * to redraw the graphics which alternate between day and night time
             */
            if(timeTracker%15 == 0){
                if(Background.timeofday == "daytime"){
                    // Assign new value to variable to change what to be drawn
                    Background.timeofday = "night";
                    Background.backgroundType = "cave";
                    PandaPanel.emotion = "sleeping";
                    FunPanel.foodtype = "";

                    // Change the display text on the Status Panel
                    PandaStatusPanel.currentActivityTA.setText("It is night time. " +
                            LoginPanel.panda_name + " is currently sleeping.");
                    PandaStatusPanel.suggestionTA.setText("Suggestion: All the tabs other than Sleeping has been disabled," +
                            " so that " + LoginPanel.panda_name + " can get enough sleep. Wait until daytime to have fun again!");
                    PandaStatusPanel.feedingamountLB.setText(" ");

                    // Reset the food eatten by the Panda
                    InteractivePanel.foodbuttonPressCount = 0;

                    // Unable to change tab from Sleeping during night time
                    InteractivePanel.tp.setEnabledAt(0,false);
                    InteractivePanel.tp.setEnabledAt(1,false);
                    InteractivePanel.tp.setEnabledAt(2,true);
                    InteractivePanel.tp.setEnabledAt(3,false);
                    InteractivePanel.tp.setSelectedIndex(2);


                }else if(Background.timeofday == "night"){
                    Background.timeofday = "daytime";
                    PandaPanel.emotion = "smile";
                    FunPanel.foodtype = "";

                    // Indicate what background to be drawn
                    if(InteractivePanel.castleRB.isSelected()){
                        Background.backgroundType = "castle";
                    }else{
                        Background.backgroundType = "moutain";
                    }

                    PandaStatusPanel.currentActivityTA.setText("It is already Morning! Lets have some fun!");
                    PandaStatusPanel.suggestionTA.setText("Suggestion: The Sleeping tab has been disabled. " +
                            " Press and other tabs to do some activities!");

                    // Enable other tab  (for user interactive) and disable Sleeping tab
                    InteractivePanel.tp.setEnabledAt(0,true);
                    InteractivePanel.tp.setEnabledAt(1,true);
                    InteractivePanel.tp.setEnabledAt(2,false);
                    InteractivePanel.tp.setEnabledAt(3,true);

                    // Show the first index of tp - Feeding Tab
                    InteractivePanel.tp.setSelectedIndex(0);

                    // To make sure that the CheckBoxes are deselected
                    InteractivePanel.hatCB.setSelected(false);
                    InteractivePanel.pillowCB.setSelected(false);
                    InteractivePanel.blanketCB.setSelected(false);
                    InteractivePanel.eyepadCB.setSelected(false);

                    PandaStatusPanel.feedingamountLB.setText("Food eatten:" + InteractivePanel.foodbuttonPressCount);
                }
            }

            /*
             * Control the direction of the Panda not to go out of the frame
             * skateForward indicates which direction should the panda be skating toward
             */
            if(PandaPanel.xPos > 400){
                PandaPanel.skateForward = false;
            }else if(PandaPanel.xPos < 0){
                PandaPanel.skateForward = true;
            }

            /*
             * Increment timeTracker by one
             * Calling the repaint of graphicsDrawnPanel to redraw the graphics
             */
            timeTracker += 1;
            Game.graphicsDrawnPanel.repaint();

        }
    }

    public static void main(String[] args){
        new Game();
    }
}
