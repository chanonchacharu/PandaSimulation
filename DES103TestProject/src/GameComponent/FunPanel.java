package GameComponent;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class FunPanel extends PandaPanel {

    public static String foodtype = "";
    public static boolean hat,eyepad,blanket,pillow;

    public FunPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(300,500));
    }

    public void paintComponent(Graphics g){
        Background.drawBackground(g);

        // Draw Panda
        super.paintComponent(g);

        switch(foodtype){
            case "Bamboo":
                drawFoodBox(g);
                drawBamboo(g);
                break;
            case "Fish":
                drawFoodBox(g);
                drawFish(g);
                break;
            case "Boba":
                drawFoodBox(g);
                drawBobaTea(g);
                break;
            case "Poison":
                drawFoodBox(g);
                drawPoison(g);
                break;
            case "Bomb":
                drawBomb(g);
                break;
        }

        if(hat)drawSleepinghat(g);
        if(eyepad) drawEyepad(g);
        if(pillow) drawPillow(g);
        if(blanket) drawBlanket(g);

        //drawGrid(g);

    }

    /*
     * drawXXX(Graphics g) are used in paintComponent
     * to draw different graphics depending on assigned String value of foodtype
     * and whether the boolean values of hat, eyepad, blanket, and pillow are true or not
     */
    private void drawFoodBox(Graphics g){
        g.setColor(new Color(243,245,196));
        g.fillRoundRect(350,45,175,250,50,50);
        g.setColor(Color.white);
        g.fillRoundRect(360,225,155,60,50,50);
        g.setColor(Color.black);
        g.setFont(new Font("SansSerif",Font.PLAIN,25));
        g.drawString(foodtype,390,265);
        g.setFont(new Font("Arial",Font.BOLD,12));
    }

    private void drawFish(Graphics g){
        int x = 380, y = 75, width = 70, height = 30;
        for(int i = 0; i < 2; i++){

            // Fin-top
            g.setColor(Color.cyan);
            g.fillOval(x+25,(y-10)+i*75,35,15);

            // Tail
            g.setColor(new Color(235,245,0));
            int[] x1 = {x+width-20,x+width+30,x+width+15,x+width+30};
            int[] y1 = {(y+i*75)+20,(y+i*75)+20-30,(y+i*75)+20,(y+i*75)+20+20};
            g.fillPolygon(x1,y1,4);
            g.setColor(new Color(255,204,0));
            g.drawPolygon(x1,y1,4);

            // Body
            g.setColor(new Color(51,204,255));

            g.fillOval(x,y+i*75,width,height);


            // Fin - Body
            g.setColor(new Color(235,245,0));
            g.fillOval(x+25,(y+10)+i*75,25,15);

            // Eye
            g.setColor(Color.black);
            g.fillOval(x+10,y+i*75+5,10,10);

            // White-eye
            g.setColor(Color.white);
            g.fillOval(x+12,y+i*75+7,3,3);

        }

    }

    private void drawBamboo(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        int xstem1 = 465, xstem2 = 440, ystem = 60;
        int leafheight = 10;
        int right_leaf_x = 480, left_leaf_x = 438;
        int right_leaf_y = 100, left_leaf_y = 150;
        int leafRotationAngle = 30;

        Color cobaltgreen = new Color(91,141,90);
        Color yellowgreen = new Color(154,205,50);
        Color olivedrab = new Color(107,142,32);
        Color bamboo = new Color(82,145,74);
        Color valspar = new Color(192,211,122);

        AffineTransform oldForm = g2.getTransform(); // reset the rotation axis

        // Bamboo Stem
        g2.setColor(bamboo);
        g2.fillRect(xstem1,ystem,15,120);
        g2.fillRect(xstem2,ystem,15,120);
        g2.setColor(cobaltgreen);
        g2.fillOval(xstem1,ystem-3,15,10);
        g2.fillOval(xstem2,ystem-3,15,10);
        g2.fillOval(xstem1,ystem+115,15,10);
        g2.fillOval(xstem2,ystem+115,15,10);

        // Right leaf
        g2.rotate(Math.toRadians(leafRotationAngle),right_leaf_x,right_leaf_y);
        g2.setColor(olivedrab);
        g2.fillOval(right_leaf_x,right_leaf_y,35,leafheight);
        // Second leaf
        g2.rotate(Math.toRadians(-leafRotationAngle),right_leaf_x,right_leaf_y);
        g2.setColor(valspar);
        g2.fillOval(right_leaf_x,95,45,leafheight);
        // Third leaf
        g2.rotate(Math.toRadians(-leafRotationAngle),right_leaf_x,right_leaf_y);
        g2.setColor(yellowgreen);
        g2.fillOval(right_leaf_x,90,50,leafheight);

        g2.setTransform(oldForm); // reset to the original axis

        // Left leaf
        g2.rotate(Math.toRadians(-135),left_leaf_x,left_leaf_y);
        g2.fillOval(left_leaf_x,160,35,leafheight);
        // Second leaf
        g2.rotate(Math.toRadians(-leafRotationAngle),left_leaf_x,left_leaf_y);
        g2.setColor(olivedrab);
        g2.fillOval(left_leaf_x,155,40,leafheight);
        // Third leaf
        g2.rotate(Math.toRadians(-leafRotationAngle),left_leaf_x,left_leaf_y);
        g2.setColor(valspar);
        g2.fillOval(left_leaf_x,150,35,leafheight);

        g2.setTransform(oldForm);
    }

    private void drawBobaTea(Graphics g){
        Color tea = new Color(237,216,187);
        Color sugar = new Color(226,170,135,190);
        Color straw = new Color(162,211,199);
        Color container = new Color(255,228,225);
        Color boba = new Color(27,18,18);

        // Straw
        g.setColor(straw);
        g.fillRect(430,55,15,80);
        g.fillOval(430,50,15,10);

        // Milk Tea
        g.setColor(tea);
        int[] xCup = {380,495,480,395};
        int[] yCup = {135,135,210,210};
        g.fillPolygon(xCup,yCup,4);
        g.fillOval(395,200,85,20);

        // Boba Pearl
        g.setColor(boba);
        g.fillOval(400,175,14,14);
        g.fillOval(410,200,14,14);
        g.fillOval(420,180,14,14);
        g.fillOval(435,195,14,14);
        g.fillOval(440,170,14,14);
        g.fillOval(460,195,14,14);
        g.fillOval(465,175,14,14);

        // Brown Sugar
        g.setColor(sugar);
        int x = 381, y = 130, width = 15, height = 25;
        for(int i = 0; i < 11; i++){
            if( i == 0){
                // First control, remain in the container
                g.fillOval(x+2+i*10,y,width-5,height-5);
            }else if(i == 10){
                // Last control, remain in the container
                g.fillOval(x+2+i*10,y,width-5,height-5);
            }else{
                // Vaires height, wave effect
                g.fillOval(x+i*10,y,width,height+random.nextInt(20));
            }

        }

        // Container
        g.setColor(container);
        g.fillRect(375,110,125,25);

    }

    private void drawPillow(Graphics g){
        // Pillow
        g.setColor(new Color(151,230,247));
        g.fillRoundRect(90,370,260,25,20,20);
        g.setColor(Color.white);
        for(int i = 0; i < 5; i++){
            g.fillOval(100+i*50,370+random.nextInt(10),15,15);
        }
    }

    private void drawEyepad(Graphics g){
        // Eye-pad
        g.setColor(new Color(61,191,120));
        g.fillOval(90,290,50,50);
        g.fillOval(170,290,50,50);
        g.fillRect(120,291,80,25);
        int[] x = {200,235,240,205};
        int[] y = {300,275,280,305};
        g.fillPolygon(x,y,4);
        g.setColor(new Color(247,235,96));
        g.fillOval(95,295,40,40);
        g.fillOval(175,295,40,40);
        g.fillRect(120,295,80,15);

    }

    private void drawSleepinghat(Graphics g){
        // Sleeping hat
        g.setColor(new Color(135,148,232));
        g.fillOval(125,250,100,25);
        int[] x1 = {125,175,225,187,225};
        int[] y1 = {262,175,225,200,262};
        g.fillPolygon(x1,y1,5);
        g.setColor(Color.white);
        g.fillOval(220,220,25,25);
    }

    private void drawBlanket(Graphics g){
        // Blanket
        g.setColor(new Color(42,194,245));
        g.fillRoundRect(220,275,200,150,100,100);
        g.setColor(new Color(189,138,87));
        g.fillRect(225,400,200,25);
    }

    private void drawPoison(Graphics g){
        // Poision draw when feeding too much
        g.setColor(new Color(225,227,225));
        g.fillOval(375,125,125,90);
        g.fillRect(420,75,35,100);
        g.setColor(new Color(171,126,12));
        g.fillRect(425,55,25,20);
        g.setColor(new Color(144,12,171));
        g.fillArc(388,135,100,75,180,180);
        for(int i = 388; i < 488; i += 15){
            g.fillOval(i,140+(int)((Math.random())*25),10,10);
        }
    }

    private void drawBomb(Graphics g){
        // Bomb Body
        g.setColor(new Color(138,117,117));
        int[] x = {425,350,350,425,500,500};
        int[] y = {320,345,420,375,420,345};
        g.fillPolygon(x,y,6);
        g.setColor(new Color(107,99,99));
        g.fillRoundRect(350,135,145,200,150,150);
        g.setColor(new Color(173,173,173));
        g.fillRoundRect(350,200,145,75,10,10);
        // Symbol
        g.setColor(Color.black);
        g.fillOval(395,208,25,25);
        g.fillOval(428,208,25,25);
        g.setColor(Color.white);
        g.fillOval(400,218,50,40);


    }

}
