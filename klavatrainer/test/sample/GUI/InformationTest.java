package sample.GUI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InformationTest {

    @Test
    void guiInformationKeepsConstructorValues() {
        GUIInformation info = new GUIInformation("black", "white", "36");
        assertEquals("black", info.getBackgroundColor());
        assertEquals("white", info.getFontColor());
        assertEquals("36", info.getFontSize());
    }

    @Test
    void guiInformationSettersChangeValues() {
        GUIInformation info = new GUIInformation("black", "white", "36");
        info.setBackgroundColor("white");
        info.setFontColor("black");
        info.setFontSize("24");
        assertEquals("white", info.getBackgroundColor());
        assertEquals("black", info.getFontColor());
        assertEquals("24", info.getFontSize());
    }

    @Test
    void trainingInformationHasDefaults() {
        TrainingInformation info = new TrainingInformation();
        assertTrue(info.getShowKeyboard());
        assertFalse(info.getShowKeyboardIfMistake());
        assertEquals("learning", info.getTypeOfTraining());
    }

    @Test
    void trainingInformationSettersChangeValues() {
        TrainingInformation info = new TrainingInformation();
        info.setShowKeyboard(false);
        info.SetShowKeyboardIfMistake(true);
        info.setTypeOfTraining("speed");
        assertFalse(info.getShowKeyboard());
        assertTrue(info.getShowKeyboardIfMistake());
        assertEquals("speed", info.getTypeOfTraining());
    }
}
