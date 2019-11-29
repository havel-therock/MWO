package nonogram.game.edu.Gameplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sun.awt.X11.XButtonPeer;


public class GameplayScene  extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(this.getClass().getResource("GameplaySceneLayout.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("GameplaySceneLayout.fxml"));
        BorderPane root = Loader.load();
        //root.getLeft().setStyle();
        //root.getRight().autosize();
        Button ext = (Button) root.getTop().lookup("exitBtn");
        ext.autosize();
        //ext.setText("Zmiana JOŁ");
        //canvas.setOn
         /*
        canvas.setOnMouseClicked(e -> {
            if(e.isPrimaryButtonDown()){
                gc.setFill(Color.BLUEVIOLET);
                gc.fillRect(e.getX(),e.getY(),100, 100);
                System.out.println("Left");
            }else{
                if(e.isSecondaryButtonDown()){
                    System.out.println("Right");
                    gc.setFill(Color.BLACK);
                    gc.fillRect(e.getX(),e.getY(),100, 100);
                }
            }
        });*/
        // Get the graphics context of the canvas

        // Draw a Text
        //gc.setStroke(Color.BLUEVIOLET);
        //gc.setFill(Color.BLUEVIOLET);
        //gc.strokeRect(0,0,canvas.getWidth(), canvas.getHeight());
        //gc.setFill(Color.YELLOW);
        //String t = "Hello Canvas";
        //gc.fillText(t, canvas.getWidth() / 2 , canvas.getHeight() / 2);

        // Set the Style-properties of the Pane
        /*canvas.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");*/

        // Add the Canvas to the Pane
        //root.setCenter(canvas);
        //root.getChildren().add(canvas);

        primaryStage.setTitle("Nonogram");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }




    //public static void main(String[] args) {
       // launch(args);
   // }
}
