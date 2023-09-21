package org.tokioschool.view;


import javafx.scene.layout.VBox;
import org.tokioschool.view.armyPane.BotListPane;
import org.tokioschool.view.armyPane.TopListPane;

public class ArmyPane extends VBox {
    private TopListPane topListPane;
    private BotListPane botListPane;

    public ArmyPane(){
        super();
        initComponents();
    }

    private void initComponents() {
        topListPane = new TopListPane();
        botListPane = new BotListPane();

        setSpacing(50);
        setPrefHeight(638);
        setPrefWidth(311);


        getChildren().addAll(topListPane, botListPane);

    }

    public TopListPane getTopListPane() {
        return topListPane;
    }

    public void setTopListPane(TopListPane topListPane) {
        this.topListPane = topListPane;
    }

    public BotListPane getBotListPane() {
        return botListPane;
    }

    public void setBotListPane(BotListPane botListPane) {
        this.botListPane = botListPane;
    }
}
