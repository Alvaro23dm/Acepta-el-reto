import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problema570{
    public static void main(String args[]){
        char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        int[] ind = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
            while(sc.hasNextLine()){
                int posib, numGen, contInt, mod;
                String var="";
                char letra;
                
                int numIt = Integer.parseInt(sc.nextLine());
                
                int[] interrog = new int[4];
                
                for (int i = 0; i<numIt;i++){
                    posib =0;
                    numGen =0;
                    contInt =0;
                    
                    var = sc.nextLine();
                    
                    letra = var.charAt(8);
                    mod = buscarPos(tabla, letra);
                    
                    for(int j =0; j< 8; j++){
                        numGen*=10;
                        if (var.charAt(j)== '?'){
                            interrog[contInt]= 7-j;
                            contInt++;
                        }else{
                            numGen+= Character.getNumericValue(var.charAt(j));
                        }
                        
                    }
                    
                    
                    switch (contInt) {
                        case 1:
                            for (int j = 0; j < 10; j++) {
                                if( (numGen + j * ind[interrog[0]])%23 == mod){
                                    posib ++;
                                } 
                                
                            }
                            break;
                            
                        case 2:
                            for (int j = 0; j < 10; j++) {
                                for (int o = 0; o < 10; o++) {
                                    if( (numGen + j * ind[interrog[0]]+ o * ind[interrog[1]])%23 == mod){
                                        posib ++;
                                    } 
                                }
                            }
                            break;
                        case 3:
                            for (int j = 0; j < 10; j++) {
                                for (int o = 0; o < 10; o++) {
                                    for (int k = 0; k < 10; k++) {
                                        
                                        if( (numGen + j * ind[interrog[0]]+ o * ind[interrog[1]]+ k * ind[interrog[2]])%23 == mod){
                                            posib ++;
                                        } 
                                    }
                                }
                            }
                            break;
                        case 4:
                        for (int j = 0; j < 10; j++) {
                            for (int o = 0; o < 10; o++) {
                                for (int k = 0; k < 10; k++) {
                                    for (int d = 0;d < 10; d++) {
                                        if((( numGen + (j * ind[interrog[0]]) + (o * ind[interrog[1]]) + (k * ind[interrog[2]]) + (d * ind[interrog[3]]))%23) == mod){
                                            posib ++;
                                        } 
                                    }
                                }
                            }
                        }
                            
                            break;
            
                        default:
                            System.err.println("Error");
                            break;
                    }
                    

                    
                    System.out.println(posib);
                }          
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            
        }
        
    }
    
    static int buscarPos (char[] tabla, char val){
        int res = -1;
        for(int k = 0; k<tabla.length && res == -1;k++){
            if(tabla[k] == val){
                res=k;
            }
        }
        return res;
    }

    
}


