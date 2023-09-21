package org.tokioschool.ButtonListeners;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import org.tokioschool.AppController;
import org.tokioschool.AppView;
import org.tokioschool.DAO.CharacterDAO;
import org.tokioschool.model.AppModel;
import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Goblin;
import org.tokioschool.model.characters.beasts.Orc;
import org.tokioschool.model.characters.heroes.Elf;
import org.tokioschool.model.characters.heroes.Hobbit;
import org.tokioschool.model.characters.heroes.Human;

/**
 * The type New character listeners.
 */
public class NewCharacterListeners implements EventHandler<ActionEvent> {
    private final AppView view;
    private final AppModel model;
    private final AppController controller;
    private final CharacterDAO db;

    /**
     * Instantiates a new New character listeners.
     *
     * @param view       the view
     * @param model      the model
     * @param controller the controller
     * @param db         the db
     */
    public NewCharacterListeners(AppView view, AppModel model, AppController controller, CharacterDAO db) {
        this.view = view;
        this.model = model;
        this.controller = controller;
        this.db = db;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String userData = node.getUserData().toString();

        switch (userData) {
            case "save hero":
                saveHero();
                break;
            case "save beast":
                saveBeast();
                break;
            case "cancel hero":
                cancelAddHero();
                break;
            case "cancel beast":
                cancelAddBeast();
            default:
                break;
        }
    }


    private void saveHero() {
        Character character = null;
        String name = view.getAddNewHeroPane().getNameTF().getText();
        String race = (String) view.getAddNewHeroPane().getRaceCB().getSelectionModel().getSelectedItem();

        String healthInput = view.getAddNewHeroPane().getHealthTF().getText();
        int health = 0;

        String armorInput = view.getAddNewHeroPane().getArmorTF().getText();
        int armor = 0;

        if (name.isBlank() || healthInput.isBlank() || armorInput.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Rellene todos los campos.").show();
            return;
        }
        if (race == null) {
            new Alert(Alert.AlertType.ERROR, "Seleccione una raza.").show();
            return;
        }
        if (healthInput.matches("^(1\\d\\d|200)$") && armorInput.matches("^(1\\d|2[0-9]|30)$")) {
            health = Integer.parseInt(healthInput);
            armor = Integer.parseInt(armorInput);
        } else {
            new Alert(Alert.AlertType.ERROR, "Ponga un número dentro de los límites.").show();
            return;
        }


        switch (race) {
            case "Humano":
                character = new Human(name, health, armor);
                break;
            case "Elfo":
                character = new Elf(name, health, armor);
                break;
            case "Hobbit":
                character = new Hobbit(name, health, armor);
                break;
            default:
                break;
        }
        controller.addCharacterDB(character);
        model.getAvailableHeroes().addCharacter(character);
        controller.showCharacters();

        cancelAddHero();
    }


    private void saveBeast() {
        Character character = null;
        String name = view.getAddNewBeastPane().getNameTF().getText();
        String race = (String) view.getAddNewBeastPane().getRaceCB().getSelectionModel().getSelectedItem();
        String healthInput = view.getAddNewBeastPane().getHealthTF().getText();
        int health = 0;
        String armorInput = view.getAddNewBeastPane().getArmorTF().getText();
        int armor = 0;

        if (name.isBlank() || healthInput.isBlank() || armorInput.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Rellene todos los campos.").show();
            return;
        }
        if (race == null) {
            new Alert(Alert.AlertType.ERROR, "Seleccione una raza.").show();
            return;
        }
        if (healthInput.matches("^(1\\d\\d|200)$") && armorInput.matches("^(1\\d|2[0-9]|30)$")) {
            health = Integer.parseInt(healthInput);
            armor = Integer.parseInt(armorInput);
        } else {
            new Alert(Alert.AlertType.ERROR, "Ponga un número dentro de los límites.").show();
            return;
        }


        switch (race) {
            case "Orco":
                character = new Orc(name, health, armor);
                break;
            case "Trasgo":
                character = new Goblin(name, health, armor);
                break;
            default:
                break;
        }

        controller.addCharacterDB(character);
        model.getAvailableBeasts().addCharacter(character);
        controller.showCharacters();

        cancelAddBeast();
    }

    private void cancelAddHero() {
        view.getAddNewHeroPane().closeDialog();
        controller.showCharacters();
    }

    private void cancelAddBeast() {
        view.getAddNewBeastPane().closeDialog();
        controller.showCharacters();
    }
}
