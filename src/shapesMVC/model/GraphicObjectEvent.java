package shapesMVC.model;

public class GraphicObjectEvent {

    private final GraphicObject source;


    public GraphicObjectEvent(GraphicObject source) {
        this.source = source;
    }

    public GraphicObject getSource() {
        return source;
    }
}
