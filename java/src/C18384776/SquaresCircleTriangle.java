package C18384776;


public class SquaresCircleTriangle {
    Start mv;

    public SquaresCircleTriangle(Start mv)
    {
        this.mv = mv;
    }

    int circGoingAccross = 0;
    int rectColour = 0;
    int circColour = 100;
    int triangColour = 200;

    public void render() {
        float Recta = 200 + (mv.getAmplitude() * 300);
        float triang = mv.getAmplitude() * 300;
        float circ = mv.getAmplitude() * 300;
        mv.background(0);
        mv.stroke(255);
        mv.noStroke();
    
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
        mv.fill(rectColour, 100, 100);
        mv.rect(mv.width-mv.width, mv.height-mv.width, Recta, Recta);  // tlx, tly, w, h
        rectColour += 5;
    
        // Bottom Right Rect.
        mv.rect(mv.width-Recta, mv.height-Recta, Recta, Recta);
    
        // Triangle
        mv.fill(triangColour, 100, 100);
        mv.triangle(mv.width-800-triang, mv.height-100+triang, mv.width-700, mv.height-300-triang, mv.width-600+triang, mv.height-100+triang);
        triangColour += 5;
    
        // Circle
        mv.fill(circColour, 100, 100);
        mv.circle(mv.width-200, mv.height-800, 200+circ);
        circColour += 5;
    
        // Circle going across screen.
        mv.circle(circGoingAccross % mv.width, mv.height/2, 200+circ);
        circGoingAccross += 10;
    }

}