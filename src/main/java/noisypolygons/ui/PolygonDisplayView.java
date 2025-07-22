package noisypolygons.ui;

import java.awt.*;
import java.util.List;

public interface PolygonDisplayView {
    /** Set polygons to display */
    void setPolygons(List<Shape> shapes);
    /** Number of polygons to display */
    int getNumberOfPolygons();
    /** Update display */
    void update();
}
