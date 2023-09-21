package org.tokioschool.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.tokioschool.utils.ComboBoxRaces;

import java.util.Objects;

/**
 * The type Add new beast.
 */
public class AddNewBeast extends GridPane {
    private Label nameLabel, raceLabel, healthLabel, armorLabel;
    private TextField nameTF, healthTF, armorTF;
    private ComboBox raceCB;
    private Button cancelButton, saveButton;
    private Stage stage;
    private Scene scene;


    /**
     * Instantiates a new Add new beast.
     */
    public AddNewBeast() {
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
        raceCB.setPromptText("Selecciona una raza");


        healthTF = new TextField();
        healthTF.setPromptText("Min. 100 - Máx. 200");
        armorTF = new TextField();
        armorTF.setPromptText("Min. 10 - Máx. 40");


        saveButton = new Button("Guardar");
        saveButton.setUserData("save beast");
        cancelButton = new Button("Cancelar");
        cancelButton.setUserData("cancel beast");


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
     * Opens the panel to add a new available beast
     */
    public void openDialog() {
        if (stage == null) {
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nueva Bestia");
            stage.setResizable(false);
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/LOTR icon.png"))));
            scene = new Scene(this);
            stage.setScene(scene);
            raceCB.setItems(ComboBoxRaces.beastRaces());

        }
        stage.showAndWait();
    }

    /**
     * Closes the new character window.
     */
    public void closeDialog() {
        deleteTextFields();
        stage.close();
    }

    private void deleteTextFields() {
        nameTF.setText("");
        raceCB.getSelectionModel().clearSelection();
        healthTF.setText("");
        armorTF.setText("");
    }


    /**
     * Gets name tf.
     *
     * @return the name tf
     */
    public TextField getNameTF() {
        return nameTF;
    }

    /**
     * Gets race cb.
     *
     * @return the race cb
     */
    public ComboBox getRaceCB() {
        return raceCB;
    }

    /**
     * Gets save button.
     *
     * @return the save button
     */
    public Button getSaveButton() {
        return saveButton;
    }

    /**
     * Gets health tf.
     *
     * @return the health tf
     */
    public TextField getHealthTF() {
        return healthTF;
    }

    /**
     * Gets armor tf.
     *
     * @return the armor tf
     */
    public TextField getArmorTF() {
        return armorTF;
    }

    /**
     * Gets cancel button.
     *
     * @return the cancel button
     */
    public Button getCancelButton() {
        return cancelButton;
    }
}
