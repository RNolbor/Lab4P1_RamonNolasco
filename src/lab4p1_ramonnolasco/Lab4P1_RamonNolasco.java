/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_ramonnolasco;

import java.util.Scanner;

/**
 *
 * @author ramon
 */
public class Lab4P1_RamonNolasco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        int opcion;
        
        do{
            System.out.println("");
            System.out.println("--------------MENU---------------");
            System.out.println("");
            System.out.println("1) Orden de compras");
            System.out.println("2) Similitud de peticiones");
            System.out.println("3) Es una rotacion?");
            System.out.println("4) Salir");
            System.out.println("");
            
            System.out.println("Ingrese una opcion: ");
            opcion = input.nextInt();
            
            input.nextLine();
            
            switch (opcion){
                
                case 1: 
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    System.out.println("Ingrese la cadena de prueba: ");
                    String cadenaOriginal = input.nextLine();
                    System.out.println("Ingrese la cadena resultante del hechizo: ");
                    String cadenaHechizada = input.nextLine();
                    
                    boolean resultado = hechizo(cadenaOriginal, cadenaHechizada);
                    
                    if (resultado == true){
                        System.out.println("El hechizo ha funcionado! La cadena se ha rotado");
                    }else{
                        System.out.println("El hechizo fue un fracaso! La siguiente sera");
                    }
                    
                    break;
                    
                case 4:
                    System.out.println("Saliendo...");
                    break;
            }
            
            
            
            
        }while(opcion != 4);
   
    }
    
    
    //METODO EJERCICIO 3
    
    public static boolean hechizo (String cadenaOriginal, String cadenaHechizada){
 
        if (cadenaOriginal.length() != cadenaHechizada.length()){           
            return false;           
        }
        
        String cadenaDoble = cadenaOriginal + cadenaOriginal;
        
        for (int i = 0 ; i <= cadenaDoble.length() - cadenaHechizada.length() ; i++){
            boolean esIgual = true;
            for (int j = 0 ; j < cadenaHechizada.length();j++){
                if (cadenaDoble.charAt(i+j) != cadenaHechizada.charAt(j)){
                    esIgual = false;
                    break;
                }
            }
            if (esIgual){
                return true;
            }
        }
        return false; 
    }
    
    
    
}
