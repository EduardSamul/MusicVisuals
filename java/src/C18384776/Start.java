package C18384776;

import ie.tudublin.Visual;

public class Start extends Visual{
    int menu = 0;
    
    public void settings()
    {
        size(1000, 1000, P3D);
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("Devochka S Kare.mp3");
    }

    public void draw()
    {
        switch(menu) {
            case 0:
                drawCircleMoving();
                break;
            case 1:
                drawLinesMoving();
                break;
            case 2:
                drawShapes();
                break;
        }

    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }       
        
        switch(key){
            case '0':
                menu = 0;
                break;
            case '1':
                menu = 1;
                break;
            case '2':
                menu = 2;
                break;
        }
    }

    float sideways = 500;
    float UpDown = 500;
    float speedForX = 30;
    float speedForY = 45;

    public void drawCircleMoving()
    {
        noStroke();
        fill(random(255), random(255), random(255));

        // X Axis
        sideways += speedForX;
        if (sideways > width || sideways < 0)
        {
            speedForX *= -1;
        }

        // Y Axis
        UpDown += speedForY;
        if (UpDown > height || UpDown < 0)
        {
            speedForY *= -1;
        }

        circle(sideways, UpDown, 200);
    }

    float v;
    // Number of trailing lines
    int NumOfLines = 15;
    public void drawLinesMoving(){
        stroke(255);
        strokeWeight(3);
        background(40);

        // Translate to the center point of window.
        translate(width/2, height/2);

        for(int i = 0 ; i < NumOfLines ; i++)
        {
            line(x1(v + i), y1(v + i), x2(v + i), y2(v + i));
        }
        v++;

    }

    // Change values to get new designs :)
    float x1(float v) {
        return sin(v / 10) * 100 + sin(v / 15) * 70;
    }

    float y1(float v) {
        return cos(-v / 80) * 400 + cos(v / 20) * 30;
    }

    float x2(float v) {
        return sin(v / 10) * 200 + sin(v) * 2;
    }

    float y2(float v) {
        return cos(v / 15) * 160 + cos(v / 20) * 50;
    }


    int circGoingAccross = 0;
    int rectColour = 0;
    int circColour = 100;
    int triangColour = 200;
    public void drawShapes() {
        calculateAverageAmplitude();
        float Recta = 200 + (getAmplitude() * 300);
        float triang = getAmplitude() * 300;
        float circ = getAmplitude() * 300;
		background(0);
        stroke(255);
        noStroke();

        // Check if rectangle colour out of bounds.
        if (rectColour > 255)
        {
            rectColour = 0;
        }

        // Check if circle colour out of bounds.
        if (circColour > 255)
        {
            circColour = 0;
        }

        // Check if triangle colour out of bounds.
        if (triangColour > 255)
        {
            triangColour = 0;
        }
        // Top Left Rect.
        fill(rectColour, 100, 100);
        rect(width-width, height-width, Recta, Recta);  // tlx, tly, w, h
        rectColour += 5;

        // Bottom Right Rect.
        rect(width-Recta, height-Recta, Recta, Recta);

        // Triangle
        fill(triangColour, 100, 100);
        triangle(width-800-triang, height-100+triang, width-700, height-300-triang, width-600+triang, height-100+triang);
        triangColour += 5;

        // Circle
        fill(circColour, 100, 100);
        circle(width-200, height-800, 200+circ);
        circColour += 5;

        // Circle going across screen.
        circle(circGoingAccross % width, height/2, 200+circ);
        circGoingAccross += 10;
    }
}
