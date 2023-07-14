import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problema143 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            while(sc.hasNextInt()){

                Stack<Integer> pilaBuena = new Stack<Integer>();
                Queue<Integer> colaBuena = new LinkedList<Integer>();

                int dato = sc.nextInt();
                if (dato == -1){
                    break;
                }
                while(dato != -1){
                    pilaBuena.add(dato);
                    dato = sc.nextInt();
                }
                int numGiros = sc.nextInt();
                if(numGiros!=0){

                
                    int[] giros = new int[numGiros];
                    
                    for (int i =0; i< giros.length; i++){
                        giros[i]= sc.nextInt();
                    }

                    for (int i =0; i<giros.length; i++){
                        while (giros[i]!= 0){
                            int elemento = pilaBuena.pop();
                        
                            colaBuena.add(elemento);
                            
                            giros[i]--;
                        }
                        
                        while (!colaBuena.isEmpty()){
                            int elemento = colaBuena.remove();
                            pilaBuena.add(elemento);
                            
                        }

                    }
                
                }
                System.out.println(pilaBuena.peek());
                
            }
        } catch(Exception e) {
            System.exit(1);
        }
    }
}
