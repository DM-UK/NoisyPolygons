package noisypolygons;

import noisypolygons.ui.GeneratePolygonAction;
import noisypolygons.ui.GeneratorForm;
import noisypolygons.ui.NewSeedAction;
import noisypolygons.ui.PolygonDisplayPane;

import javax.swing.*;
import java.awt.*;

public class NoisyPolygonDemoApp {
    private NoisyPolygonGenerator polygonGenerator = new NoisyPolygonGenerator();
    private JFrame frame = new JFrame("Demo");
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel generatorFormContainerPane = new JPanel();
    private GeneratorForm generatorForm = new GeneratorForm();
    private PolygonDisplayPane displayPane = new PolygonDisplayPane();
    private GeneratePolygonAction generatePolygonAction = new GeneratePolygonAction(generatorForm, displayPane, polygonGenerator);
    private NewSeedAction newSeedAction = new NewSeedAction(polygonGenerator, generatePolygonAction);

    public NoisyPolygonDemoApp() {
        buildGUI();
        attachListeners();
    }

    private void buildGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        generatorFormContainerPane.add(generatorForm);
        panel.add(generatorFormContainerPane, BorderLayout.WEST);
        panel.add(displayPane, BorderLayout.CENTER);
        frame.add(panel);
        frame.pack();
    }

    private void attachListeners() {
        generatorForm.addActionListener(generatePolygonAction);
        generatorForm.getButton().addActionListener(newSeedAction);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NoisyPolygonDemoApp();
            }
        });

    }
}
