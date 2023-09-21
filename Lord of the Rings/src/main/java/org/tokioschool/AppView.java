package org.tokioschool;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.tokioschool.view.*;

import java.util.Objects;

/**
 * The type App view.
 */
public class AppView {
    private BorderPane borderPane;
    private TopPane topPane;
    private CenterPane centerPane;
    private BotPane botPane;
    private ArmyPane leftArmyPane, rightArmyPane;
    private AddNewHero addNewHeroPane;
    private AddNewBeast addNewBeastPane;
    private FightPane fightPane;

    /**
     * Instantiates a new App view.
     *
     * @param stage the stage
     */
    public AppView(Stage stage) {
        initComponents();
        var scene = new Scene(borderPane, 704, 600);
        scene.setOnMouseClicked(e -> clearAllSelections());
        stage.setMinHeight(450);
        stage.setMinWidth(650);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/LOTR icon.png"))));
        stage.setTitle("LOTR Battle for Middle-Earth");
        stage.show();
    }

    private void initComponents() {
        borderPane = new BorderPane();
        topPane = new TopPane();
        BorderPane.setMargin(topPane, new Insets(10, 0, 0, 0));
        centerPane = new CenterPane();
        botPane = new BotPane();
        BorderPane.setMargin(botPane, new Insets(20, 0, 10, 0));
        BorderPane.setAlignment(botPane, Pos.CENTER);
        leftArmyPane = new ArmyPane();
        BorderPane.setMargin(leftArmyPane, new Insets(10, 0, 0, 10));
        rightArmyPane = new ArmyPane();
        BorderPane.setMargin(rightArmyPane, new Insets(10, 10, 0, 0));

        addNewHeroPane = new AddNewHero();
        addNewBeastPane = new AddNewBeast();

        fightPane = new FightPane();

        borderPane.setTop(topPane);
        borderPane.setCenter(centerPane);
        borderPane.setBottom(botPane);
        borderPane.setLeft(leftArmyPane);
        borderPane.setRight(rightArmyPane);
    }

    /**
     * Enables or disables the delete button of available characters.
     *
     * @param b Allows the button
     */
    public void canDelete(boolean b) {
        leftArmyPane.getTopListPane().getButtonDelete().setDisable(!b);
        rightArmyPane.getTopListPane().getButtonDelete().setDisable(!b);
    }

    /**
     * Clears all the selection of every list views.
     */
    private void clearAllSelections() {
        leftArmyPane.getTopListPane().getListOfCharacters().getSelectionModel().clearSelection();
        leftArmyPane.getBotListPane().getListOfCharacters().getSelectionModel().clearSelection();
        rightArmyPane.getTopListPane().getListOfCharacters().getSelectionModel().clearSelection();
        rightArmyPane.getBotListPane().getListOfCharacters().getSelectionModel().clearSelection();
    }

    /**
     * Gets bot pane.
     *
     * @return the bot pane
     */
    public BotPane getBotPane() {
        return botPane;
    }

    /**
     * Gets left army pane.
     *
     * @return the left army pane
     */
    public ArmyPane getLeftArmyPane() {
        return leftArmyPane;
    }

    /**
     * Gets right army pane.
     *
     * @return the right army pane
     */
    public ArmyPane getRightArmyPane() {
        return rightArmyPane;
    }

    /**
     * Gets add new hero pane.
     *
     * @return the add new hero pane
     */
    public AddNewHero getAddNewHeroPane() {
        return addNewHeroPane;
    }

    /**
     * Gets add new beast pane.
     *
     * @return the add new beast pane
     */
    public AddNewBeast getAddNewBeastPane() {
        return addNewBeastPane;
    }

    /**
     * Gets fight pane.
     *
     * @return the fight pane
     */
    public FightPane getFightPane() {
        return fightPane;
    }

}
