import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);

        // stocke les indices des lignes contenant la plus grande sequence de
        // '1' consecutifs dans la matrice
        ArrayList<Integer> maxConsecutifList = new ArrayList<Integer>();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        matrice = matrice.trim();
        String[] lignes = matrice.split(" {1,}");
        
        int empty = 0;
        
        int count3 = 0;
        
        for(int k = 0; k<matrice.length();k++){
            if ((matrice.charAt(k) != ' ')){
                empty = empty +1;
            }
        } 
        if (empty == 0){
            System.out.println("Matrice vide!");
            return;
        }
   
        for (int i = 0; i < matrice.length(); i++){
          
            if ((matrice.charAt(i) != ' ') && (matrice.charAt(i) != '0') && (matrice.charAt(i) != '1')){
                
                System.out.println("Matrice invalide, seulement '1' , '0' et ' ' admis!");
                return;
            }
            
        }
        for (int i = 0; i < (lignes.length - 1); i++){
            if(lignes[i].length() != lignes[i+1].length()){
                System.out.println("Matrice invalide, lignes de longueurs differentes!");
                return;
            }
        }
        
        for (int i = 0; i < lignes.length; i++){
        	
            int count1 = 0; int count2 = 0;
            
            for(int j = 0; j < lignes[i].length()-1; j++ ){
            	
                if((lignes[i].charAt(j) & lignes[i].charAt(j+1)) == '1'){
                    count1++; 
                }
                if((((lignes[i].charAt(j)=='1') & (lignes[i].charAt(j+1)) == '0') || (j == lignes[i].length()))&(count1>count2)){
                    count2 = count1;
                    count1 = 0;
                }
            }
            
            if ((count2 != 0) && (count2 >= count3) ){
                maxConsecutifList.add(i);
            }
            if(count2 > count3){
            	maxConsecutifList.clear();
            	maxConsecutifList.add(i);
            	count3 = count2;
            }
            System.out.println(count2+" "+count3);
        }
            
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1!");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs:");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }
}
