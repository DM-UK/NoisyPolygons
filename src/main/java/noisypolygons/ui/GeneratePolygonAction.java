package noisypolygons.ui;

import midpointdisplacement.MidpointDisplacedPath;
import midpointdisplacement.MidpointDisplacement;
import noisypolygons.NoisyPolygonGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class GeneratePolygonAction extends AbstractAction{
    private final GeneratorFormView generatorFormView;
    private final PolygonDisplayView polygonDisplayView;
    private final NoisyPolygonGenerator polygonGenerator;

    public GeneratePolygonAction(GeneratorFormView generatorFormView, PolygonDisplayView polygonDisplayView, NoisyPolygonGenerator polygonGenerator) {
        this.generatorFormView = generatorFormView;
        this.polygonDisplayView = polygonDisplayView;
        this.polygonGenerator = polygonGenerator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //setup midpoint displacement algorithm
        MidpointDisplacement midpointDisplacement = new MidpointDisplacement(
                generatorFormView.getSteps(),
                generatorFormView.getMaximumDisplacement(),
                generatorFormView.getRoughness()
        );

        //setup RandomPolygonGenerator
        polygonGenerator.setMidpointDisplacement(midpointDisplacement);

        if (generatorFormView.getEdgeType().equals("Straight"))
            polygonGenerator.setEdgeType(MidpointDisplacedPath.STRAIGHT_EDGED);
        else
            polygonGenerator.setEdgeType(MidpointDisplacedPath.COMPOSITE_BEZIER_CURVE);

        //generate
        List<Shape> polygons = polygonGenerator.generatePolygons(polygonDisplayView.getNumberOfPolygons(), generatorFormView.getRadiusLength(), generatorFormView.getNumberOfEdges());

        //update view
        polygonDisplayView.setPolygons(polygons);
        polygonDisplayView.update();
    }
}
