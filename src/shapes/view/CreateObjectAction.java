package shapes.view;

import command.CommandHandler;
import shapes.model.AbstractGraphicObject;
import shapes.model.GraphicObject;
import shapes.specificcommand.NewObjectCmd;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateObjectAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5399493440620423134L;
	AbstractGraphicObject prototype;
	GraphicObjectPanel panel;
	CommandHandler ch;

	public CreateObjectAction(AbstractGraphicObject prototype,
			GraphicObjectPanel panel, CommandHandler ch) {
		super();
		this.prototype = prototype;
		this.panel = panel;
		this.ch = ch;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		GraphicObject go = prototype.clone();
		ch.handle(new NewObjectCmd(panel, go));

	}

}
