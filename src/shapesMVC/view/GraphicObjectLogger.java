package shapesMVC.view;

import shapesMVC.model.GraphicObject;
import shapesMVC.model.GraphicObjectEvent;
import shapesMVC.model.GraphicObjectListener;

public class GraphicObjectLogger implements GraphicObjectListener {

    @Override
    public void graphicObjectChanged(GraphicObjectEvent e) {
        GraphicObject go = e.getSource();
        System.out.printf("[%s] pos=[%f,%f] dim=[%f,%f]%n", go.getType(),
                go.getPosition().getX(), go.getPosition().getY(),
                go.getDimension().getWidth(), go.getDimension().getHeight());
    }

}
