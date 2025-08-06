### NoisyPolygons ###
A 2d shape generator that adds random noise along each edge.

Each edge of a regular polygon is drawn with a [MidpointDisplacementPath](https://github.com/DM-UK/MidpointDisplacement/blob/master/src/main/java/midpointdisplacement/MidpointDisplacedPath.java).

![](https://github.com/DM-UK/NoisyPolygons/blob/master/src/main/resources/screenshot1.png)

## Usage ##
```
NoisyPolygonGenerator generator = new NoisyPolygonGenerator();
generator.setMidpointDisplacement(mpd); // ensure displacement algorithmn is set 
Shape shape = generator.generatePolygon(25, 6); // hexagon with radius of 25
```
## Demo Screenshot ##
![](https://github.com/DM-UK/NoisyPolygons/blob/master/src/main/resources/screenshot2.png)
