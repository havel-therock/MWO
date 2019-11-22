package nonogram.game.edu.Menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuLayout.fxml"));
        primaryStage.setTitle("Nonogram");
        primaryStage.setScene(new Scene(root, 600, 525));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
