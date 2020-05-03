package C18384776;

import processing.core.PApplet;

public class CubesAndSphere {
    Start mv;

    public CubesAndSphere(Start mv) {
        this.mv = mv;
    }

    int duration = 0;
    float angle = 0;
    float smoothedBoxSize = 0;

    public void render() {
        mv.background(0);
        mv.noFill();
        mv.lights();
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        mv.translate(0, 0, -250);
        float boxSize = 50 + (mv.getAmplitude() * 500);
        smoothedBoxSize = PApplet.lerp(smoothedBoxSize, boxSize, 0.2f);

        if (duration >= 200)
        {
            mv.pushMatrix();
            mv.translate(-100, 100, 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5);
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(100, -100, 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(-100, -100, 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(100, 100, 0);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.box(smoothedBoxSize);
            mv.popMatrix();

            mv.pushMatrix();
            mv.translate(0, 0, -250);
            mv.rotateY(angle);
            mv.rotateX(angle);
            mv.strokeWeight(5); 
            mv.sphere(smoothedBoxSize);
            mv.popMatrix(); 
        }
        else
        {
            mv.rotateY(angle);
            mv.rotateX(angle);         
            mv.strokeWeight(5);
            mv.box(smoothedBoxSize);
        }
        angle += 0.01f;
        duration++;

    }
}