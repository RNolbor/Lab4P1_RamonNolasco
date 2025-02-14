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
                    System.out.println("Ingrese una cadena para procesar su orden: ");
                    String orden = input.nextLine();
                    
                    procesarOrden(orden);
                    
                    break;
                    
                case 2:
                    System.out.println("Ingrese primera peticion: ");
                    String peticion1 = input.nextLine();
                    System.out.println("Ingrese segunda peticion: ");
                    String peticion2 = input.nextLine();
                    
                    
                    
                    
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
    
    //METODOS EJECICIO 1
    
    public static void procesarOrden(String orden) {
        int maiz = 0, papa = 0, cafe = 0, trigo = 0, otros = 0;
        int i = 0;

        while (i < orden.length()) {
            
            String numStr = "";
            while (i < orden.length() && orden.charAt(i) >= '0' && orden.charAt(i) <= '9') {
                numStr += orden.charAt(i);
                i++;
            }

            if (numStr.equals("")) {
                System.out.println("Orden invalida! se esperaba un numero antes de las letras.");
                return;
            }
            int cantidad = Integer.parseInt(numStr);
            
            if (i >= orden.length()) {
                System.out.println("Orden invalida! se esperaba letra(s) despues del numero.");
                return;
            }

            
            while (i < orden.length() && ((orden.charAt(i) >= 'a' && orden.charAt(i) <= 'z') || (orden.charAt(i) >= 'A' && orden.charAt(i) <= 'Z'))) {
                char letra = Character.toLowerCase(orden.charAt(i));
                switch (letra) {
                    case 'm':
                        maiz += cantidad;
                        break;
                    case 'p':
                        papa += cantidad;
                        break;
                    case 'c':
                        cafe += cantidad;
                        break;
                    case 't':
                        trigo += cantidad;
                        break;
                    default:
                        otros += cantidad;
                        break;
                }
                i++;
            }
        }

        System.out.println("Orden de compras:");
        System.out.println("Maiz: " + maiz);
        System.out.println("Papa: " + papa);
        System.out.println("Cafe: " + cafe);
        System.out.println("Trigo: " + trigo);
        System.out.println("Otros: " + otros);
    }
    
    //METODOS EJERCICIO 2
    
    public String cadenaDeSimilitudes (String peticion1, String peticion2){
        String similitudes = "";
        
        similitudes += "Hola Mundo";
        
        
        
        return similitudes;
    }
    //cadenacadena
    
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
