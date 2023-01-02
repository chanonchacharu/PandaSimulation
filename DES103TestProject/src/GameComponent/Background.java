package GameComponent;

import Gameplay.LoginPanel;

import java.awt.*;
import java.util.Random;

public class Background {

    public static String backgroundType = "moutain";
    public static String timeofday = "daytime";
    Random r = new Random();

    /*
     * Draw different backgrounds depending on the String value of backgroundType and timeofday
     */
    public static void drawBackground(Graphics g){

        if(timeofday == "daytime"){
            drawDayTime(g);
        }else if(timeofday == "night"){
            drawNightTime(g);
        }

        switch(backgroundType){
            case "moutain":
                drawMoutainHouse(g);
                break;
            case "castle":
                drawCastle(g);
                break;
            case "cave":
                drawCave(g);
                break;
            case "warning":
                drawWarning(g);
                break;
            case "club":
                drawClub(g);
                break;
            case "heaven":
                drawHeaven(g);
                break;
        }

        //PandaPanel.drawGrid(g);

    }

    // Night Time background
    private static void drawNightTime(Graphics g){
        // Night Sky and Moon
        g.setColor(new Color(33,66,133));
        g.fillRect(0,0,600,425);

        // Moon
        g.setColor(Color.yellow);
        g.fillOval(20,20,110,110);
        g.setColor(new Color(33,66,133));
        g.fillOval(0,0,100,100);

    }

    // Day time background
    private static void drawDayTime(Graphics g){
        // Sky
        g.setColor(new Color(152,240,245));
        g.fillRect(0,0,600,425);

        drawSun(g);
        drawClouds(g);
    }

    // Draw Warning Sign
    private static void drawWarning(Graphics g){
        Color orangeYel = new Color(247,167,17);
        g.setColor(orangeYel);
        g.fillRect(0,0,600,450);

        g.setColor(Color.black);
        g.fillRoundRect(10,10,580,100,50,50);

        g.setColor(orangeYel);
        int[] x = {35,75,115};
        int[] y = {90,20,90};
        g.fillPolygon(x,y,3);
        g.setFont(new Font("Courier",Font.BOLD,100));
        g.drawString("WARNING",130,85);
        g.setColor(Color.black);
        g.drawString("!",45,90);
    }

    // Draw Cave
    private static void drawCave(Graphics g){
        g.setColor(new Color(189,138,87));
        g.fillRect(0,375,600,50);

        g.setColor(new Color(99,98,95));
        g.fillRect(50,200,325,175);

        g.setColor(new Color(150,150,149));
        g.fillRoundRect(35,175,50,200,50,50);
        g.fillRoundRect(35,175,360,50,50,50);
        g.fillRoundRect(350,175,50,200,50,50);

        g.setColor(Color.white);
        g.setFont(new Font("Courier",Font.BOLD,25));
        g.drawString(LoginPanel.panda_name +"'s Cave",100,210);

    }

