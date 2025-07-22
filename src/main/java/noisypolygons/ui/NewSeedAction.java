package noisypolygons.ui;

import noisypolygons.NoisyPolygonGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewSeedAction extends AbstractAction {
    private final NoisyPolygonGenerator polygonGenerator;
    private final GeneratePolygonAction generatePolygonAction;

    public NewSeedAction(NoisyPolygonGenerator polygonGenerator, GeneratePolygonAction generatePolygonAction){
        this.polygonGenerator = polygonGenerator;
        this.generatePolygonAction = generatePolygonAction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        polygonGenerator.setSeed((int)(Math.random()*Integer.MAX_VALUE));

        //call a GeneratePolygonAction so as to update view with new polygons
        generatePolygonAction.actionPerformed(
                new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "new-seed")
        );    }
}
