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
           juego.mostrarTablero();
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
}


