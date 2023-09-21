package org.tokioschool.ButtonListeners;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import org.tokioschool.AppView;

/**
 * The type Available beasts list listener.
 */
public class AvailableBeastsListListener implements EventHandler<MouseEvent> {
    private final AppView view;

    /**
     * Instantiates a new Available beasts list listener.
     *
     * @param view the view
     */
    public AvailableBeastsListListener(AppView view) {
        this.view = view;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (view.getRightArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem() == null) {
            view.getRightArmyPane().getTopListPane().getButtonDelete().setDisable(true);
            return;
        }

        view.getRightArmyPane().getTopListPane().getButtonDelete().setDisable(false);
    }
}
