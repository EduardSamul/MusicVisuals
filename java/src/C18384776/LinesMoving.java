package C18384776;

import processing.core.*;

public class LinesMoving {
    Start mv;

    public LinesMoving(Start mv)
    {
        this.mv = mv;
    }

    float v;
    int NumOfLines = 15;
    public void render() {
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        mv.strokeWeight(3);
        mv.background(0);

        // Translate to the center point of window.
        mv.translate(mv.width/2, mv.height/2);

        for(int i = 0 ; i < NumOfLines ; i++)
        {
            mv.line(x1(v + i), y1(v + i), x2(v + i), y2(v + i));
        }
        v++;
    }

    float x1(float v) {
        return PApplet.sin(v / 10) * (mv.getSmoothedAmplitude() * 1500) + PApplet.sin(v / 15) * 70;
    }

    float y1(float v) {
        return PApplet.cos(-v / 80) * (mv.getSmoothedAmplitude() * 1500) + PApplet.cos(v / 20) * mv.getSmoothedAmplitude();
    }

    float x2(float v) {
        return PApplet.sin(v / 10) * (mv.getSmoothedAmplitude() * 1500) + PApplet.sin(v) * mv.getSmoothedAmplitude();
    }

    float y2(float v) {
        return PApplet.cos(v / 15) * (mv.getSmoothedAmplitude() * 1500) + PApplet.cos(v / 20) * 50;
    }
}