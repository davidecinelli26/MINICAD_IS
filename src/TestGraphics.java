import command.HistoryCommandHandler;
import shapes.controller.GraphicObjectController;
import shapes.model.CircleObject;
import shapes.model.GraphicObject;
import shapes.model.ImageObject;
import shapes.model.RectangleObject;
import shapes.view.*;

import javax.swing.*;
import java.awt.*;

public class TestGraphics {

	public static void main(String[] args) {

		JFrame f = new JFrame();

		JToolBar toolbar = new JToolBar();
		JButton undoButt = new JButton("Undo");
		JButton redoButt = new JButton("Redo");

		final HistoryCommandHandler handler = new HistoryCommandHandler();

		undoButt.addActionListener(evt -> handler.undo());

		redoButt.addActionListener(evt -> handler.redo());
		toolbar.add(undoButt);
		toolbar.add(redoButt);

		GraphicObjectLogger logger = new GraphicObjectLogger();

		GraphicObjectPanel gpanel = new GraphicObjectPanel();

		gpanel.setPreferredSize(new Dimension(400, 400));
		GraphicObjectViewFactory.FACTORY.installView(RectangleObject.class, new RectangleObjectView());
		GraphicObjectViewFactory.FACTORY.installView(CircleObject.class, new CircleObjectView());
		GraphicObjectViewFactory.FACTORY.installView(ImageObject.class, new ImageObjectView());

		GraphicObject go = new RectangleObject(new Point(80, 80), 20, 50);
		gpanel.add(go);
		go.addGraphicObjectListener(logger);
		GraphicObjectController goc1 = new GraphicObjectController(go, handler);

		go = new CircleObject(new Point(100, 100), 10);
		gpanel.add(go);
		go.addGraphicObjectListener(logger);
		GraphicObjectController goc2 = new GraphicObjectController(go, handler);

		go = new ImageObject(new ImageIcon(TestGraphics.class.getResource("shapes/model/NyaNya.gif")),
				new Point(40, 87));
		gpanel.add(go);
		go.addGraphicObjectListener(logger);
		GraphicObjectController goc3 = new GraphicObjectController(go, handler);

		f.add(toolbar, BorderLayout.NORTH);
		f.add(gpanel, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel(new FlowLayout());
		controlPanel.add(goc1);
		controlPanel.add(goc2);
		controlPanel.add(goc3);

		f.getContentPane().add(new JScrollPane(controlPanel), BorderLayout.SOUTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);

	}
}