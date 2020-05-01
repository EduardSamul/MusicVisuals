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
        strokeWeight(5);
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
}
