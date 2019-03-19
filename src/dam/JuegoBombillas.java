package dam;

import java.util.Scanner;

public class JuegoBombillas {
    public static void main(String[] args) {
        boolean [][] mapa = new boolean[7][7];

        iniciarJuego(mapa);

        do{
            juego(mapa);
        }while(!juegoAcabado(mapa));
    }

    private static void iniciarJuego(boolean[][] mapa) {
        inicializarMapa(mapa);
        mostrarMapa(mapa);
    }

    private static void juego(boolean[][] mapa) {
        //pedir coordenadas
        Scanner teclado = new Scanner(System.in);
        int fila = -1;
        int columna = -1;
        do{
            System.out.print("Dame la fila: ");
            fila = Integer.parseInt(teclado.nextLine());
        }while(fila <= 0 || fila > mapa.length);

        do{
            System.out.print("Dame la columna: ");
            columna = Integer.parseInt((teclado.nextLine()));
        }while(columna <= 0 || columna > mapa[0].length);

        cambiarEstado(mapa, fila-1, columna-1);
        mostrarMapa(mapa);
    }

    public static void cambiarEstado(boolean[][] mapa, int fila, int columna) {
        mapa[fila][columna] = !mapa[fila][columna];

        if(fila != 0) mapa[fila-1][columna] = !mapa[fila-1][columna];
        if(fila != mapa.length-1) mapa[fila+1][columna] = !mapa[fila+1][columna];
        if(columna != 0) mapa[fila][columna-1] = !mapa[fila][columna-1];
        if(columna != mapa[0].length-1) mapa[fila][columna+1] = !mapa[fila][columna+1];
    }

    public static void mostrarMapa(boolean[][] mapa) {
        for (int i = 0 ; i < mapa.length; i++){
            for (int j = 0; j < mapa[0].length; j++) {
                if(mapa[i][j]) {
                    System.out.print(" # ");
                }else{
                    System.out.print(" · ");
                }
            }
            System.out.println();
        }
    }

    private static void inicializarMapa(boolean mapa[][]) {

        for (int i = 0 ; i < mapa.length; i++){
            for (int j = 0; j < mapa[0].length; j++) {
                mapa[i][j]=false;
            }
        }
    }

    private static boolean juegoAcabado(boolean[][] mapa) {
        for (int i = 0 ; i < mapa.length; i++){
            for (int j = 0; j < mapa[0].length; j++) {
                if(!mapa[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}