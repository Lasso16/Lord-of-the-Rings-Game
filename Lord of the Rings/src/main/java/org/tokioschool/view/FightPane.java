package org.tokioschool.view;


import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Modality;
import javafx.stage.Stage;


import java.util.Objects;

public class FightPane extends AnchorPane {

    private TextArea fightConsole;

    private Stage stage;
    private Scene scene;


    public FightPane() {
        super();
        initComponents();
    }

    private void initComponents() {
        fightConsole = new TextArea();
        fightConsole.setEditable(false);

        AnchorPane.setTopAnchor(fightConsole, 0.0);
        AnchorPane.setBottomAnchor(fightConsole, 0.0);
        AnchorPane.setLeftAnchor(fightConsole, 0.0);
        AnchorPane.setRightAnchor(fightConsole, 0.0);

        getChildren().add(fightConsole);
    }

    public void openFightPane() {
        if (stage == null) {
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Batalla");
            stage.setResizable(false);
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/LOTR icon.png"))));
            scene = new Scene(this, 400, 500);
            stage.setScene(scene);
        }
        stage.showAndWait();
    }

    public TextArea getFightConsole() {
        return fightConsole;
    }
}
