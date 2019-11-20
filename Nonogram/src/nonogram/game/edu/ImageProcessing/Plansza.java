package nonogram.game.edu.ImageProcessing;

/**
 * @author MD
 */

public class Plansza {

    int rozmiar;
    int info[][];
    boolean wypelnienie[][];

    public Plansza(int size) {
        this.rozmiar = size;
        this.info = new int [2*size][(size+1)/2];
        this.wypelnienie = new boolean [size][size];
    }

    public Plansza zwrocInfo(Plansza p)
    {
      Plansza i = new Plansza(p.rozmiar);

      // generowanie dla pierwszej (pionowej) połowy
      for (int x = 0; x < p.rozmiar; x++){
        int z = 0;
        for (int y = 0; y < p.rozmiar; y++){
          if (p.wypelnienie[x][y] && i.info[x][0] == 0) i.info[x][0]++;
          else if (p.wypelnienie[x][y]) i.info[x][z]++;
          else if (!p.wypelnienie[x][y] && i.info[x][0] != 0 && p.wypelnienie[x][y] != p.wypelnienie[x][y-1]) z++;
        }}

      // generowanie dla drugiej (poziomej) połowy
      for (int y = 0; y < p.rozmiar; y++){
        int z = 0;
        for (int x = 0; x < p.rozmiar; x++){
          if (p.wypelnienie[x][y] && i.info[15+y][0] == 0) i.info[15+y][0]++;
          else if (p.wypelnienie[x][y]) i.info[15+y][z]++;
          else if (!p.wypelnienie[x][y] && x != 0 && p.wypelnienie[x][y] != p.wypelnienie[x-1][y]) z++;
        }}

      return i;
    }

    public boolean poprawneInfo()
    {
      int sum_pion = 0;
      int sum_poziom = 0;

      for (int i=0; i<this.rozmiar; i++){
        int z = 1;
        sum_pion += this.info[i][0];
        while(this.info[i][z] > 0){
          sum_pion += this.info[i][z];
          z++;
        }
      }

      for (int i=this.rozmiar; i<2*this.rozmiar; i++){
        int z = 1;
        sum_poziom += this.info[i][0];
        while(this.info[i][z] > 0){
          sum_poziom += this.info[i][z];
          z++;
        }
      }
      return (sum_poziom == sum_pion);
    }

