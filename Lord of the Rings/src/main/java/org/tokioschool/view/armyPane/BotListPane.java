package org.tokioschool.view.armyPane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.tokioschool.model.characters.Character;

/**
 * The type Bot list pane.
 */
public class BotListPane extends VBox {
    private ListView<Character> listOfCharacters;
    private ButtonBar buttonBar;
    private Button buttonUp, buttonDown, buttonDelete;

    /**
     * Instantiates a new Bot list pane.
     */
    public BotListPane() {
        super();
        initComponents();
    }

    private void initComponents() {
        listOfCharacters = new ListView<>();
        buttonBar = new ButtonBar();
        buttonUp = new Button("Subir");
        buttonUp.setUserData("up");
        buttonDown = new Button("Bajar");
        buttonDown.setUserData("down");
        buttonDelete = new Button("Eliminar");
        buttonDelete.setUserData("delete");

        buttonBar.getButtons().addAll(buttonUp, buttonDown, buttonDelete);

        setSpacing(10);
        setPrefHeight(200);
        setPrefWidth(292);
        setAlignment(Pos.CENTER);

        getChildren().addAll(listOfCharacters, buttonBar);
    }


    /**
     * Gets list of characters.
     *
     * @return the list of characters
     */
    public ListView<Character> getListOfCharacters() {
        return listOfCharacters;
    }


    public Button getButtonUp() {
        return buttonUp;
    }



    /**
     * Gets button down.
     *
     * @return the button down
     */
    public Button getButtonDown() {
        return buttonDown;
    }


    /**
     * Gets button delete.
     *
     * @return the button delete
     */
    public Button getButtonDelete() {
        return buttonDelete;
    }

}
