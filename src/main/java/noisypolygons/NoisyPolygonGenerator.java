package noisypolygons;

import midpointdisplacement.MidpointDisplacedPath;
import midpointdisplacement.MidpointDisplacement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NoisyPolygonGenerator {
    private MidpointDisplacement midpointDisplacement;
    private int seed;
    private int edgeType = MidpointDisplacedPath.STRAIGHT_EDGED;

    public void setMidpointDisplacement(MidpointDisplacement midpointDisplacement) {
        this.midpointDisplacement = midpointDisplacement;
    }

    public void setEdgeType(int edgeType) {
        this.edgeType = edgeType;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    /** Generates a regular polygon with randomly displaced edges using the configured midpoint displacement and seed.*/
    public Shape generatePolygon(double radius, int sides){
        MidpointDisplacedPath path = new MidpointDisplacedPath(midpointDisplacement, edgeType, seed);
        // angle (in radians) between each vertex
        double angleStep = 2 * Math.PI / sides;
        path.moveTo(radius, 0);

        for (int i = 0; i < sides; i++) {
            double angle = i * angleStep;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            path.midpointDisplacedLineTo(x, y);
        }

        path.midpointDisplacedLineTo(radius, 0);
        path.closePath();
        return path;
    }

    /** Generates a list of regular polygon with randomly displaced edges using the configured midpoint displacement and seed.*/
    public List<Shape> generatePolygons(int numberOfPolygons, double radiusLength, int numberOfEdges) {
        List<Shape> polygons = new ArrayList<>();
        int originalSeed = seed;

        for (int i=0; i < numberOfPolygons; i++) {
            Shape p = generatePolygon(radiusLength, numberOfEdges);
            polygons.add(p);
            setSeed(seed + 1);
        }

        setSeed(originalSeed);

        return polygons;
    }
}
