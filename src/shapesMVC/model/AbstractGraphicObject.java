package shapesMVC.model;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGraphicObject implements GraphicObject {

    private List<GraphicObjectListener> listeners = new LinkedList<>();
    private String id;

    public AbstractGraphicObject(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void addGraphicObjectListener(GraphicObjectListener listener) {
        if (listeners.contains(listener)) return;
        listeners.add(listener);
    }

    @Override
    public void removeGraphicObjectListener(GraphicObjectListener listener) {
        listeners.remove(listener);
    }

    protected void notifyListeners(GraphicObjectEvent e) {
        for (GraphicObjectListener gol: listeners)
            gol.graphicObjectChanged(e);
    }

    @Override
    public GraphicObject clone() {
        try {
            AbstractGraphicObject go = (AbstractGraphicObject) super.clone();
            go.listeners = new LinkedList<>();
            return go;
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
