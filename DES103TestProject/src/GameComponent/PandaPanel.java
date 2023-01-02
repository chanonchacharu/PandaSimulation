package GameComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PandaPanel extends JPanel {

    public static String emotion = "smile";
    int pandaDancePosition = 1, skatePosition = 1;
    public static boolean skateForward = true;
    Random random = new Random();

    public static int xPos = 100, yPos = 160;

    protected int yFace = 200;
    protected int yDiff = 65;
    protected int yBody = yFace + yDiff;

    public PandaPanel(){
        this.setLayout(null);
        this.setBounds(0,0,600,425);
        this.setPreferredSize(new Dimension(600,425));
    }

    protected void paintComponent(Graphics g){
        // PaintComponent of super class - JPanel
        super.paintComponent(g);
        // Draw Background
        Background.drawBackground(g);

        // To make drawing depending on the value of the emotion variable
        switch(emotion){
            case "smile":
                drawSmilePanda(g);
                break;
            case "sad":
                drawSadPanda(g);
                break;
            case "chilling":
                drawChillingPanda(g);
                break;
            case "death":
                drawDeathPanda(g);
                break;
            case "sick":
                drawSickPanda(g);
                break;
            case "confuse":
                drawConfusePanda(g);
                break;
            case "sleeping":
                drawSleepingPanda(g);
                break;
            case "angry":
                drawRagingPanda(g);
                break;
            case "dance":
                drawDancingPanda(g);
                drawDancingPandaKrunk(g);
                break;
            case "skate":
                drawSkate(g);
                break;
        }
        //drawGrid(g);
    }

    /*
     * drwGrid method is used during the drawing process
     * It draw a line horizontally and vertically across the frame with string label
     *
     * Set as protected so that subclass and use this method to help draw the graphics
     */
    protected static void drawGrid(Graphics g){
        g.setFont(new Font("Arial",Font.PLAIN,12));
        g.setColor(Color.lightGray);
        for(int i = 0; i < 600; i = i + 25){
            g.drawLine(i,0,i,450);
            g.drawString(""+i,i,10);
        }

        for(int j = 0; j < 450; j = j + 25){
            g.drawLine(0,j,600,j);
            g.drawString(""+j,0,j);
        }
    }

    /*
     * drawXXX(Graphics g) methods:
     * They are used in paintComponent to help draw different graphics
     * depending on the assigned String value of variable emotion
     */
    private void drawPandaBody(Graphics g){
        // Black body
        g.setColor(Color.black);
        g.fillOval(115,yBody,120,145);

        // White body
        g.setColor(Color.white);
        g.fillOval(115,yBody+65,120,80);

        //Arm
        g.setColor(Color.black);
        g.fillOval(105,yBody+40,50,48);
        g.fillOval(195,yBody+40,50,48);

        // Leg
        g.fillOval(105,yBody+90,50,55); // Left
        g.fillOval(195,yBody+90,50,55); // Right
        // Left leg stamp
        g.setColor(new Color(222,184,135));
        g.fillOval(113,yBody+110,35,30);
        g.fillOval(110,yBody+103,10,10);
        g.fillOval(125,yBody+98,10,10);
        g.fillOval(140,yBody+103,10,10);
        // Right leg stamp
        g.fillOval(203,yBody+110,35,30);
        g.fillOval(200,yBody+103,10,10);
        g.fillOval(215,yBody+98,10,10);
        g.fillOval(230,yBody+103,10,10);
    }

    private void drawBasicPanda(Graphics g){
        // Ears
        g.setColor(Color.black);
        g.fillOval(100,yFace-10,50,50);
        g.fillOval(200,yFace-10,50,50);

        // Face
        g.setColor(Color.white);
        g.fillOval(100,yFace,150,125);

        // Black-Eyes
        g.setColor(Color.black);
        g.fillOval(125,yFace+45,30,35);
        g.fillOval(195,yFace+45,30,35);

        // Nose
        g.setColor(Color.black);
        g.fillOval(160,yFace+80,30,20);
    }

    private void drawSmilePanda(Graphics g){
        drawPandaBody(g);
        drawBasicPanda(g);

        // White-Eyes
        g.setColor(Color.white);
        g.fillOval(135,yFace+50,10,12);
        g.fillOval(205,yFace+50,10,12);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(120,yFace+85,25,10);
        g.fillOval(205,yFace+85,25,10);

        // Mouth - Smile
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawArc(163,yFace+97,25,15,180,180);

        // Reset Thickness
        g2.setStroke(new BasicStroke(1));
    }

    private void drawSadPanda(Graphics g){
        Background.drawBackground(g);
        drawPandaBody(g);
        drawBasicPanda(g);

        // White-Eyes
        g.setColor(Color.white);
        g.fillOval(135,yFace+50,10,12);
        g.fillOval(205,yFace+50,10,12);

        // Tear
        g.setColor(Color.blue);
        g.fillOval(135,yFace+80,12,14);

        // Mouth - Sad
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawArc(163,yFace+100,25,15,0,180);

        // Add Eyes brows?

        // Reset Thickness
        g2.setStroke(new BasicStroke(1));
    }

    private void drawChillingPanda(Graphics g){
        Background.drawBackground(g);
        drawPandaBody(g);
        drawBasicPanda(g);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(120,yFace+85,25,10);
        g.fillOval(205,yFace+85,25,10);

        // Mouth
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        g2.fillArc(163,yFace+97,25,15,180,180);

        g2.setColor(Color.red);
        g2.fillArc(164,yFace+110,20,10,30,100);

        // White-eye
        g.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(135,yFace+55,148,yFace+65);
        g2.drawLine(135,yFace+70,148,yFace+65);

        g2.drawLine(200,yFace+65,213,yFace+55);
        g2.drawLine(200,yFace+65,213,yFace+70);
        g2.setStroke(new BasicStroke(1));
    }

    private void drawDeathPanda(Graphics g){

        Background.drawBackground(g);
        drawPandaBody(g);
        drawBasicPanda(g);

        // Angle Ring
        g.setColor(Color.yellow);
        g.fillOval(125,yFace-35,100,25);
        g.setColor(getBackground());
        g.fillOval(130,yFace-30,90,15);

        g.setColor(Color.orange);
        g.drawOval(125,yFace-35,100,25);
        g.drawOval(130,yFace-30,90,15);

        // White-eyes
        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(135,yFace+60,145,yFace+70);
        g2.drawLine(135,yFace+70,145,yFace+60);

        g2.drawLine(205,yFace+60,215,yFace+70);
        g2.drawLine(205,yFace+70,215,yFace+60);

        // Mouth
        g.setColor(Color.red);
        g2.fillRect(170,yFace+107,10,10);
        g2.fillArc(170,yFace+110,10,10,180,180);
        g.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(165,yFace+105,185,yFace+105);
        g2.drawLine(175,yFace+107,175,yFace+110);

        // Reset graphics
        g2.setStroke(new BasicStroke(1));
    }

    private void drawSickPanda(Graphics g){
        Background.drawBackground(g);
        drawPandaBody(g);
        drawBasicPanda(g);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(120,yFace+85,25,10);
        g.fillOval(205,yFace+85,25,10);

        // Eyes
        g.setColor(Color.white);
        g.fillOval(133,yFace+50,20,20);
        g.fillOval(197,yFace+50,20,20);

        // Mouth - rainbow coming out
        for(int j = 155; j < 195; j += 8){
            g.setColor(new Color(random.nextInt(225),random.nextInt(225),random.nextInt(225)));
            g.fillRect(j,yFace+105,8,random.nextInt(30)+15);
        }

        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(155,yFace+105,195,yFace+105);

        // Rest stroke thickness
        g2.setStroke(new BasicStroke(1));
    }

    private void drawConfusePanda(Graphics g){
        Background.drawBackground(g);
        drawPandaBody(g);
        drawBasicPanda(g);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(120,yFace+85,25,10);
        g.fillOval(205,yFace+85,25,10);

        // Draw question marks
        g.setColor(Color.pink);
        g.setFont(new Font("fantasy",Font.BOLD,25));
        g.drawString("?",135,yFace+70);
        g.drawString("?",205,yFace+70);

        // Mouth
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        g2.fillArc(163,yFace+97,25,15,180,180);

        g2.setColor(Color.red);
        g2.fillArc(164,yFace+110,20,10,30,100);
    }

    private void drawSleepingPanda(Graphics g){

        int yFace2 = 250;

        // Legs 3
        g.setColor(Color.black);
        g.fillOval(100,350,80,30);

        // Tail
        g.setColor(Color.white);
        g.fillOval(290,275,30,30);

        // Body
        g.fillOval(200,yFace2+30,130,95);
        g.setColor(Color.black);
        g.fillOval(200,yFace2+30,80,95);

        // Ears
        g.setColor(Color.black);
        g.fillOval(100,yFace2-10,50,50);
        g.fillOval(200,yFace2-10,50,50);

        // Face
        g.setColor(Color.white);
        g.fillOval(100,yFace2,150,125);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(120-12,yFace2+85,20,10);
        g.fillOval(205-25,yFace2+85,20,10);

        // Black-Eyes
        g.setColor(Color.black);
        g.fillOval(125-20,yFace2+45,30,35);
        g.fillOval(195-20,yFace2+45,30,35);

        // Nose
        g.setColor(Color.black);
        g.fillOval(160-25,yFace2+80,30,20);


        // Leg front and back
        g.fillOval(180,350,80,30);
        g.fillOval(280,350,60,30);

        // Mouth
        g.fillOval(160-20,yFace2+105,20,10);
        g.setColor(Color.red);
        g.fillOval(160-16,yFace2+109,12,5);

        // White-eyes
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.white);
        g2.drawArc(125-15,yFace2+55,18,20,180,180);
        g2.drawArc(195-15,yFace2+55,18,20,180,180);

        g2.setStroke(new BasicStroke(1));
    }

    private void drawRagingPanda(Graphics g){
        // Black body
        g.setColor(Color.black);
        g.fillOval(115,yBody,120,145);

        // White body
        g.setColor(Color.white);
        g.fillOval(115,yBody+65,120,80);

        // Leg
        g.setColor(Color.black);
        g.fillOval(105,yBody+90,50,55); // Left
        g.fillOval(195,yBody+90,50,55); // Right

        // Left leg stamp
        g.setColor(new Color(222,184,135));
        g.fillOval(113,yBody+110,35,30);
        g.fillOval(110,yBody+103,10,10);
        g.fillOval(125,yBody+98,10,10);
        g.fillOval(140,yBody+103,10,10);
        // Right leg stamp
        g.fillOval(203,yBody+110,35,30);
        g.fillOval(200,yBody+103,10,10);
        g.fillOval(215,yBody+98,10,10);
        g.fillOval(230,yBody+103,10,10);

        g.setColor(Color.black);
        g.fillOval(200,300,78,38);
        g.fillOval(75,300,78,38);

        // Ears
        g.setColor(Color.black);
        g.fillOval(100,yFace-10,50,50);
        g.fillOval(200,yFace-10,50,50);

        // Face
        g.setColor(Color.red);
        g.fillOval(100,yFace,150,125);

        // Black-Eyes
        g.setColor(Color.black);
        g.fillOval(125,yFace+45,30,35);
        g.fillOval(195,yFace+45,30,35);

        // Nose
        g.setColor(Color.black);
        g.fillOval(160,yFace+80,30,20);

        // White-eyes
        g.setColor(Color.white);
        g.fillArc(130,250,25,25,135,180);
        g.fillArc(195,250,25,25,225,180);

        // Mouth
        g.setColor(Color.black);
        g.fillRoundRect(150,305,50,15,10,10);
        g.setColor(Color.white);
        g.fillRoundRect(155,307,40,10,10,10);
    }

    private void drawDancingPanda(Graphics g){
        int yFace2 = 150;

        // Leg
        g.setColor(Color.black);
        g.fillRoundRect(125,300,35,92,10,10);
        g.fillRoundRect(190,300,35,92,10,10);

        // Feet
        g.fillOval(105,370,55,30);
        g.fillOval(190,370,55,30);

        // Body Black
        g.setColor(Color.black);
        g.fillRoundRect(115,220,120,145,100,100);

        // Arm
        if(pandaDancePosition%2 == 0){
            // Dance move
            g.setColor(Color.black);
            g.fillRoundRect(75,250,100,40,50,30);
            g.fillRoundRect(200,250,72,40,50,30);
            // White Body
            g.setColor(Color.white);
            g.fillRoundRect(115,285,120,80,80,80);
            pandaDancePosition++;
        }else if(pandaDancePosition%2 == 1){
            // White body
            g.setColor(Color.white);
            g.fillRoundRect(115,285,120,80,80,80);
            // Dance move
            g.setColor(Color.black);
            g.fillRect(120,280,115,15);
            g.fillOval(140,280,50,40);
            g.fillOval(160,280,50,40);
            pandaDancePosition++;
        }


        // Ears
        g.setColor(Color.black);
        g.fillOval(100,yFace2-10,50,50);
        g.fillOval(200,yFace2-10,50,50);

        // Face
        g.setColor(Color.white);
        g.fillOval(100,yFace2,150,125);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(120,yFace2+85,20,10);
        g.fillOval(205,yFace2+85,20,10);

        // Black-Eyes
        g.setColor(Color.black);
        g.fillOval(125,yFace2+45,30,35);
        g.fillOval(195,yFace2+45,30,35);

        // Nose
        g.setColor(Color.black);
        g.fillOval(160,yFace2+80,30,20);

        // Glass
        g.fillRoundRect(95,185,70,50,30,60);
        g.fillRoundRect(187,185,70,50,30,60);
        g.fillRoundRect(150,195,100,15,0,0);
        g.setColor(new Color(223,245,229));
        int[] x = {200,230,245,205};
        int[] x2 = {105,135,150,110};
        int[] y = {235,185,185,235};
        g.fillPolygon(x2,y,4);
        g.fillPolygon(x,y,4);

        // Mouth
        g.setColor(Color.black);
        if(pandaDancePosition%2 == 1){
            g.fillArc(162,240,25,30,180,180);
            g.setColor(Color.red);
            g.fillOval(166,260,18,10);
        }else if(pandaDancePosition%2 == 0){
            g.setColor(Color.black);
            g.fillRoundRect(162,255,25,5,10,10);
        }


    }

    private void drawDancingPandaKrunk(Graphics g){
        // Draw Other Bear - Krunk BlackPink!
        // Body
        g.setColor(Color.black);
        g.fillOval(410,200,20,15);
        g.fillRoundRect(368,220,110,140,90,90);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("fantasy",Font.BOLD,20));

        // First dance move
        if(pandaDancePosition%2 == 1){
            // Arm
            g.setColor(Color.black);
            g.fillRoundRect(330,235,100,40,50,30);
            g.fillRoundRect(410,235,100,40,50,30);
            // Fist
            g.setColor(new Color(137,216, 232));
            g.fillOval(315,235,50,40);
            g.fillOval(475,235,50,40);
            g.setColor(Color.pink);
            g2.drawString("BlackPink",375,270);
//            dancingPosition++;
        }else if(pandaDancePosition%2 == 0){
            // Second dance move
            // Arm
            g.setColor(Color.black);
            g.fillRoundRect(370,235,50,60,30,50);
            g.fillRoundRect(425,235,50,60,30,50);
            // Fist
            g.setColor(new Color(137,216,232));
            g.fillOval(408,275,50,40);
            g.fillOval(390,275,50,40);
//            dancingPosition++;
        }


        // Leg
        g.setColor(new Color(166,85,237));
        int[] x = {368,478,483,450,425,396,363};
        int[] y = {320,320,400,400,360,400,400};
        g.fillPolygon(x,y,7);
        // Feet
        g.setColor(new Color(137,216,232));
        g.fillOval(345,385,60,30);
        g.fillOval(445,385,60,30);

        // Ears
        g.fillOval(340,110,50,50);
        g.fillOval(450,110,50,50);
        // Innner ear
        g.setColor(new Color(97,207,237));
        g.fillOval(350,120,40,40);
        g.fillOval(450,120,40,40);

        // Face
        g.setColor(new Color(137,216,232));
        g.fillOval(350,115,140,140);

        // Mouth
        g.setColor(new Color(208,241,247));
        g.fillOval(390,187,60,60);
        // Eyes
        g.setColor(Color.BLACK);
        g.fillArc(380,158,35,35,155,180);
        g.fillArc(425,158,35,35,205,180);

        // Nose
        g.fillOval(408,195,25,18);

        g2.setStroke(new BasicStroke(3));
        g2.drawLine(405,225,420,220);
        g2.drawLine(420,200,420,220);
        g2.drawLine(420,220,435,225);

        g2.setStroke(new BasicStroke(1));
    }

    private void drawSkate(Graphics g){
        // Control direction of the panda
        if(skateForward){
            xPos+=50;
        }else{
            xPos-=50;
        }
        skatePosition++; // For controlling the face expression

        // Black body
        g.setColor(Color.black);
        g.fillOval(xPos+15,yPos+70,120,145);

        // White body
        g.setColor(Color.white);
        g.fillOval(xPos+20,yPos+135,110,80);

        //Arm
        g.setColor(Color.black);
        g.fillOval(xPos+5,yPos+105,50,48);
        g.fillOval(xPos+95,yPos+105,50,48);

        // Leg
        g.setColor(Color.black);
        g.fillOval(xPos+5,yPos+90+70,50,55); // Left
        g.fillOval(xPos+95,yPos+90+70,50,55); // Right
        // Left leg stamp
        g.setColor(new Color(222,184,135));
        g.fillOval(xPos+13,yPos+110+70,35,30);
        g.fillOval(xPos+10,yPos+103+70,10,10);
        g.fillOval(xPos+25,yPos+98+70,10,10);
        g.fillOval(xPos+40,yPos+103+70,10,10);
        // Right leg stamp
        g.fillOval(xPos+103,yPos+110+70,35,30);
        g.fillOval(xPos+100,yPos+103+70,10,10);
        g.fillOval(xPos+115,yPos+98+70,10,10);
        g.fillOval(xPos+130,yPos+103+70,10,10);

        // Ears
        g.setColor(Color.black);
        g.fillOval(xPos,yPos-10,50,50);
        g.fillOval(xPos+100,yPos-10,50,50);

        // Face
        g.setColor(Color.white);
        g.fillOval(xPos,yPos,150,125);

        // Black-Eyes
        g.setColor(Color.black);
        g.fillOval(xPos+25,yPos+45,30,35);
        g.fillOval(xPos+95,yPos+45,30,35);

        // Nose
        g.setColor(Color.black);
        g.fillOval(xPos+60,yPos+80,30,20);

        // Cheek
        g.setColor(Color.pink);
        g.fillOval(xPos+20,yPos+85,25,10);
        g.fillOval(xPos+105,yPos+85,25,10);

        // Switching expression (eyes and mouth)
        // Mouth
        if(skatePosition%2 == 0){
            g.setColor(Color.black);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(1));
            g2.fillArc(xPos+63,yPos+97,25,15,180,180);

            g2.setColor(Color.red);
            g2.fillArc(xPos+64,yPos+110,20,10,30,100);

            // White-eye
            g.setColor(Color.white);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(xPos+35,yPos+55,xPos+48,yPos+65);
            g2.drawLine(xPos+35,yPos+70,xPos+48,yPos+65);

            g2.drawLine(xPos+100,yPos+65,xPos+113,yPos+55);
            g2.drawLine(xPos+100,yPos+65,xPos+113,yPos+70);
            g2.setStroke(new BasicStroke(1));

        }else{
            // White-Eyes
            g.setColor(Color.white);
            g.fillOval(xPos+35,yPos+50,10,12);
            g.fillOval(xPos+105,yPos+50,10,12);

            // Mouth - Smile
            g.setColor(Color.black);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.drawArc(xPos+63,yPos+97,25,15,180,180);

            // Reset Thickness
            g2.setStroke(new BasicStroke(1));
        }

        //Skate Board
        g.setColor(Color.red);
        g.fillRoundRect(xPos-20,yPos+210,200,20,50,10);
        g.setColor(Color.black);
        g.fillOval(xPos+10,yPos+228,25,25);
        g.fillOval(xPos+120,yPos+228,25,25);
    }

}
