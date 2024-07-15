package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.view.GraphicObjectPanel;

public class CreateCommand implements Command {

    private final GraphicObject go;

    public CreateCommand(GraphicObject go) {
        this.go = go;
    }

    @Override
    public boolean execute() {
        go.moveTo(go.getPosition().getX(), go.getPosition().getY());
        GraphicObjectPanel.getInstance().add(go);
        return true;
    }

    @Override
    public boolean undo() {
        GraphicObjectPanel.getInstance().remove(go);
        return true;
    }

    public GraphicObject getGraphicObject() {
        return go;
    }
}
