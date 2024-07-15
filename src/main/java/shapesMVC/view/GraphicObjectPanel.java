package shapesMVC.view;

import shapesMVC.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GraphicObjectPanel extends JComponent implements GraphicObjectListener {

    private static final long serialVersionUID = -8785390858215868800L;

    private static GraphicObjectPanel instance;
    private final Map<String, GraphicObject> graphicObjects;
    private static int id = 0;

    private CircleObject circle;
    private RectangleObject rectangle;
    private ImageObject image;

    private GraphicObjectPanel() {
        graphicObjects = new HashMap<>();
        setBackground(Color.WHITE);
        circle = new CircleObject();
        rectangle = new RectangleObject();
        image = new ImageObject();
    }

    public static synchronized GraphicObjectPanel getInstance() {
        if (instance == null) {
            instance = new GraphicObjectPanel();
        }
        return instance;
    }

    @Override
    public void graphicObjectChanged(GraphicObjectEvent e) {
        repaint();
        revalidate();
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

    public String generateNextObjectId() {
        String id_s = "obj" + id;
        id++;
        return id_s;
    }

    public void add(GraphicObject go) {
        graphicObjects.put(go.getId(), go);
        go.addGraphicObjectListener(this);
        repaint();
    }

    public void remove(GraphicObject go) {
        graphicObjects.remove(go.getId());
        repaint();
        go.removeGraphicObjectListener(this);
    }

    public void clear() {
        graphicObjects.clear();
    }

    public CircleObject getCircle() {
        return circle.clone();
    }

    public RectangleObject getRectangle() {
        return rectangle.clone();
    }

    public ImageObject getImage() {
        return image.clone();
    }

    public GraphicObject getObject(String id) {
        return getGraphicObjects().get(id);
    }

    public Map<String, GraphicObject> getGraphicObjects() {
        return graphicObjects;
    }
}
