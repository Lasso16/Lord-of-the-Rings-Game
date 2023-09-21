package org.tokioschool.view.armyPane;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.tokioschool.model.characters.Character;

/**
 * The type Top list pane.
 */
public class TopListPane extends VBox {
    private ListView<Character> listOfCharacters;
    private ButtonBar buttonBar;
    private Button buttonNew, buttonAdd, buttonDelete;

    /**
     * Instantiates a new Top list pane.
     */
    public TopListPane() {
        super();
        initComponents();
    }

    private void initComponents() {
        listOfCharacters = new ListView<>();
        buttonBar = new ButtonBar();
        buttonNew = new Button("Nuevo");
        buttonNew.setUserData("new");
        buttonAdd = new Button("Añadir");
        buttonAdd.setUserData("add");
        buttonDelete = new Button("Eliminar");
        buttonDelete.setUserData("deleteDB");
        buttonDelete.setDisable(true);

        buttonBar.getButtons().addAll(buttonDelete, buttonNew, buttonAdd);



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

    /**
     * Gets button new.
     *
     * @return the button new
     */
    public Button getButtonNew() {
        return buttonNew;
    }

    /**
     * Gets button add.
     *
     * @return the button add
     */
    public Button getButtonAdd() {
        return buttonAdd;
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
