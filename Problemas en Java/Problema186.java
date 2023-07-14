import java.io.BufferedInputStream;
import java.util.Scanner;

public class Problema186 {
	public static void main(String[] args){
		try(Scanner sc=new Scanner(new BufferedInputStream(System.in, 1024))){
			int nGlobos;	
			int nEquipos;	
			int[] equipos;

			nEquipos = sc.nextInt();
		 	nGlobos = sc.nextInt();
			
			while (!(nGlobos==0 && nEquipos==0)) {
				
				if (nGlobos==0&&nEquipos > 1){
					System.out.println("EMPATE");
				}
				
				else{ 
					
					equipos = new int[nEquipos];
					
					if(nEquipos==1){
						equipos[0]=1;
					}
					for(int i=0; i < nGlobos; i++) {	
						equipos[sc.nextInt()-1]++;
						sc.next();

					}
					int winner = 0;
					int max =0;
					boolean empate = false;
					
					for(int i=0; i<nEquipos; i++) {
						if(equipos[i]>max) {
							max=equipos[i];
							winner = i+1;
							empate = false;
						}
						else if(max==equipos[i]) {
							empate = true;	
						}
					}
					
					if(empate) {
						System.out.println("EMPATE");
					}
					else {
						System.out.println(winner);
					}
				}	
					
				nEquipos = sc.nextInt();
			 	nGlobos = sc.nextInt();	
				
			}
			

		}catch(Exception e) {
			 System.exit(1);
			
		}
	}


}

