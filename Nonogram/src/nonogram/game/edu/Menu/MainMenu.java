package nonogram.game.edu.Menu;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.image.Image;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;


public class MainMenu extends Application {


    Stage window;
    Scene MenuScene, scene2, scene3, scene4, scene5, scene6,scene7, scene8;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent fxml = FXMLLoader.load(getClass().getResource("MainMenuLayout.fxml"));

        //Layout 1 - Menu
        VBox Menu = new VBox();

        Menu.setAlignment(Pos.CENTER);
        Button buttonNowaGra = new Button("Nowa Gra");
        buttonNowaGra.setOnAction(e -> window.setScene(scene2));
        Button buttonWczytajGre = new Button("Wczytaj Gre");
        buttonWczytajGre.setOnAction(e -> window.setScene(scene3));
        Button buttonStatystyki = new Button("Statystyki");
        buttonStatystyki.setOnAction(e -> window.setScene(scene7));
        Button buttonSzybkaGra = new Button("Szybka gra");
        buttonSzybkaGra.setOnAction(e -> {
            try {
                new GameScene(window, new GameSettings(), MenuScene);
            }catch (Exception ex){

            }
        });
        buttonSzybkaGra.setOnAction(e -> window.setScene(scene5));
        Menu.getChildren().addAll(buttonNowaGra,buttonWczytajGre,buttonStatystyki,  buttonSzybkaGra);
        Menu.setPadding(new Insets(10, 0, 0, 0));
        Menu.setSpacing(15);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        Menu.getStylesheets().add("nonogram/game/edu/Menu/Viper.css");
        MenuScene = new Scene(Menu, 800, 600);


        // Layout 2 Nowa gra
        VBox NowaGra = new VBox();
        NowaGra.setAlignment(Pos.CENTER);
        Button buttonPowrotdoMenu1 = new Button("Powrót do Menu");
        buttonPowrotdoMenu1.setOnAction(e -> window.setScene(MenuScene));
        Button buttonOpcjeRozgrywki = new Button("Opcje rozgrywki");
        buttonOpcjeRozgrywki.setOnAction(e -> window.setScene(scene8));
        Button buttonWyborRozmiaru = new Button("Wybór rozmiaru planszy");
        buttonWyborRozmiaru.setOnAction(e -> {
            try {

                Plansza ps  = new Plansza(10);

                GameSettings gs = new GameSettings();
                gs.p = ps;
                new GameScene(window, gs, MenuScene);
            }catch (Exception ex){

            }

        });
        NowaGra.getChildren().addAll(buttonPowrotdoMenu1,buttonWyborRozmiaru,buttonOpcjeRozgrywki);
        NowaGra.setPadding(new Insets(10, 0, 0, 0));
        NowaGra.setSpacing(15);
        NowaGra.getStylesheets().add("nonogram/game/edu/Menu/Viper.css");
        scene2 = new Scene(NowaGra, 800, 600);

        //Layout 3 Wczytaj gre
        VBox WczytajGre = new VBox();
        WczytajGre.setAlignment(Pos.TOP_CENTER);
        Button buttonPowrotdoMenu2 = new Button("Powrót do Menu");
        buttonPowrotdoMenu2.setOnAction(e -> window.setScene(MenuScene));
        WczytajGre.getChildren().addAll(buttonPowrotdoMenu2);
        WczytajGre.getStylesheets().add("nonogram/game/edu/Menu/Viper.css");
        WczytajGre.setPadding(new Insets(10, 0, 0, 0));
        scene3 = new Scene(WczytajGre, 800, 600);


        //Layout 4 Statystyki
        HBox Statystyki = new HBox(20);
        Statystyki.setAlignment(Pos.TOP_CENTER);
        Button buttonPowrotdoMenu3 = new Button("Powrót do Menu");
        buttonPowrotdoMenu3.setOnAction(e -> window.setScene(MenuScene));
        Statystyki.getChildren().addAll(buttonPowrotdoMenu3);
        Statystyki.setPadding(new Insets(10, 0, 0, 0));
        Statystyki.getStylesheets().add("nonogram/game/edu/Menu/Viper.css");

        scene7 = new Scene(Statystyki, 800, 600);

        //Layout 5 Opcje rozgrywki
        HBox OpcjeRozgrywki = new HBox(20);
        OpcjeRozgrywki.setAlignment(Pos.TOP_CENTER);
        Button buttonPowrotdoMenu4 = new Button("Powrót do Menu");
        buttonPowrotdoMenu4.setOnAction(e -> window.setScene(MenuScene));
        OpcjeRozgrywki.getChildren().addAll(buttonPowrotdoMenu4);
        OpcjeRozgrywki.setPadding(new Insets(10, 0, 0, 0));
        scene8 = new Scene(OpcjeRozgrywki, 800, 600);
        OpcjeRozgrywki.getStylesheets().add("nonogram/game/edu/Menu/Viper.css");

        //Layout 6 Wybór rozmiaru planszy
        VBox WyborRozmiaru = new VBox();
        WyborRozmiaru.setAlignment(Pos.CENTER);
        Button buttonWczytanieObrazka = new Button("Wczytanie obrazka");
        buttonWczytanieObrazka.setOnAction(e -> window.setScene(scene6));
        Button buttonLosowanieObrazka = new Button("Losowanie obrazka");
        buttonLosowanieObrazka.setOnAction(e -> window.setScene(scene6));
        Button buttonPowrotdoMenu5 = new Button("Powrót do Menu");
        buttonPowrotdoMenu5.setOnAction(e -> window.setScene(MenuScene));
        WyborRozmiaru.getChildren().addAll(buttonWczytanieObrazka, buttonLosowanieObrazka, buttonPowrotdoMenu5);
        WyborRozmiaru.setPadding(new Insets(10, 100, 10, 100));
        WyborRozmiaru.setSpacing(15);
        WyborRozmiaru.getStylesheets().add("nonogram/game/edu/Menu/Viper.css");
        scene4 = new Scene(WyborRozmiaru, 800, 600);

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
        scene6 = new Scene(LosujObrazek, 800, 600);


        //Display scene 1 at first
        window.setScene(MenuScene);
        window.setTitle("Nonogram designed to make you happy");

        window.getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
        window.show();
    }

}
