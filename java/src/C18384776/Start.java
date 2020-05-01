package C18384776;

import ie.tudublin.Visual;

public class Start extends Visual{

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
        loadAudio("heroplanet.mp3");

    }

    public void draw()
    {
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

}