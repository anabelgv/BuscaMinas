package principal;
import java.util.Scanner;

import buscaminas.Buscaminas;

public class InterfaceBuscaminas {
   private Buscaminas juego;
   private Scanner scanner;




   public InterfaceBuscaminas(int filas, int columnas, int numMinas) {
       this.juego = new Buscaminas(filas, columnas, numMinas);
       this.scanner = new Scanner(System.in);
   }




   public void jugar() {
       System.out.println("Empezar a jugar al Buscaminas");




       while (!juego.isJuegoTerminado()) {
           mostrarTablero( juego.getTableroDestapado(), juego.getTableroNum() );
           int fila = obtenerEntrada("Fila: ");
           int columna = obtenerEntrada("Columna: ");
           juego.destaparCasilla(fila, columna);
       }




       if (juego.isJuegoGanado()) {
           System.out.println("Has ganado.");
       } else {
           System.out.println("Has perdido.");
       }
   }




   private int obtenerEntrada(String mensaje) {
       System.out.print(mensaje);
       return scanner.nextInt();
   }




   public static void main(String[] args) {
       InterfaceBuscaminas buscaminas = new InterfaceBuscaminas(10, 10, 10);
       buscaminas.jugar();
   }

   public void mostrarTablero( boolean[][]tableroDestapado, int[][]tableroNum ) {
    int[][] tableroMostrado = new int  [tableroDestapado.length][tableroDestapado[0].length];
    int filas = tableroDestapado.length;
    int columnas = tableroDestapado[0].length;
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            if (tableroDestapado[i][j]) {
                tableroMostrado[i][j] = tableroNum[i][j];
            } else {
                tableroMostrado[i][j] = -1; // Representa una casilla tapada
            }
        }
    }
    // Mostrar el tablero
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            if (tableroMostrado[i][j] == -1) {
                System.out.print("- ");
            } else {
                System.out.print(tableroMostrado[i][j] + " ");
            }
        }
        System.out.println();
    }
}
}