    // Draw Castle
    private static void drawCastle(Graphics g){

        // Ground
        g.setColor(new Color(189,138,87));
        g.fillRect(0,375,600,50);

        // Gray Base
        g.setColor(Color.gray);
        int[] x = {150,450,425,175};
        int[] y = {400,400,350,350};
        g.fillPolygon(x,y,4);

        // Body
        g.setColor(new Color(255,255,240));
        g.fillRect(187,312,225,38);
        g.fillRect(199,238,200,37);
        g.fillRect(212,175,176,35);
        g.fillRect(225,120,150,30);
        g.fillRect(237,70,128,30);

        // Body - Decoration
        g.setColor(Color.black);
        g.fillRect(187,331,225,19);
        g.fillRect(199,256,200,19);
        g.fillRect(212,192,176,18);
        g.fillRect(225,135,150,15);
        g.fillRect(237,85,128,15);

        g.setColor(Color.white);
        for(int i = 0; i < 16; i++){
            g.fillRect(190+i*14,335,8,10);
        } // base
        for(int i = 0; i < 13; i++){
            g.fillRect(205+i*15,260,8,10);
        } // base - 1
        for(int i = 0; i < 11; i++){
            g.fillRect(222+i*15,197,8,10);
        }//middle
        for(int i = 0; i < 12; i++){
            g.fillRect(232+i*12,139,6,8);
        }// upper - 1
        for(int i = 0; i < 10; i++){
            g.fillRect(245+i*12,88,6,8);
        } // upper


        // Roof
        g.setColor(new Color(65,186,128));
        int[] xR = {150,200,400,450};
        int[] yR = {312,275,275,312};
        //
        g.fillPolygon(xR,yR,4);

        int[] xR1 = {162,212,388,438};
        int[] yR1 = {238,210,210,238};
        g.fillPolygon(xR1,yR1,4);

        int[] xR2 = {187,225,375,413};
        int[] yR2 = {175,150,150,175};
        g.fillPolygon(xR2,yR2,4);

        int[] xR3 = {200,237,365,400};
        int[] yR3 = {120,100,100,120};
        g.fillPolygon(xR3,yR3,4);

        int[] xR4 = {220,240,240,362,362,382};
        int[] yR4 = {70,50,25,25,50,70};
        g.fillPolygon(xR4,yR4,6);

        // Roof Stripe
        g.setColor(new Color(7,145,79));
        for(int i = 0; i < 14; i++){
            g.fillRect(200+i*15,275,5,37);
        } // bottom
        for(int i = 0; i < 12; i++){
            g.fillRect(212+i*15,210,5,28);
        } // bottom - 1
        for(int i = 0; i < 10; i++){
            g.fillRect(225+i*16,150,5,25);
        } // middle
        for(int i = 0; i < 9; i++){
            g.fillRect(237+i*15,100,5,20);
        } // top - 1
        for(int i =0; i < 7; i++){
            g.fillRect(240+i*19,25,5,45);
        } // top


        // Roof Triangle
        g.setColor(new Color(88,204,148));
        int[] xtri = {205,250,295};
        int[] xtri2 = {305,350,395};
        int[] ytri = {320,270,320};
        g.fillPolygon(xtri,ytri,3);
        g.fillPolygon(xtri2,ytri,3);

        int[] xtr3 = {250,300,350};
        int[] ytr3 = {220,160,220};
        g.fillPolygon(xtr3,ytr3,3);

        g.setColor(Color.white);
        int[] stri = {225,250,275};
        int[] stri2 = {325,350,375};
        int[] ytri2 = {315,285,315};
        g.fillPolygon(stri,ytri2,3);
        g.fillPolygon(stri2,ytri2,3);

        int[] stri3 = {264,300,336};
        int[] ytri3 = {215,173,215};
        g.fillPolygon(stri3,ytri3,3);
    }

    // Draw Club - Dance Party
    private static void drawClub(Graphics g){

        g.setColor(Color.black);
        g.fillRect(0,0,600,425);

        //Disco Light
        for(int i = -100; i < 590; i+=50){
            g.setColor(new Color((int)(Math.random()*250),(int)(Math.random()*250),(int)(Math.random()*250),100));
            g.fillOval(i,0,200,425);
        }

        // Ground
        g.setColor(new Color(62,91,99));
        g.fillRect(0,380,600,45);

    }

    /*
     * This drawHeaven method draws the graphics when the simulate ended or when timer is stop
     */
    private static void drawHeaven(Graphics g){
        g.setColor(new Color(244,237,245));
        g.fillRect(0,0,600,425);
        g.setFont(new Font("Courier",Font.BOLD,40));
        g.setColor(Color.red);
        g.drawString("The End",250,100);

        // Draw the coffin
        g.setColor(new Color(164,145,134));
        int[] x = {350,400,500,550,500,400};
        int[] y = {200,125,125,200,400,400};
        g.fillPolygon(x,y,6);

        g.setColor(Color.white);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        int[] x1 = {375,420,480,525,480,420};
        int[] y1 = {200,150,150,200,375,375};
        g2.drawPolygon(x1,y1,6);

        g.drawString("R.I.P",390,225);

        g2.setStroke(new BasicStroke(1));
    }

