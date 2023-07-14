import java.util.Scanner;

public class Problema345 {

    private static boolean compFila(int[][] sudoku, int fila, int valor) {
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if (sudoku[fila][i] == valor) {
                cont++;
                if (cont > 1)
                    return false;
            }
        }
        return true;
    }

    private static boolean compCol(int[][] sudoku, int col, int valor) {
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == valor) {
                cont++;
                if (cont > 1)
                    return false;
            }
        }
        return true;
    }

    private static boolean compBloque(int[][] sudoku, int bloque, int valor) {
        int cont = 0;
        int copia = bloque;
        boolean bool = false;
        int i = 0;
        while (bool == false) {
            if (sudoku[i][bloque] == valor) {
                cont++;
                if (cont > 1)
                    return false;
            }
            bloque++;
            if (bloque % 3 == 0) {
                i++;
                if (i % 3 == 0)
                    bool = true;
                bloque = copia;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // numero de sudokus
            int n = sc.nextInt();

            // declaramos la matriz que sera el sudoku
            int sudoku[][] = new int[9][9];

            boolean bool;
            boolean res = true;
            int i = 0;

            while (n > 0) {
                for (int k = 0; k < 9; k++) {
                    for (int l = 0; l < 9; l++) {
                        sudoku[k][l] = sc.nextInt();
                    }
                }
                while (res && i < 9) {
                    for (int j = 1; j < 10 && res; j++) {
                        bool = compFila(sudoku, i, j);
                        if (bool == false)
                            res = false;
                    }
                    i++;
                }
                i = 0;
                while (res && i < 9) {
                    for (int j = 1; j < 10 && res; j++) {
                        bool = compCol(sudoku, i, j);
                        if (bool == false)
                            res = false;
                    }
                    i++;
                }
                i = 0;
                while (res && i < 9) {
                    for (int j = 1; j < 10 && res; j++) {
                        bool = compBloque(sudoku, i, j);
                        if (bool == false)
                            res = false;
                    }
                    i = i + 3;
                }
                if (res == true)
                    System.out.println("SI");
                else
                    System.out.println("NO");
                n--;
                res = true;
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }
}
//java Sudoku.java < Ex345.input