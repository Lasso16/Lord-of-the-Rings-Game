package org.tokioschool.ButtonListeners;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Node;
import org.tokioschool.AppController;
import org.tokioschool.AppView;
import org.tokioschool.DAO.CharacterDAO;
import org.tokioschool.model.AppModel;
import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.heroes.Hero;

import java.util.ArrayList;
import java.util.Collections;


/**
 * The type Heroes button listeners.
 */
public class HeroesButtonListeners implements EventHandler<ActionEvent> {
    private final AppView view;
    private final AppModel model;
    private final AppController controller;


    /**
     * Instantiates a new Heroes button listeners.
     *
     * @param view       the view
     * @param model      the model
     * @param controller the controller
     */
    public HeroesButtonListeners(AppView view, AppModel model, AppController controller) {
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
            default:
                break;
        }
    }

    private void addInTeam() {
        if (view.getLeftArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem() != null
                && model.getTeamHeroes().getTeam().size() < 5) {
            Hero hero1 = (Hero) view.getLeftArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
            model.getTeamHeroes().addCharacter(hero1);
            model.getAvailableHeroes().getAvailableCharacters().removeIf(hero2 -> hero2.getName().equalsIgnoreCase(hero1.getName()));

            controller.showCharacters();
        }
    }

    private void newCharacter() {
        view.getAddNewHeroPane().openDialog();
    }

    private void deleteItem() {
        if (view.getLeftArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem() != null) {
            Hero hero1 = (Hero) view.getLeftArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
            model.getAvailableHeroes().addCharacter(hero1);
            model.getTeamHeroes().getTeam().removeIf(hero2 -> hero2.getName().equalsIgnoreCase(hero1.getName()));
            controller.showCharacters();
        }
    }

    private void upCharacter() {
        Hero hero1 = (Hero) view.getLeftArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
        ArrayList<Character> team = model.getTeamHeroes().getTeam();

        for (int position = 0; position < team.size(); position++) {
            if (team.get(position).getName().equalsIgnoreCase(hero1.getName()) && position > 0) {
                Collections.swap(team, position, position - 1);
                break;
            }
        }

        controller.showCharacters();
    }


    private void downCharacter() {
        Hero hero1 = (Hero) view.getLeftArmyPane().getBotListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
        ArrayList<Character> team = model.getTeamHeroes().getTeam();

        for (int position = 0; position < team.size() - 1; position++) {
            if (team.get(position).getName().equalsIgnoreCase(hero1.getName())) {
                Collections.swap(team, position, position + 1);
                break;
            }
        }

        controller.showCharacters();
    }

    private void deleteFromDB() {
        Hero hero = (Hero) view.getLeftArmyPane().getTopListPane().getListOfCharacters().getSelectionModel().getSelectedItem();
        view.getLeftArmyPane().getTopListPane().getButtonDelete().setDisable(false);

        controller.deleteCharacterDB(hero);
        controller.reset();
    }

}

