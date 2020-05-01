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
                drawCircleMoving();
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
}
