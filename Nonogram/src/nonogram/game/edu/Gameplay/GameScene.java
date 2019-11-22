package nonogram.game.edu.Gameplay;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nonogram.game.edu.ImageProcessing.Plansza;


public class GameScene{

    Stage window;
    Canvas canvas;

    public GameScene(Stage window) throws Exception {
        this.window = window;
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(this.getClass().getResource("GameplaySceneLayout.fxml"));
        BorderPane root = Loader.load();
        createBoard(root);
        window.setScene(new Scene(root, 700, 700)); //TEMP

    }

    private void createBoard(BorderPane root){
        Plansza p = new Plansza(15); //15 size of plansza
        p.testowaPlansza("piesek");
        int BLOCK_SIZE = 40;
        canvas = new Canvas();
        canvas.setWidth(BLOCK_SIZE*p.rozmiar);
        canvas.setHeight(BLOCK_SIZE*p.rozmiar);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        net(gc, BLOCK_SIZE, canvas, p);
        gc.setFill(Color.BLACK); // options editable
        canvas.setOnMouseClicked(e -> {
            int x = (int) e.getX();
            int y = (int) e.getY();
            int countX = 0, countY = 0;
            while ( x > 0 || y > 0){
                x = x - BLOCK_SIZE;
                if(x > 0){
                    countX++;
                }
                y = y - BLOCK_SIZE;
                if(y > 0){
                    countY++;
                }
            }
            gc.fillRect(countX*BLOCK_SIZE, countY*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            System.out.println(e.getX() + " " + e.getY());
        });

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

        root.setCenter(canvas);
    }

    private void net(GraphicsContext gc, int BLOCK_SIZE, Canvas canvas, Plansza p){
        gc.setStroke(Color.PINK);
        gc.setLineWidth(2.0);
        for(int i = 0; i <= p.rozmiar; i++){
            gc.strokeLine(0, i*BLOCK_SIZE, canvas.getWidth(), i*BLOCK_SIZE);
            gc.strokeLine(i*BLOCK_SIZE, 0, i*BLOCK_SIZE, canvas.getHeight());
        }
    }

    @FXML
    public void drawSquare(GraphicsContext gc, int BLOCK_SIZE, Canvas canvas, Plansza p){

    }



}
