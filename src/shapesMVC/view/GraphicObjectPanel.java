package shapesMVC.view;

import shapesMVC.model.GraphicObject;
import shapesMVC.model.GraphicObjectEvent;
import shapesMVC.model.GraphicObjectListener;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GraphicObjectPanel extends JComponent implements GraphicObjectListener {

    private static final long serialVersionUID = -8785390858215868800L;

    private static int id = 0;

    private final Map<String, GraphicObject> graphicObjects = new HashMap<>();

    public GraphicObjectPanel() {
        setBackground(Color.WHITE);
    }

    @Override
    public void graphicObjectChanged(GraphicObjectEvent e) {
        repaint();
        revalidate();
    }

    public GraphicObject getGraphicObjectAt(Point2D point) {
        for (GraphicObject g: graphicObjects.values())
            if (g.contains(point))
                return g;
        return null;
    }

    public Dimension getPreferredSize() {
        Dimension ps = super.getPreferredSize();
        double x = ps.getWidth();
        double y = ps.getHeight();
        for (GraphicObject go: graphicObjects.values()) {
            double nx = go.getPosition().getX() + go.getDimension().getWidth() / 2;
            double ny = go.getPosition().getY() + go.getDimension().getHeight() / 2;
            if (nx > x) x = nx;
            if (ny > y) y = ny;
        }
        return new Dimension((int) x, (int) y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gr = (Graphics2D) g;
        for (GraphicObject go: graphicObjects.values()) {
            GraphicObjectView view = GraphicObjectViewFactory.FACTORY.createView(go);
            view.drawGraphicObject(go, gr);
        }
    }

    public void add(GraphicObject go) {
        graphicObjects.put("obj" + id, go);
        id++;
        go.addGraphicObjectListener(this);
        repaint();
    }

    public void remove(GraphicObject go) {
        Iterator<Map.Entry<String, GraphicObject>> iterator = graphicObjects.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, GraphicObject> entry = iterator.next();
            if (entry.getValue().equals(go)) {
                iterator.remove();
                repaint();
                go.removeGraphicObjectListener(this);
                break;
            }
        }
    }

    public Map<String, GraphicObject> getGraphicObjects() {
        return graphicObjects;
    }
}
