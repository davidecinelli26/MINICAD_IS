package shapes.specificcommand;

import command.Command;
import shapes.model.GraphicObject;
import shapes.view.GraphicObjectPanel;

public class NewObjectCmd implements Command {

	private final GraphicObjectPanel panel;
	private final GraphicObject go;

	public NewObjectCmd(GraphicObjectPanel panel, GraphicObject go) {
		
		this.panel = panel;
		this.go = go;
		
	}

	@Override
	public boolean doIt() {
		double x = 10;
		double y =  10;
		go.moveTo(x, y);
		panel.add(go);

		return true;
	}

	@Override
	public boolean undoIt() {
		panel.remove(go);
		return true;
	}

}
