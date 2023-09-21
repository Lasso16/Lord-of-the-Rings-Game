package org.tokioschool.ButtonListeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import org.tokioschool.AppController;
import org.tokioschool.AppView;
import org.tokioschool.DAO.CharacterDAO;
import org.tokioschool.model.AppModel;
import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Beast;
import org.tokioschool.model.characters.heroes.Hero;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Beast button listeners.
 */
public class BeastButtonListeners implements EventHandler<ActionEvent> {
    private final AppView view;
    private final AppModel model;
    private final AppController controller;


    /**
     * Instantiates a new Beast button listeners.
     *
     * @param view       the view
     * @param model      the model
     * @param controller the controller
     */
    public BeastButtonListeners(AppView view, AppModel model, AppController controller) {
        this.view = view;
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String userData = node.getUserData().toString();
        switch (userData) {
            case "add":
                addInTeam();
                break;
            case "new":
                newCharacter();
                break;
            case "delete":
                deleteItem();
                break;
            case "up":
                upCharacter();
                break;
            case "down":
                downCharacter();
                break;
            case "deleteDB":
                deleteFromDB();
                break;
            default:
                break;
        }
    }


    private void addInTeam() {
        if (view.getRightArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem() != null
                && model.getTeamBeasts().getTeam().size() < 5) {
            Beast beast1 = (Beast) view.getRightArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
            model.getTeamBeasts().addCharacter(beast1);
            model.getAvailableBeasts().getAvailableCharacters().removeIf(beast2 -> beast2.getName().equalsIgnoreCase(beast1.getName()));
            controller.showCharacters();
        }
    }

    private void newCharacter() {
        view.getAddNewBeastPane().openDialog();
    }

    private void deleteItem() {
        if (view.getRightArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem() != null) {
            Beast beast1 = (Beast) view.getRightArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
            model.getAvailableBeasts().addCharacter(beast1);
            model.getTeamBeasts().getTeam().removeIf(beast2 -> beast2.getName().equalsIgnoreCase(beast1.getName()));
            controller.showCharacters();
        }
    }

    private void upCharacter() {
        Beast beast1 = (Beast) view.getRightArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
        ArrayList<Character> team = model.getTeamBeasts().getTeam();

        for (int position = 0; position < team.size(); position++) {
            if (team.get(position).getName().equalsIgnoreCase(beast1.getName()) && position > 0) {
                Collections.swap(team, position, position - 1);
                break;
            }
        }

        controller.showCharacters();
    }


    private void downCharacter() {
        Beast beast1 = (Beast) view.getRightArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
        ArrayList<Character> team = model.getTeamBeasts().getTeam();

        for (int position = 0; position < team.size() - 1; position++) {
            if (team.get(position).getName().equalsIgnoreCase(beast1.getName())) {
                Collections.swap(team, position, position + 1);
                break;
            }
        }

        controller.showCharacters();
    }

    private void deleteFromDB() {
        Beast beast = (Beast) view.getRightArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
        view.getRightArmyPane().getTopListPane().getButtonDelete().setDisable(false);

        controller.deleteCharacterDB(beast);
        controller.reset();
    }
}



