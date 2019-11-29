package nonogram.game.edu.Gameplay;

import javafx.scene.paint.Color;
import nonogram.game.edu.ImageProcessing.Plansza;

public class GameSettings {

    Plansza p;
    Color netColor;
    Color squareColor;
    Color bgColor;
    Color crossColor;
    Color infoColor;
    double netWidth;
    double crossWidth;
    int BLOCK_SIZE;

    public GameSettings(){
        // p nowy kostrukotr gdzie nie podajesz rozmiaru to bez sensu
        //p = new "losowa"Plansza(); metoda losuj nową planszę
        // tmp
       // p = new Plansza();
       // p.losujplansze()
        p = new Plansza(15);
        p.testowaPlansza("rozgwiazda");
        //end of tmp
        netColor = Color.PINK;
        squareColor = Color.BLACK;
        bgColor = Color.WHITE;
        crossColor = Color.BLACK;
        infoColor = Color.BLACK;
        crossWidth = 4.0;
        netWidth = 2.0;
        BLOCK_SIZE = 40;
    }
}
