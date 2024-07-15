package shapes.specificcommand;

import command.Command;
import shapes.model.GraphicObject;

import java.awt.geom.Point2D;

public class MoveCommand implements Command {

	private  final Point2D oldPos;

	private  final Point2D newPos;

	private  final GraphicObject object;
	
	public MoveCommand(GraphicObject go, Point2D pos) {
		oldPos = go.getPosition();
		newPos = pos;
		this.object = go;
		
		
	}

	@Override
	public boolean doIt() {

		object.moveTo(newPos);

		return true;
	}

	@Override
	public boolean undoIt() {
		object.moveTo(oldPos);
		
		return true;
	}

}
