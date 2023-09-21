package org.tokioschool.ButtonListeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import org.tokioschool.AppController;
import org.tokioschool.AppView;
import org.tokioschool.DAO.CharacterDAO;
import org.tokioschool.model.AppModel;
import org.tokioschool.view.FightPane;

/**
 * The type Fight button listener.
 */
public class FightButtonListener implements EventHandler<ActionEvent> {
    private final AppView view;
    private final AppModel model;
    private final AppController controller;


    /**
     * Instantiates a new Fight button listener.
     *
     * @param view       the view
     * @param model      the model
     * @param controller the controller
     */
    public FightButtonListener(AppView view, AppModel model, AppController controller) {
        this.view = view;
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = view.getBotPane();
        fightButton();

    }

    private void fightButton() {
        controller.fight();
    }
}


