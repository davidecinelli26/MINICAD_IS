package shapesMVC.specificcommand;

import command.Command;
import shapesMVC.model.GraphicObject;
import shapesMVC.view.GraphicObjectPanel;

public class DeleteCommand implements Command {

    private final GraphicObjectPanel panel;
    private final GraphicObject go;

    public DeleteCommand(GraphicObjectPanel panel, GraphicObject go) {
        this.panel = panel;
        this.go = go;
    }

    @Override
    public boolean execute() {
        panel.remove(go);
        return true;
    }

    @Override
    public boolean undo() {
        panel.add(go);
        return true;
    }
}
