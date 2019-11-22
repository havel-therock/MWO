package nonogram.game.edu.Menu;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import nonogram.game.edu.Gameplay.GameScene;
import nonogram.game.edu.Gameplay.GameplayScene;

import java.lang.reflect.Executable;


public class MainMenu extends Application {

    Stage window;
    Scene MenuScene, scene2, scene3, scene4, scene5, scene6,scene7, scene8;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;

        //Layout 1 - Menu
        HBox Menu = new HBox();
        Menu.setAlignment(Pos.TOP_CENTER);
        Button buttonNowaGra = new Button("Nowa Gra");
        buttonNowaGra.setOnAction(e -> window.setScene(scene2));
        Button buttonWczytajGre = new Button("Wczytaj Gre");
        buttonWczytajGre.setOnAction(e -> window.setScene(scene3));
        Button buttonStatystyki = new Button("Statystyki");
        buttonStatystyki.setOnAction(e -> window.setScene(scene7));
        Button buttonOpcjeRozgrywki = new Button("Opcje rozgrywki");
        Button buttonSzybkaGra = new Button("Szybka gra");
        buttonSzybkaGra.setOnAction(e -> {
            try {
                new GameScene(window);
            }catch (Exception ex){

            }
        });
        buttonOpcjeRozgrywki.setOnAction(e -> window.setScene(scene8));
        Menu.getChildren().addAll(buttonNowaGra,buttonWczytajGre,buttonStatystyki, buttonOpcjeRozgrywki, buttonSzybkaGra);
        Menu.setPadding(new Insets(10, 40, 10, 50));
        Menu.setSpacing(15);
        MenuScene = new Scene(Menu, 500, 500);


        // Layout 2 Nowa gra
        HBox NowaGra = new HBox();
        Button buttonPowrotdoMenu1 = new Button("Powrót do Menu");
        buttonPowrotdoMenu1.setOnAction(e -> window.setScene(MenuScene));
        Button buttonWyborRozmiaru = new Button("Wybór rozmiaru planszy");
        buttonWyborRozmiaru.setOnAction(e -> window.setScene(scene4));
        NowaGra.getChildren().addAll(buttonPowrotdoMenu1,buttonWyborRozmiaru);
        NowaGra.setPadding(new Insets(10, 40, 10, 90));
        NowaGra.setSpacing(15);
        scene2 = new Scene(NowaGra, 500, 500);

        //Layout 3 Wczytaj gre
        HBox WczytajGre = new HBox();
        Button buttonPowrotdoMenu2 = new Button("Powrót do Menu");
        buttonPowrotdoMenu2.setOnAction(e -> window.setScene(MenuScene));
        WczytajGre.getChildren().addAll(buttonPowrotdoMenu2);
        WczytajGre.setPadding(new Insets(10, 10, 10, 200));
        scene3 = new Scene(WczytajGre, 500, 500);


        //Layout 4 Statystyki
        HBox Statystyki = new HBox(20);
        Button buttonPowrotdoMenu3 = new Button("Powrót do Menu");
        buttonPowrotdoMenu3.setOnAction(e -> window.setScene(MenuScene));
        Statystyki.getChildren().addAll(buttonPowrotdoMenu3);
        Statystyki.setPadding(new Insets(10, 10, 10, 200));
        scene7 = new Scene(Statystyki, 500, 500);

        //Layout 5 Opcje rozgrywki
        HBox OpcjeRozgrywki = new HBox(20);
        Button buttonPowrotdoMenu4 = new Button("Powrót do Menu");
        buttonPowrotdoMenu4.setOnAction(e -> window.setScene(MenuScene));
        OpcjeRozgrywki.getChildren().addAll(buttonPowrotdoMenu4);
        OpcjeRozgrywki.setPadding(new Insets(10, 10, 10, 200));
        scene8 = new Scene(OpcjeRozgrywki, 500, 500);

        //Layout 6 Wybór rozmiaru planszy
        HBox WyborRozmiaru = new HBox();
        Button buttonWczytanieObrazka = new Button("Wczytanie obrazka");
        buttonWczytanieObrazka.setOnAction(e -> window.setScene(scene6));
        Button buttonLosowanieObrazka = new Button("Losowanie obrazka");
        buttonLosowanieObrazka.setOnAction(e -> window.setScene(scene6));
        Button buttonPowrotdoMenu5 = new Button("Powrót do Menu");
        buttonPowrotdoMenu5.setOnAction(e -> window.setScene(MenuScene));
        WyborRozmiaru.getChildren().addAll(buttonWczytanieObrazka, buttonLosowanieObrazka, buttonPowrotdoMenu5);
        WyborRozmiaru.setPadding(new Insets(10, 100, 10, 100));
        WyborRozmiaru.setSpacing(15);
        scene4 = new Scene(WyborRozmiaru, 500, 500);

        //Layout 7 Wczytaj obrazek
        HBox WczytajObrazek = new HBox();
        Button buttonPowrotdoMenu6 = new Button("Powrót do Menu");
        buttonPowrotdoMenu6.setOnAction(e -> window.setScene(MenuScene));
        WczytajObrazek.getChildren().addAll(buttonPowrotdoMenu6);
        WczytajObrazek.setPadding(new Insets(10, 10, 10, 200));
        scene6 = new Scene(WczytajObrazek, 500, 500);
        //Layout 8 Losuj Obrazek
        HBox LosujObrazek = new HBox(20);
        Button buttonPowrotdoMenu7 = new Button("Powrót do Menu");
        buttonPowrotdoMenu7.setOnAction(e -> window.setScene(MenuScene));
        LosujObrazek.setPadding(new Insets(10, 10, 10, 200));
        scene6 = new Scene(LosujObrazek, 500, 500);


        //Display scene 1 at first
        window.setScene(MenuScene);
        window.setTitle("Nonogram");
        window.show();
    }

}
