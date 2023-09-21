package org.tokioschool;

import javafx.application.Application;
import javafx.stage.Stage;
import org.tokioschool.model.AppModel;

public class AppMain extends Application{


    @Override
    public void start(Stage stage) {
        AppModel model = new AppModel();
        AppView view = new AppView(stage);
        AppController controller = new AppController(model, view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}