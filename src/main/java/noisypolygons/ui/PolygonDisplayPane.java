package noisypolygons.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class PolygonDisplayPane extends JPanel implements PolygonDisplayView {
    private static final int GRID_WIDTH = 10;
    private static final int GRID_HEIGHT = 10;
    private static final Dimension DIMENSIONS = new Dimension(800, 800);
    private List<Shape> polygons;

    public PolygonDisplayPane(){
        setPreferredSize(DIMENSIONS);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (polygons == null)
            return;

        int xp = 0;

        for (int x = 0; x < GRID_WIDTH; x++){
            int yp = 0;
            xp = xp + getWidth() / GRID_WIDTH;

            for (int y = 0; y < GRID_HEIGHT; y++) {
                yp = yp + getHeight() / GRID_HEIGHT;
                //move to grid position
                g2d.translate(xp, yp);
                //use grid index
                Shape polygon = polygons.get(x*GRID_WIDTH+y);
                g2d.setStroke(new BasicStroke(1));
                //use index as seed for random color, to ensure consistent colour after each repaint
                g2d.setColor(generateRandomColorFromObject(x*999+y));
                g2d.fill(polygon);
                g2d.setStroke(new BasicStroke(2));
                g2d.setColor(Color.black);
                g2d.draw(polygon);
                //reset
                g2d.translate(-xp, -yp);
            }

        }
    }

    private static Color generateRandomColorFromObject(Object obj) {
        Random rand = new Random(obj.hashCode());
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }

    @Override
    public void setPolygons(List<Shape> polygons) {
        this.polygons = polygons;
    }

    @Override
    public int getNumberOfPolygons() {
        return GRID_WIDTH * GRID_HEIGHT;
    }

    @Override
    public void update() {
        repaint();
    }
}
