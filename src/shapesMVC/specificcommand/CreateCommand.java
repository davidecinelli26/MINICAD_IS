package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.view.GraphicObjectPanel;

public class CreateCommand implements Command {

    private final GraphicObjectPanel panel;
    private final GraphicObject go;

    public CreateCommand(GraphicObjectPanel panel, GraphicObject go) {
        this.panel = panel;
        this.go = go;
    }

    @Override
    public boolean execute() {
        go.moveTo(go.getPosition().getX(), go.getPosition().getY());
        panel.add(go);
        return true;
    }

    @Override
    public boolean undo() {
        panel.remove(go);
        return true;
    }
}
