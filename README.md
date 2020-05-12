# Music Visualiser Project

Name: Eduards Samuls

Student Number: C18384776

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
Music visualiser that reacts to music given. 
User is able to stop or play music by hitting spacebar and 'p'. 
Each visual gets switched to another automatically.

# Instructions
Clone this repository and run the code. 
Press spacebar to start playing sound or 'p' to stop playing sound.

# How it works
All visuals are ran through Start.java in the package C18384776.
Every visual that is run is found in this package.

Inside this Start.java we have constuctors for visuals that are called in setup().
These are needed to create the visuals inside Start.java.

```Java
        lm = new LinesMoving(this);
        CandS = new SquaresCircleTriangle(this);
        circScr = new CircleScreensaver(this);
        cubandSphr = new CubesAndSphere(this);
        wv = new Wave(this);
```

These visuals are drawn in the draw() method.
```Java
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
            case 4:
                wv.render();
                break;
        }
```

The visuals will switch automatically after a period of time.
```Java
        // Timer to switch between visuals.
        duration++;

        // The amount of time each visual gets allocated.
        if (duration < 400)
        {
            menu = 0;
        }
        else if (duration < 800)
        {
            menu = 1;
        }
        else if (duration < 1200)
        {
            menu = 2;
        }
        else if (duration < 1600)
        {
            menu = 3;
        }
        else if (duration < 2000)
        {
            // Camera reset : Is needed when CubesAndSphere.java gets played.
            camera();
            menu = 4;
        }
        else if (duration == 2400)
        {
            duration = 0;
        }
```

The user is expected to press space to start playing the music or 'p' to stop.

# What I am most proud of in the assignment

# Video
Video can be found [here](https://vimeo.com/417818769).

