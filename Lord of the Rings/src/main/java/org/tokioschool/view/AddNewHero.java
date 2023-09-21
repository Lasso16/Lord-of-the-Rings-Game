package org.tokioschool.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.tokioschool.utils.ComboBoxRaces;

import java.util.Objects;

public class AddNewHero extends GridPane {
    private Label nameLabel, raceLabel, healthLabel, armorLabel;
    private TextField nameTF, healthTF, armorTF;
    private ComboBox raceCB;
    private Button cancelButton, saveButton;
    private Stage stage;
    private Scene scene;


    public AddNewHero() {
        super();
        initComponents();


    }

    private void initComponents() {
        nameLabel = new Label("Nombre: ");
        raceLabel = new Label("Raza: ");
        healthLabel = new Label("Salud: ");
        armorLabel = new Label("Armadura:");

        nameTF = new TextField();
        raceCB = new ComboBox<>();
        // raceCB.setPromptText("Selecciona una raza");


        healthTF = new TextField();
        healthTF.setPromptText("Min. 100 - Máx. 200");
        armorTF = new TextField();
        armorTF.setPromptText("Min. 10 - Máx. 40");


        saveButton = new Button("Guardar");
        saveButton.setUserData("save hero");
        cancelButton = new Button("Cancelar");
        cancelButton.setUserData("cancel hero");


        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(cancelButton, saveButton);

        setHgap(2);
        setVgap(50);
        setPadding(new Insets(10, 10, 10, 10));
        add(nameLabel, 0, 0);
        add(nameTF, 1, 0);
        add(raceLabel, 0, 1);
        add(raceCB, 1, 1);
        add(healthLabel, 0, 2);
        add(healthTF, 1, 2);
        add(armorLabel, 0, 3);
        add(armorTF, 1, 3);
        add(buttonBox, 0, 4, 2, 1);
    }

    /**
     * Opens the panel to add a new available hero.
     */
    public void openDialog() {
        if (stage == null) {
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuevo Héroe");
            stage.setResizable(false);
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/LOTR icon.png"))));
            scene = new Scene(this);
            stage.setScene(scene);
            raceCB.setItems(ComboBoxRaces.heroRaces());


        }
        raceCB.getSelectionModel().clearSelection();
        raceCB.setPromptText("Selecciona una raza");
        stage.showAndWait();
    }

    /**
     * Closes the new character window.
     */
    public void closeDialog() {
        deleteTextFields();
        stage.close();
    }

    public void deleteTextFields() {
        nameTF.setText("");
        raceCB.getSelectionModel().clearSelection();
        healthTF.setText("");
        armorTF.setText("");
    }


    public TextField getNameTF() {
        return nameTF;
    }

    public ComboBox getRaceCB() {
        return raceCB;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public TextField getHealthTF() {
        return healthTF;
    }

    public TextField getArmorTF() {
        return armorTF;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
