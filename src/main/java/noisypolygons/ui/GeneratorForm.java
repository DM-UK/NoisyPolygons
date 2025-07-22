package noisypolygons.ui;

import form.JBasicForm;
import slider.DoubleSlider;

import javax.swing.*;

public class GeneratorForm extends JBasicForm implements GeneratorFormView {
    private DoubleSlider radiusSlider;
    private JSlider numberOfEdgesSlider;
    private JSlider stepsSlider;
    private JSlider maximumDisplacementSlider;
    private DoubleSlider roughnessSlider;
    private JComboBox<String> edgeTypeComboBox;

    public GeneratorForm(){
        radiusSlider = addSliderField("Radius", 0.1, 100.0, 5.0);
        numberOfEdgesSlider = addSliderField("Sides", 3, 100, 6);
        stepsSlider = addSliderField("Steps", 1, 10, 3);
        maximumDisplacementSlider = addSliderField("Maximum Displacement", 1, 100, 5);
        roughnessSlider = addSliderField("Roughness", 0.01, 3.0, 0.8);
        edgeTypeComboBox = addComboBoxField("Edge Type", new String[]{"Straight", "Curved"});
        setButtonText("New Seed");
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public double getRadiusLength() {
        return radiusSlider.getDoubleValue();
    }

    @Override
    public int getNumberOfEdges() {
        return numberOfEdgesSlider.getValue();
    }

    @Override
    public int getSteps() {
        return stepsSlider.getValue();
    }

    @Override
    public int getMaximumDisplacement() {
        return maximumDisplacementSlider.getValue();
    }

    @Override
    public double getRoughness() {
        return roughnessSlider.getDoubleValue();
    }

    @Override
    public String getEdgeType() {
        return (String) edgeTypeComboBox.getSelectedItem();
    }
}
