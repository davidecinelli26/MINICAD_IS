import command.*;
import shapesMVC.controller.CommandInterpreter;
import shapesMVC.model.CircleObject;
import shapesMVC.model.ImageObject;
import shapesMVC.model.RectangleObject;
import shapesMVC.view.*;
import shapesMVC.view.MainFrame;

public class Test {

    public static void main(String[] args) {
        GraphicObjectViewFactory.FACTORY.installView(CircleObject.class, new CircleObjectView());
        GraphicObjectViewFactory.FACTORY.installView(RectangleObject.class, new RectangleObjectView());
        GraphicObjectViewFactory.FACTORY.installView(ImageObject.class, new ImageObjectView());

        HistoryCommandHandler commandHandler = new HistoryCommandHandler();
        CommandInterpreter interpreter = new CommandInterpreter(commandHandler);

        MainFrame.setup(interpreter);
    }

}
