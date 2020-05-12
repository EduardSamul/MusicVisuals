package C18384776;

public class CircleScreensaver {
    Start mv;

    public CircleScreensaver(Start mv)
    {
        this.mv = mv;
    }

    // Settings for moving circle.
    float sideways = 500;
    float UpDown = 500;
    float speedForX = 30;
    float speedForY = 45;

    // Render moving circle.
    public void render() {
        mv.noStroke();
        mv.fill(mv.random(255), mv.random(255), mv.random(255));

        // X Axis
        sideways += speedForX;
        if (sideways > mv.width || sideways < 0)
        {
            speedForX *= -1;
        }

        // Y Axis
        UpDown += speedForY;
        if (UpDown > mv.height || UpDown < 0)
        {
            speedForY *= -1;
        }

        mv.circle(sideways, UpDown, 200);
    }
}