    // Draw House along the moutains
    private static void drawMoutainHouse(Graphics g){
        // Ground
        g.setColor(new Color(189,138,87));
        g.fillRect(0,250,600,175);

        drawMoutains(g);
        drawHouse(g);
    }

    /*
     * Method for drawing smaller components in other drawXXX methods
     */
    private static void drawSun(Graphics g){
        g.setColor(new Color(225,208,0));
        g.fillOval(20,20,110,110);
        for(int i = 0; i < 24; i++){
            g.fillArc(0,0,150,150,i*15,5);
        }
    }

    private static void drawMoutains(Graphics g){
        g.setColor(new Color(10,161,98));
        g.fillArc(220,125,200,250,0,180);
        g.setColor(new Color(14,199,122));
        g.fillArc(76,150,220,200,0,180);
        g.setColor(new Color(13,189,98));
        g.fillArc(350,170,180,160,0,180);
    }

    private static void drawHouse(Graphics g){
        // Roft
        g.setColor(new Color(215,113,117));
        int[] x1 = {325,450,465,325};
        int[] y1 = {130,130,180,180};
        g.fillPolygon(x1,y1,4);

        // House Body
        g.setColor(new Color(237,228,183));
        g.fillRect(275,180,175,70);
        int[] x = {275,275,325,375,375};
        int[] y = {180,160,120,160,180};
        g.fillPolygon(x,y,5);

        // Door
        g.setColor(new Color(163,132,59));
        g.fillRect(395,200,35,50);
        g.setColor(Color.white);
        g.fillOval(400,218,5,5);

        // Window
        if(Background.timeofday == "daytime"){
            g.setColor(new Color(117,217,240));
        }else if(Background.timeofday == "night"){
            g.setColor(Color.black);
        }

        g.fillRect(290,190,70,40);
        g.fillRect(312,150,28,30);
        g.setColor(Color.white);
        g.drawRect(290,190,70,40);
        g.drawRect(312,150,28,30);
        g.drawLine(325,150,325,180);
        g.drawLine(325,190,325,230);
        g.drawLine(312,165,340,165);
        g.drawLine(290,210,360,210);


        // Outline for Roof
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g2.setColor(new Color(235,113,117));
        g2.drawLine(270,165,325,120);
        g2.drawLine(325,120,380,165);

        g2.setStroke(new BasicStroke(1));


        //g2.setColor(Color.black);
        //g2.drawPolygon(new int[]{275,275,325,375,375},new int[]{250,160,120,160,250},5);


    }

    private static void drawClouds(Graphics g){
        g.setColor(new Color(196,245,244));

        int xCloud = 200, yCloud = 30;

        g.fillOval(200,30,50,50);
        g.fillOval(230,25,50,50);
        g.fillOval(225,40,50,50);
        g.fillOval(260,28,50,50);
        g.fillOval(255,35,50,50);

        g.fillOval(xCloud+100,yCloud+40,50,50);
        g.fillOval(xCloud+130,yCloud+35,50,50);
        g.fillOval(xCloud +125,yCloud+50,50,50);
        g.fillOval(xCloud+160,yCloud+38,50,50);
        g.fillOval(xCloud+115,yCloud+45,50,50);

        g.fillOval(xCloud + 200,yCloud,50,50);
        g.fillOval(xCloud + 230,yCloud-5,50,50);
        g.fillOval(xCloud+225,yCloud+10,50,50);
        g.fillOval(xCloud + 260, yCloud - 2, 50,50);
        g.fillOval(xCloud + 255,yCloud + 5,50,50);

    }

}
