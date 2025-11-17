//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static Scanner in = new Scanner( System.in );
    public static Random random = new Random();

    //Valori multipli di ritorno per il metodo calcolaMassimo
    public static record Max(int massimo, int rIdx, int cIdx) { }

    // Metodo per calcolare il massimo nella matrice
    public static Max calcolaMassimo(int[][]M, int nR, int nC) {
        int max, idxR, idxC;
        idxR = 0;
        idxC = 0;
        for (int i = 0; i<nR; ++i) {
            for (int j = 0; j<nC; ++j) {
                if (M[i][j]>M[idxR][idxC]) {
                    idxR = i;
                    idxC = j;
                }
            }
        }
        max = M[idxR][idxC];
        return new Max(max, idxR, idxC);
    }

    // Metodo per calcolare la media di una colonna
    public static float calcolaMedia(int[][]M, int nR, int colonna) {
        float somma = 0;
        for (int i = 0; i<nR; ++i) {
            somma += M[i][colonna];
        }
        return somma/nR;       
    }

    // Metodo per riempire la matrice con valori casuali
    // Già risolto nell'esercizio precedente
    public static void riempiCasuale( int[][] M, int RIGHE, int COLONNE, int valMin, int valMax) {
        Random rand = new Random();
        for (int i=0; i <= RIGHE-1; i=i+1 ) {
            for (int j=0; j <= COLONNE-1; j=j+1) {
                M[i][j] = rand.nextInt((valMax+1)-valMin) + valMin;
            }
        }
    }

    public static void main(String args[]) {
        int n = 7;
        int m = 5;
        int [][] M = new int[n][m];
        riempiCasuale(M, n, m, 298, 314);
        System.out.println("Temperature registrate: \n");
        UtilsMatrice.visualizza(M);
        Max max = calcolaMassimo(M, n, m);
        System.out.println("\nTemperatura massima: " + max.massimo());
        System.out.println("Verificatasi il giorno: " + (max.rIdx()+1));
        System.out.println("Alle ore: " + (max.cIdx()+11));
        float [] medieColonne = new float[m];
        for (int j = 0; j<m; ++j) {
            medieColonne[j] = calcolaMedia(M, n, j);
        }
        System.out.println();
        for (int i = 0; i<m; ++i) {
            System.out.println("Media fascia oraria " + (i+11) + "-" + (i+12) + ": " + medieColonne[i]);
        }
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md