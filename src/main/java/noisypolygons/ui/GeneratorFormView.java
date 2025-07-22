package noisypolygons.ui;

public interface GeneratorFormView {
    /** Distance from polygon centre to vertices in pixels */
    double getRadiusLength();
    /** Number of polygon edges */
    int getNumberOfEdges();
    /** Number of displacement steps */
    int getSteps();
    /** Maximum displacement in pixels */
    int getMaximumDisplacement();
    /** Displacement roughness factor */
    double getRoughness();
    /** Edge type (straight or curved) */
    String getEdgeType();
}
