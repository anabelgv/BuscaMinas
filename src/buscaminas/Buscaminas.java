package buscaminas;


import java.util.Random;


public class Buscaminas {
    private int[][] tableroNum;
    private boolean[][] tableroDestapado;
    private boolean juegoTerminado;
    private boolean juegoGanado;
    private int filas;
    private int columnas;
    private int numMinas;
    private int casillasDestapadas;


    public Buscaminas(int filas, int columnas, int numMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.numMinas = numMinas;
        this.juegoTerminado = false;
        this.juegoGanado = false;
        this.casillasDestapadas = 0;


        inicializarTablero();
        colocarMinasYActualizar();
    }


    //Todas las variables y métodos que no necesitan ser accesibles desde fuera de la clase busca minas están marcadas como privadas.
    private void inicializarTablero() {
        tableroNum = new int[filas][columnas];
        tableroDestapado = new boolean[filas][columnas];


            // Inicializar tablero de números
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroNum[i][j] = 0;
                tableroDestapado[i][j] = false;
            }
        }
    }


    private void colocarMinasYActualizar() {
        Random random = new Random();
        int minasColocadas = 0;


        while (minasColocadas < numMinas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);


            if (tableroNum[fila][columna] != 9) {
                tableroNum[fila][columna] = 9;
                minasColocadas++;


                // Actualizar celdas
                for (int i = Math.max(0, fila - 1); i <= Math.min(filas - 1, fila + 1); i++) {
                    for (int j = Math.max(0, columna - 1); j <= Math.min(columnas - 1, columna + 1); j++) {
                        if (tableroNum[i][j] != 9) {
                            tableroNum[i][j]++;
                        }
                    }
                }
            }
        }
    }
          //Continuamos con la funcionalidad del juego, para descubrir la casilla y las casillas vecinas
   
    public void destaparCasilla(int fila, int columna) {
        if (!juegoTerminado && !tableroDestapado[fila][columna]) {
            tableroDestapado[fila][columna] = true;


            if (tableroNum[fila][columna] == 0) {
                destaparVecinos(fila, columna);
            }


            if (tableroNum[fila][columna] == 9) {
                juegoTerminado = true;
            } else {
                casillasDestapadas++;
                if (casillasDestapadas == (filas * columnas) - numMinas) {
                    juegoTerminado = true;
                    juegoGanado = true;
                }
            }
        }
    }




    private void destaparVecinos(int fila, int columna) {
        for (int i = Math.max(0, fila - 1); i <= Math.min(filas - 1, fila + 1); i++) {
            for (int j = Math.max(0, columna - 1); j <= Math.min(columnas - 1, columna + 1); j++) {
                if (!tableroDestapado[i][j]) {
                    tableroDestapado[i][j] = true;
                    if (tableroNum[i][j] == 0) {
                        destaparVecinos(i, j);
                    }
                }
            }
        }
    }


    //para finalizar el juego:


    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }


    public boolean isJuegoGanado() {
        return juegoGanado;
    }

 public boolean[][] getTableroDestapado() {
        return tableroDestapado;
    }
    public int[][] getTableroNum() {
        return tableroNum;
    }
}


