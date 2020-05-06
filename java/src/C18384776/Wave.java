package C18384776;

import processing.core.PApplet;

public class Wave {
    Start mv;
    float cy = 0;

    public Wave(Start mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
    }

    public void render()
    {
        mv.background(40);
        mv.colorMode(PApplet.HSB);

        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.line(i * 3, cy, i * 4, cy + cy * mv.getAudioBuffer().get(i));
        }
    }
}