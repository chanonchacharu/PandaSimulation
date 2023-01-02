package Gameplay;

import GameComponent.Background;
import GameComponent.FunPanel;
import GameComponent.PandaPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InteractivePanel extends JPanel {

    static JRadioButton moutainRB, castleRB;

    JButton bambooBT, fishBT, bobaBT, returnBT, clubbingBT,skatingBT;

    static JTabbedPane tp;

    static int foodbuttonPressCount = 0;

    static JCheckBox hatCB, eyepadCB, pillowCB, blanketCB;

    /*
     * InteractivePanel:
     * This is the panel that allows user to interact with the program
     * It contains tabs (Feeding, Background, Sleeping, and Activity)
     *
     */
    public InteractivePanel(){
        // Free Style the layout of the JPanel
        this.setLayout(null);

        // Set the preferred size of the JPanel (width: 800, height: 150)
        this.setPreferredSize(new Dimension(800,150));

        tp = new JTabbedPane();
        JPanel p1 = selectFeeding();
        JPanel p2 = selectBackground();
        JPanel p3 = selectSleeping();
        JPanel p4 = selectActivity();

        // Assign location of the tab to the top of the panel
        tp.setTabPlacement(JTabbedPane.TOP);
        tp.setFont(new Font("Courier",Font.PLAIN,20));
        tp.setBackground(getBackground());
        tp.setForeground(Color.black);

        p1.setBackground(new Color(178,242,99));
        p2.setBackground(new Color(202,242,153));
        p3.setBackground(new Color(130,180,196));
        p4.setBackground(Color.pink);

        // Occupying the whole panel
        tp.setBounds(0,0,900,150);
        tp.addTab("Feeding",p1);
        tp.addTab("Background",p2);
        tp.addTab("Sleeping",p3);
        tp.add("Activity",p4);

        tp.setEnabledAt(2,false);

        /*
         * Registered JTabbedPane to a ChangeListener
         * JTabbedPane fires ChangeEvent when alternating between different tabs
         * When changing the tab, redraw the graphics
         */
        tp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Dealing with background
                if(Background.timeofday == "night"){
                    Background.backgroundType = "cave";
                }else if(castleRB.isSelected() == true){
                    Background.backgroundType = "castle";
                }else{
                    Background.backgroundType = "moutain";
                }

                if(tp.getSelectedIndex() == 0){
                    // Feeding
                    PandaPanel.emotion = "smile";
                    FunPanel.foodtype = " ";
                }
                if(tp.getSelectedIndex() == 1){
                    // Background
                    PandaPanel.emotion = "smile";
                    FunPanel.foodtype = " ";
                }
                Game.graphicsDrawnPanel.repaint();
            }
        });

        this.add(tp);

    }

    /*
     * Create a template of the Feeding Tab in the simulation
     */
    private JPanel selectFeeding(){
        JPanel feedingPanel = new JPanel();
        bobaBT = new JButton("Boba Milk Tea");
        fishBT = new JButton("Fish");
        bambooBT = new JButton("Bamboo");
        returnBT = new JButton("Stop Feeding");

        Font foodBTFont = new Font("Courier",Font.PLAIN,15);
        bobaBT.setFont(foodBTFont);
        fishBT.setFont(foodBTFont);
        bambooBT.setFont(foodBTFont);
        returnBT.setFont(foodBTFont);

        feedingPanel.setLayout(new GridLayout(1,4));
        feedingPanel.add(fishBT);
        feedingPanel.add(bobaBT);
        feedingPanel.add(bambooBT);
        feedingPanel.add(returnBT);

        bobaBT.addActionListener(new FoodOptionListener());
        fishBT.addActionListener(new FoodOptionListener());
        bambooBT.addActionListener(new FoodOptionListener());
        returnBT.addActionListener(new FoodOptionListener());

        return feedingPanel;
    }

    /*
     * Create the template of the Sleeping Tab in the simulation
     */
    private JPanel selectSleeping(){
        JPanel sleepingPanel = new JPanel();
        hatCB = new JCheckBox("Sleeping Hat");
        eyepadCB = new JCheckBox("Eye pad");
        blanketCB = new JCheckBox("Blanket");
        pillowCB = new JCheckBox("Pillow");

        Font accessFont = new Font("Courier",Font.PLAIN,15);
        hatCB.setFont(accessFont);
        eyepadCB.setFont(accessFont);
        blanketCB.setFont(accessFont);
        pillowCB.setFont(accessFont);

        hatCB.setHorizontalAlignment(JLabel.CENTER);
        eyepadCB.setHorizontalAlignment(JLabel.CENTER);
        blanketCB.setHorizontalAlignment(JLabel.CENTER);
        pillowCB.setHorizontalAlignment(JLabel.CENTER);

        hatCB.addItemListener(new SleepingAccessoriesListener());
        eyepadCB.addItemListener(new SleepingAccessoriesListener());
        blanketCB.addItemListener(new SleepingAccessoriesListener());
        pillowCB.addItemListener(new SleepingAccessoriesListener());

        sleepingPanel.setLayout(new GridLayout(2,2));
        sleepingPanel.add(hatCB);
        sleepingPanel.add(eyepadCB);
        sleepingPanel.add(blanketCB);
        sleepingPanel.add(pillowCB);

        return sleepingPanel;
    }

    /*
     * Create the template of Background Tab in the simulation
     */
    private JPanel selectBackground(){
        JPanel backgroundPanel = new JPanel();
        JLabel backgroundinstructionLB = new JLabel("Check the box to choose the background",JLabel.CENTER);
        moutainRB = new JRadioButton("Surrounded by Moutains");
        castleRB = new JRadioButton("Ginormous Luxurious Castle");

        moutainRB.setSelected(true);

        moutainRB.setHorizontalAlignment(JLabel.CENTER);
        castleRB.setHorizontalAlignment(JLabel.CENTER);

        backgroundinstructionLB.setFont(new Font("Courier",Font.PLAIN,20));
        moutainRB.setFont(new Font("Courier",Font.PLAIN,15));
        castleRB.setFont(new Font("Courier",Font.PLAIN,15));

        // Add Listener the background control buttons
        moutainRB.addItemListener(new BackgroundChangeListener());
        castleRB.addItemListener(new BackgroundChangeListener());

        //moutainRB.setSelected(true);

        backgroundPanel.setLayout(new GridLayout(3,1));
        backgroundPanel.add(backgroundinstructionLB);
        backgroundPanel.add(moutainRB);
        backgroundPanel.add(castleRB);
        return backgroundPanel;
    }

    /*
     * Create the template of Activity Tab in the simulation
     */
    private JPanel selectActivity(){
        JPanel activityPanel = new JPanel();
        clubbingBT = new JButton("Dancing");
        skatingBT = new JButton("Skating");

        Font actBTFont = new Font("Courier",Font.PLAIN,15);
        clubbingBT.setFont(actBTFont);
        skatingBT.setFont(actBTFont);

        activityPanel.setLayout(new GridLayout(1,3));

        activityPanel.add(clubbingBT);
        activityPanel.add(skatingBT);

        clubbingBT.addActionListener(new ActivityOptionListener());
        skatingBT.addActionListener(new ActivityOptionListener());
        return activityPanel;
    }

    /*
     * endGameMananger() method handle the interaction after the timer gets stop
     */
    public void endGameManager(){
        fishBT.setEnabled(false);
        bobaBT.setEnabled(false);
        bambooBT.setEnabled(false);
        returnBT.setEnabled(false);
        PandaStatusPanel.explainTA.setText("The simulation has ended. Either you feed the panda too much food OR you " +
                "have taken away too much food!");
        // Unable all the tab (Feeding, Background, Sleeping, Activity)
        for(int i = 0; i < 4; i++){
            InteractivePanel.tp.setEnabledAt(i,false);
        }
        // Set JTabedPane tp of class PandaStatusPanel to index 1 (Exit) and unable tab at index 0 (status)
        PandaStatusPanel.tp.setEnabledAt(0,false);
        PandaStatusPanel.tp.setSelectedIndex(1);
    }

    /*
     * BackgroundChangeListener: inner class nested in InteractivePanel, implements ItemListener
     * Change the background of the graphics depending on what
     * JRadioButton users selected in the Background tab
     */
    class BackgroundChangeListener implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            if(e.getSource() == moutainRB){
                castleRB.setSelected(false);
                Background.backgroundType = "moutain";
                PandaPanel.emotion = "chilling";
                Game.graphicsDrawnPanel.repaint();
            }
            if(e.getSource() == castleRB){
                moutainRB.setSelected(false);
                Background.backgroundType = "castle";
                PandaPanel.emotion = "chilling";
                Game.graphicsDrawnPanel.repaint();
            }

        }
    }

    /*
     * FoodOptionListener: inner class nested in InteractivePanel, implemented ActionListener
     * Set the conditions to what to be drawn in the graphics depending
     * on what Food option buttons user pressed.
     */
    class FoodOptionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == fishBT){
                FunPanel.foodtype = "Fish";
                PandaPanel.emotion = "chilling";
                foodbuttonPressCount++;
                PandaStatusPanel.currentActivityTA.setText(LoginPanel.panda_name + " is eatting fish! Yum yum!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Try feeding " + LoginPanel.panda_name + " something else other than fish!");
            }
            if(e.getSource() == bobaBT){
                FunPanel.foodtype = "Boba";
                PandaPanel.emotion = "chilling";
                foodbuttonPressCount++;
                PandaStatusPanel.currentActivityTA.setText(LoginPanel.panda_name + " is drinking Boba Milk Tea!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Try feeding " + LoginPanel.panda_name + " something else other than Boba Milk Tea!");
            }
            if(e.getSource() == bambooBT){
                FunPanel.foodtype = "Bamboo";
                PandaPanel.emotion = "chilling";
                PandaStatusPanel.currentActivityTA.setText(LoginPanel.panda_name + " is eatting its favorite Bamboo!!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Try feeding " + LoginPanel.panda_name + " something else other than Bamboo!");
                foodbuttonPressCount++;
            }
            if(e.getSource() == returnBT){
                FunPanel.foodtype = " ";
                PandaPanel.emotion = "sad";
                PandaStatusPanel.currentActivityTA.setText("You are taking away " + LoginPanel.panda_name + "'s food! " + LoginPanel.panda_name + " is getting really sad!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Press any of the food button to feed your panda but " +
                        "dont let the number of Food eatten reaches 15!");
                foodbuttonPressCount--;
            }

            pandaRespond();
            Game.graphicsDrawnPanel.repaint();
        }

        private void pandaRespond(){

            if(foodbuttonPressCount == 30 || foodbuttonPressCount == -10){
                FunPanel.foodtype = " ";
                PandaPanel.emotion = "death";
                Background.backgroundType = "heaven";
                Game.timeofdayTimer.stop();
                endGameManager();
            } else if(foodbuttonPressCount >= 15){
                FunPanel.foodtype = "Poison";
                PandaPanel.emotion = "sick";
                PandaStatusPanel.currentActivityTA.setText("You have " +
                        "been feeding " + LoginPanel.panda_name + " too much food." +
                        " It gets food poisoning!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: All Tabs other than Feeding has been disabled. Press the Stop Feeding button to take away the food OR " +
                        " wait until night time where " + LoginPanel.panda_name + " can rest and digest the food!");
                InteractivePanel.tp.setEnabledAt(1,false);
                InteractivePanel.tp.setEnabledAt(3,false);
            } else if(foodbuttonPressCount == 0){
                PandaStatusPanel.feedingamountLB.setText("Feed your panda!");
                PandaStatusPanel.currentActivityTA.setText(LoginPanel.panda_name + " currently has zero food in its' stomach!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Press any of the food button to feed " + LoginPanel.panda_name);
                // Return to the current background after drawing the angry background
                if(castleRB.isSelected()){
                    Background.backgroundType = "castle";
                }else{
                    Background.backgroundType = "moutain";
                }
            }else if(foodbuttonPressCount < 0){
                PandaStatusPanel.feedingamountLB.setText("Stop taking the food!");
                PandaStatusPanel.currentActivityTA.setText("You have been taking away" +
                        " too much of "+LoginPanel.panda_name + "'s food. Start giving food immediately!" +
                        " Otherwise, the world might get nuke!");
                PandaStatusPanel.suggestionTA.setText("Suggestion: All Tabs other than Feeding has been disabled. Press any of the food button to start feeding your panda" +
                        "(bring the Food eatten number to at least 0)" +
                        " OR wait until night time where it will calm down!");
                PandaPanel.emotion = "angry";
                FunPanel.foodtype = "Bomb";
                Background.backgroundType = "warning";
                InteractivePanel.tp.setEnabledAt(1,false);
                InteractivePanel.tp.setEnabledAt(3,false);
            }

            if (foodbuttonPressCount < 15 && foodbuttonPressCount >= 0){
                InteractivePanel.tp.setEnabledAt(1,true);
                InteractivePanel.tp.setEnabledAt(3,true);
            }

            PandaStatusPanel.feedingamountLB.setText("Food eatten: " + foodbuttonPressCount);
        }
    }

    /*
     * ActivityOptionListener: inner class nested in InteractivePanel, implemented ActionListener
     * Set the conditions on what to be drawn in the graphics depending
     * on what Activity buttons user pressed
     */
    class ActivityOptionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == clubbingBT){
                PandaPanel.emotion = "dance"; // change later
                Background.backgroundType = "club";
                FunPanel.foodtype = "";
                PandaStatusPanel.currentActivityTA.setText(LoginPanel.panda_name + " is dancing");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Change tab and press another button to have new interaction with " + LoginPanel.panda_name);
            }
            if(e.getSource() == skatingBT){
                PandaPanel.emotion = "skate";
                Background.backgroundType = "moutain"; // change later
                FunPanel.foodtype = "";
                PandaStatusPanel.currentActivityTA.setText(LoginPanel.panda_name + " is skating");
                PandaStatusPanel.suggestionTA.setText("Suggestion: Change tab and press another button to have new interaction with " + LoginPanel.panda_name);
            }
            Game.graphicsDrawnPanel.repaint();
        }
    }

    /*
     * SleepingAccessoriesListener: inner class nested in InteractivePanel, implemented ItemListener
     * Set the conditions on what accessories graphics should be drawn
     * during the night time
     */
    class SleepingAccessoriesListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if(hatCB.isSelected()){
                FunPanel.hat = true;
            }else{
                FunPanel.hat = false;
            }

            if(eyepadCB.isSelected()){
                FunPanel.eyepad = true;
            }else{
                FunPanel.eyepad = false;
            }

            if(blanketCB.isSelected()){
                FunPanel.blanket = true;
            }else{
                FunPanel.blanket = false;
            }

            if(pillowCB.isSelected()){
                FunPanel.pillow = true;
            }else{
                FunPanel.pillow = false;
            }

            Game.graphicsDrawnPanel.repaint();

        }
    }

}
