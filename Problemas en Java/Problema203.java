import java.util.Scanner;

public class Problema203 {

    private static boolean hueco;

    public static class Nodo{

        private int valor;
        private Nodo n_iz;
        private Nodo n_der;

        public Nodo(int valor){
            this.valor = valor;
            n_iz=null;
            n_der=null;
        }

        public Nodo getIzq(){
            return n_iz;
        }

        public Nodo getDer(){
            return n_der;
        }
        public int getValor(){
            return valor;
        }

        public void setIzq(Nodo n){
            n_iz=n;
        }

        public void setDer(Nodo n){
            n_der=n;
        }

        public void setValor(int valor){
            this.valor = valor;
        }

        public String toString() {
            return String.valueOf(valor);
        }
    }

    public static void insertarArbol(Nodo cabeza, Scanner sc){
        
        int valor = sc.nextInt();
        Nodo nuevoNodo =new Nodo(valor);
        

        cabeza.setIzq(nuevoNodo);
        if (valor != -1) insertarArbol(cabeza.getIzq(), sc);

        valor = sc.nextInt();
        cabeza.setDer(new Nodo(valor));
        if (valor != -1) insertarArbol(cabeza.getDer(), sc);
        
    }

    public static Nodo sumarArboles(Nodo n1, Nodo n2) {
        if (n1 == null || n1.getValor() == -1) {
            return n2;
        }
        if (n2 == null || n2.getValor() == -1) {
            return n1;
        }
        n1.setValor(n1.getValor() + n2.getValor());
        n1.setIzq(sumarArboles(n1.getIzq(), n2.getIzq()));
        n1.setDer(sumarArboles(n1.getDer(), n2.getDer()));
        return n1;
    }

    public static void imprimirArbol(Nodo nodo) {
        if (nodo == null){  
            return;
        }
        if (!hueco){
             System.out.print(nodo.getValor()); hueco = true; 
        }
        else System.out.print(" " + nodo.getValor());
        if (nodo.getValor() != -1){ 
            imprimirArbol(nodo.getIzq());
        }
        if (nodo.getValor() != -1){  
            imprimirArbol(nodo.getDer());
        }
    }
    public static void main(String[] args) {
        boolean terminado = false;
        try(Scanner sc = new Scanner(System.in)) {
            while(!terminado){
                Nodo n1 = new Nodo(sc.nextInt());
                if (n1.getValor() != -1)
                    insertarArbol(n1, sc);

                Nodo n2 = new Nodo(sc.nextInt());
                if (!(n1.getValor() == -1 && n2.getValor() == -1)){
                    if (n2.getValor() != -1)
                    insertarArbol(n2, sc);

                    Nodo suma = sumarArboles(n1, n2);
                    hueco = false;
                    imprimirArbol(suma);

                    System.out.println(); 
                }
                else{
                    terminado = true;
                } 
            }  
        
        } catch (Exception e) {
        System.exit(1);
        }
        

    }
}