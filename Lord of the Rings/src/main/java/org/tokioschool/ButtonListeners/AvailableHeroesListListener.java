package org.tokioschool.ButtonListeners;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import org.tokioschool.AppView;

/**
 * The type Available heroes list listener.
 */
public class AvailableHeroesListListener implements EventHandler<MouseEvent> {
    private final AppView view;

    /**
     * Instantiates a new Available heroes list listener.
     *
     * @param view the view
     */
    public AvailableHeroesListListener(AppView view) {
        this.view = view;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (view.getLeftArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem() == null) {
            view.getLeftArmyPane().getTopListPane().getButtonDelete().setDisable(true);
            return;
        }

        view.getLeftArmyPane().getTopListPane().getButtonDelete().setDisable(false);
    }
}
