package org.tokioschool.view;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;


public class TopPane extends GridPane {
    private Label heroesLabel, beastsLabel;

    public TopPane() {
        super();
        initComponents();
    }

    private void initComponents() {
        heroesLabel = new Label("Héroes");
        heroesLabel.setFont(new Font(18));
        setHalignment(heroesLabel, HPos.CENTER);

        beastsLabel = new Label("Bestias");
        beastsLabel.setFont(new Font(18));
        setHalignment(beastsLabel, HPos.CENTER);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints row = new RowConstraints();
        row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        getColumnConstraints().addAll(column1, column2);
        getRowConstraints().add(row);
        add(heroesLabel, 0, 0);
        add(beastsLabel, 1, 0);
    }
}
