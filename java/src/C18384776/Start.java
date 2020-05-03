package C18384776;

import ie.tudublin.Visual;

public class Start extends Visual{
    int menu = 0;
    LinesMoving lm;
    SquaresCircleTriangle CandS;
    CircleScreensaver circScr;
    CubesAndSphere cubandSphr;
    
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

        lm = new LinesMoving(this);
        CandS = new SquaresCircleTriangle(this);
        circScr = new CircleScreensaver(this);
        cubandSphr = new CubesAndSphere(this);
    }

    public void draw()
    {
        calculateAverageAmplitude();

        switch(menu) {
            case 0:
                circScr.render();
                break;
            case 1:
                lm.render();
                break;
            case 2:
                CandS.render();
                break;
            case 3:
                cubandSphr.render();
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
            case '3':
                menu = 3;
                break;
        }
    }
}
