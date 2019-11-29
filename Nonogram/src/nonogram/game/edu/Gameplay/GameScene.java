package nonogram.game.edu.Gameplay;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GameScene{

    Stage window;
    Scene scene, menu;
    Canvas canvas;
    GraphicsContext gc;
    GameSettings gs;


    public GameScene(Stage window, GameSettings gs, Scene menu) throws Exception {
        this.menu = menu;
        this.window = window;
        this.gs = gs;
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(this.getClass().getResource("GameplaySceneLayout.fxml"));
        BorderPane root = Loader.load();
        boardInit(root);
        resizeBoard();
        updateBoard();

    }

    private void boardInit(BorderPane root){
        canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        scene = new Scene(root);
        window.setScene(scene);

        setBoardSize();
        plainBoard();
    }

    private void setBoardSize(){
        int min  = (int) Math.min(window.getWidth() - 50, window.getHeight() - 100); //offset 50 to not put canvas over buttons
        //calculate offset for info
        // get max of two offsets = maxoff
        //offset == number in row?
        int blockInCanvas = gs.p.rozmiar + 10;//maxoff;
        gs.BLOCK_SIZE =  min/blockInCanvas;//gs.p.rozmiar; // divide over maxoff + gs.p.rozmiar
        canvas.setWidth(gs.BLOCK_SIZE * blockInCanvas);//gs.p.rozmiar); // + width offset for numbers with informations
        canvas.setHeight(gs.BLOCK_SIZE * blockInCanvas);//gs.p.rozmiar); // + height offset for numbers with informations
    }

    private void plainBoard(){
        gc.setFill(gs.bgColor);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        net();
    }

    private void resizeBoard(){
        ChangeListener<Number> stageSizeListener = ((observable, oldValue, newValue) ->{
            setBoardSize();
            plainBoard();
            drawCurrentSate();
            //wczytaj dotychczasowy postęp
            //draw info
        });
        window.widthProperty().addListener(stageSizeListener);
        window.heightProperty().addListener(stageSizeListener);

    }

    private void drawCurrentSate(){
        for(int i = 0; i < gs.p.rozmiar; i++){
            for(int j = 0; j < gs.p.rozmiar; j++){
                drawSquare(i, j);
            }
        }
        net();
    }


    private void updateBoard(){
        canvas.setOnMouseClicked(e -> {
            int x = (int) e.getX();
            int y = (int) e.getY();
            int countX = 0, countY = 0;
            while ( x > 0 || y > 0){
                x = x - gs.BLOCK_SIZE;
                if(x > 0){
                    countX++;
                }
                y = y - gs.BLOCK_SIZE;
                if(y > 0){
                    countY++;
                }
            }

            updateSquare(countX, countY);
            net();
            System.out.println(e.getX() + " " + e.getY());
            if(checkWin()){
                System.out.println("Gratulacje wygrałeś");
                window.setScene(menu);
            }
        });
    }

    private boolean checkWin(){
        for(int i = 0; i < gs.p.rozmiar; i++){
            for (int j = 0; j < gs.p.rozmiar; j++){
                if(gs.p.wypelnienie[i][j]){
                    if(gs.p.fillState[i][j] != 1){
                        return false;
                    }
                }else{
                    if(gs.p.fillState[i][j] == 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void net(){
        gc.setStroke(gs.netColor);
        gc.setLineWidth(gs.netWidth);
        for(int i = 0; i <= gs.p.rozmiar; i++){
            gc.strokeLine(0, i*gs.BLOCK_SIZE, canvas.getWidth(), i*gs.BLOCK_SIZE);
            gc.strokeLine(i*gs.BLOCK_SIZE, 0, i*gs.BLOCK_SIZE, canvas.getHeight());
        }
    }

    private void updateSquare(int countX, int countY){
        if(!(countX >= gs.p.rozmiar || countY >= gs.p.rozmiar)){
            switch (gs.p.fillState[countX][countY]){
                case 0:
                    gc.setFill(gs.squareColor);
                    gc.fillRect(countX*gs.BLOCK_SIZE, countY*gs.BLOCK_SIZE, gs.BLOCK_SIZE, gs.BLOCK_SIZE);
                    gs.p.fillState[countX][countY] = 1;
                    break;
                case 1:
                    double x1 = countX*gs.BLOCK_SIZE, y1 =countY*gs.BLOCK_SIZE;
                    gc.setFill(gs.bgColor);
                    gc.fillRect(x1, y1, gs.BLOCK_SIZE, gs.BLOCK_SIZE);

                    gc.setStroke(gs.crossColor);
                    gc.setLineWidth(gs.crossWidth);
                    gc.strokeLine(x1 + gs.crossWidth, y1 + gs.crossWidth, x1 + gs.BLOCK_SIZE - gs.crossWidth, y1 + gs.BLOCK_SIZE - gs.crossWidth);
                    gc.strokeLine(x1 + gs.BLOCK_SIZE - gs.crossWidth, y1 + gs.crossWidth, x1 + gs.crossWidth, y1 + gs.BLOCK_SIZE - gs.crossWidth);
                    gs.p.fillState[countX][countY] = 2;
                    break;
                case 2:
                    gc.setFill(gs.bgColor);
                    gc.fillRect(countX*gs.BLOCK_SIZE, countY*gs.BLOCK_SIZE, gs.BLOCK_SIZE, gs.BLOCK_SIZE);
                    gs.p.fillState[countX][countY] = 0;
                    break;

                default:
                    break;
            }
        }
    }

    private void drawSquare(int countX, int countY){
        switch (gs.p.fillState[countX][countY]){
            case 1:
                gc.setFill(gs.squareColor);
                gc.fillRect(countX*gs.BLOCK_SIZE, countY*gs.BLOCK_SIZE, gs.BLOCK_SIZE, gs.BLOCK_SIZE);
                break;
            case 2:
                double x1 = countX*gs.BLOCK_SIZE, y1 = countY*gs.BLOCK_SIZE;
                gc.setFill(gs.bgColor);
                gc.fillRect(x1, y1, gs.BLOCK_SIZE, gs.BLOCK_SIZE);

                gc.setStroke(gs.crossColor);
                gc.setLineWidth(gs.crossWidth);
                gc.strokeLine(x1 + gs.crossWidth, y1 + gs.crossWidth, x1 + gs.BLOCK_SIZE - gs.crossWidth, y1 + gs.BLOCK_SIZE - gs.crossWidth);
                gc.strokeLine(x1 + gs.BLOCK_SIZE - gs.crossWidth, y1 + gs.crossWidth, x1 + gs.crossWidth, y1 + gs.BLOCK_SIZE - gs.crossWidth);
                break;
            case 0:
                gc.setFill(gs.bgColor);
                gc.fillRect(countX*gs.BLOCK_SIZE, countY*gs.BLOCK_SIZE, gs.BLOCK_SIZE, gs.BLOCK_SIZE);
                break;

            default:
                break;
        }
    }

    private void drawInfo(){
        gc.setStroke(gs.infoColor);
        gc.setFont(new Font("Verdana", 20));
        gc.strokeText("HELLOO WORLD !!!! YEEEAH", 300, 322);
    }

}