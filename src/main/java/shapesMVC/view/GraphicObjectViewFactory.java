package shapesMVC.view;

import shapesMVC.model.GraphicObject;

import java.util.HashMap;
import java.util.Map;

public enum GraphicObjectViewFactory {
    FACTORY;
    private final Map<Class <? extends GraphicObject>, GraphicObjectView> viewMap = new HashMap<>();

    GraphicObjectView createView(GraphicObject go) {return viewMap.get(go.getClass());}
    public void installView(Class <? extends GraphicObject> classObject, GraphicObjectView view) {viewMap.put(classObject, view);}

}
