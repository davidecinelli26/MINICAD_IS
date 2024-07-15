package shapesMVC.specificcommand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shapesMVC.model.GraphicObject;
import shapesMVC.view.GraphicObjectPanel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCommandTest {

    private GraphicObject graphicObject;
    private GraphicObjectPanel panel;
    private CreateCommand createCommand;

    @BeforeEach
    public void setUp() {
        panel = GraphicObjectPanel.getInstance();
        panel.clear();
        graphicObject = panel.getRectangle();
        createCommand = new CreateCommand(graphicObject);
    }

    @Test
    public void testExecute() {
        assertFalse(panel.getGraphicObjects().containsValue(graphicObject));
        boolean result = createCommand.execute();
        assertTrue(panel.getGraphicObjects().containsValue(graphicObject));
        assertTrue(result);
    }

    @Test
    public void testUndo() {
        createCommand.execute();
        assertTrue(panel.getGraphicObjects().containsValue(graphicObject));
        boolean result = createCommand.undo();
        assertFalse(panel.getGraphicObjects().containsValue(graphicObject));
        assertTrue(result);
    }
}

