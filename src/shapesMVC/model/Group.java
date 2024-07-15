package shapesMVC.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class Group extends AbstractGraphicObject {

    private List<GraphicObject> members;

    public Group(String id, List<GraphicObject> members) {
        super(id);
        this.members = new LinkedList<>(members);
    }

    public List<GraphicObject> getMembers() {
        return new LinkedList<>(members);
    }

    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public Dimension2D getDimension() {
        return null;
    }

    @Override
    public void moveTo(Point2D point) {
        for (GraphicObject go: members)
            go.moveTo(point);
    }

    @Override
    public void scale(double factor) {
        for (GraphicObject go: members)
            go.scale(factor);
    }

    @Override
    public boolean contains(Point2D point) {
        for (GraphicObject go: members)
            if (go.contains(point)) return true;
        return false;
    }

    @Override
    public double area() {
        double sum = 0.0;
        for (GraphicObject go: members)
            sum += go.area();
        return sum;
    }

    @Override
    public double perimeter() {
        double sum = 0.0;
        for (GraphicObject go: members)
            sum += go.perimeter();
        return sum;
    }

    @Override
    public String getType() {
        return "Group";
    }

    @Override
    public Group clone() {
        Group cloned = (Group) super.clone();
        cloned.members = new LinkedList<>();
        return cloned;
    }
}