    public void testowaPlansza(String c) {

      switch(c)
      {
        case "rozgwiazda":
          // Plansza(15);
          int size = 15;
          this.rozmiar = size;
          this.info = new int [2*size][(size+1)/2];
          this.wypelnienie = new boolean [size][size];

          this.wypelnienie[0][7] = true;

          this.wypelnienie[1][6] = true;
          this.wypelnienie[1][7] = true;
          this.wypelnienie[1][8] = true;

          this.wypelnienie[2][5] = true;
          this.wypelnienie[2][6] = true;
          this.wypelnienie[2][7] = true;
          this.wypelnienie[2][8] = true;
          this.wypelnienie[2][9] = true;

          this.wypelnienie[3][5] = true;
          this.wypelnienie[3][6] = true;

          this.wypelnienie[3][8] = true;
          this.wypelnienie[3][9] = true;

          this.wypelnienie[4][4] = true;
          this.wypelnienie[4][5] = true;

          this.wypelnienie[4][8] = true;
          this.wypelnienie[4][9] = true;
          this.wypelnienie[4][10] = true;

          this.wypelnienie[5][0] = true;
          this.wypelnienie[5][1] = true;
          this.wypelnienie[5][2] = true;
          this.wypelnienie[5][3] = true;
          this.wypelnienie[5][4] = true;
          this.wypelnienie[5][5] = true;

          this.wypelnienie[5][8] = true;
          this.wypelnienie[5][9] = true;
          this.wypelnienie[5][10] = true;
          this.wypelnienie[5][11] = true;
          this.wypelnienie[5][12] = true;
          this.wypelnienie[5][13] = true;
          this.wypelnienie[5][14] = true;

          this.wypelnienie[6][0] = true;
          this.wypelnienie[6][1] = true;
          this.wypelnienie[6][2] = true;
          this.wypelnienie[6][3] = true;
          this.wypelnienie[6][4] = true;
          this.wypelnienie[6][5] = true;
          this.wypelnienie[6][6] = true;

          this.wypelnienie[6][8] = true;
          this.wypelnienie[6][9] = true;

          this.wypelnienie[6][13] = true;
          this.wypelnienie[6][14] = true;

          this.wypelnienie[7][1] = true;
          this.wypelnienie[7][2] = true;

          this.wypelnienie[7][8] = true;

          this.wypelnienie[7][11] = true;
          this.wypelnienie[7][12] = true;
          this.wypelnienie[7][13] = true;

          this.wypelnienie[8][2] = true;
          this.wypelnienie[8][3] = true;
          this.wypelnienie[8][4] = true;
          this.wypelnienie[8][5] = true;
          this.wypelnienie[8][6] = true;

          this.wypelnienie[8][9] = true;
          this.wypelnienie[8][10] = true;
          this.wypelnienie[8][11] = true;
          this.wypelnienie[8][12] = true;

          this.wypelnienie[9][3] = true;
          this.wypelnienie[9][4] = true;
          this.wypelnienie[9][5] = true;

          this.wypelnienie[9][10] = true;
          this.wypelnienie[9][11] = true;

          this.wypelnienie[10][2] = true;
          this.wypelnienie[10][3] = true;
          this.wypelnienie[10][4] = true;

          this.wypelnienie[10][8] = true;

          this.wypelnienie[10][11] = true;
          this.wypelnienie[10][12] = true;

          this.wypelnienie[11][2] = true;
          this.wypelnienie[11][3] = true;
          this.wypelnienie[11][4] = true;

          this.wypelnienie[11][7] = true;
          this.wypelnienie[11][8] = true;
          this.wypelnienie[11][9] = true;

          this.wypelnienie[11][11] = true;
          this.wypelnienie[11][12] = true;

          this.wypelnienie[12][1] = true;
          this.wypelnienie[12][2] = true;
          this.wypelnienie[12][3] = true;

          this.wypelnienie[12][5] = true;
          this.wypelnienie[12][6] = true;
          this.wypelnienie[12][7] = true;
          this.wypelnienie[12][8] = true;
          this.wypelnienie[12][9] = true;
          this.wypelnienie[12][10] = true;

          this.wypelnienie[12][12] = true;
          this.wypelnienie[12][13] = true;

          this.wypelnienie[13][1] = true;
          this.wypelnienie[13][2] = true;
          this.wypelnienie[13][3] = true;
          this.wypelnienie[13][4] = true;
          this.wypelnienie[13][5] = true;

          this.wypelnienie[13][9] = true;
          this.wypelnienie[13][10] = true;
          this.wypelnienie[13][11] = true;
          this.wypelnienie[13][12] = true;
          this.wypelnienie[13][13] = true;

          this.wypelnienie[14][1] = true;
          this.wypelnienie[14][2] = true;
          this.wypelnienie[14][3] = true;
          this.wypelnienie[14][4] = true;

          this.wypelnienie[14][10] = true;
          this.wypelnienie[14][11] = true;
          this.wypelnienie[14][12] = true;
          this.wypelnienie[14][13] = true;

          // poziomo
          this.info[0][0] = 1;
          this.info[1][0] = 3;
          this.info[2][0] = 5;
          this.info[3][0] = 2;
          this.info[3][1] = 2;
          this.info[4][0] = 2;
          this.info[4][1] = 3;

          this.info[5][0] = 6;
          this.info[5][1] = 7;
          this.info[6][0] = 7;
          this.info[6][1] = 2;
          this.info[6][2] = 2;
          this.info[7][0] = 2;
          this.info[7][1] = 1;
          this.info[7][2] = 3;
          this.info[8][0] = 5;
          this.info[8][1] = 4;
          this.info[9][0] = 3;
          this.info[9][1] = 2;

          this.info[10][0] = 3;
          this.info[10][1] = 1;
          this.info[10][2] = 2;
          this.info[11][0] = 3;
          this.info[11][1] = 3;
          this.info[11][2] = 2;
          this.info[12][0] = 3;
          this.info[12][1] = 6;
          this.info[12][2] = 2;
          this.info[13][0] = 5;
          this.info[13][1] = 5;
          this.info[14][0] = 4;
          this.info[14][1] = 4;

          // pionowo
          this.info[15][0] = 2;
          this.info[16][0] = 3;
          this.info[16][1] = 3;
          this.info[17][0] = 4;
          this.info[17][1] = 5;
          this.info[18][0] = 2;
          this.info[18][1] = 7;
          this.info[19][0] = 3;
          this.info[19][1] = 4;
          this.info[19][2] = 2;

          this.info[20][0] = 5;
          this.info[20][1] = 2;
          this.info[20][2] = 2;
          this.info[21][0] = 3;
          this.info[21][1] = 1;
          this.info[21][2] = 1;
          this.info[21][3] = 1;
          this.info[22][0] = 3;
          this.info[22][1] = 2;
          this.info[23][0] = 7;
          this.info[23][1] = 3;
          this.info[24][0] = 5;
          this.info[24][1] = 1;
          this.info[24][2] = 3;

          this.info[25][0] = 2;
          this.info[25][1] = 2;
          this.info[25][2] = 3;
          this.info[26][0] = 1;
          this.info[26][1] = 5;
          this.info[26][2] = 2;
          this.info[27][0] = 1;
          this.info[27][1] = 2;
          this.info[27][2] = 5;
          this.info[28][0] = 3;
          this.info[28][1] = 3;
          this.info[29][0] = 2;

        break;
        default:
        break;
      }

    }

}
