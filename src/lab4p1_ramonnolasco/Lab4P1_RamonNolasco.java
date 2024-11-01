/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_ramonnolasco;
import java.util.Scanner;

public class Lab4P1_RamonNolasco {

    public static void main(String[] args) {
                
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        
        do{
            System.out.println("1- Conversion decimal-binario");
            System.out.println("2- Validar correos");
            System.out.println("3- Formar palabras");
            System.out.println("4- Salir");
            System.out.println("Ingresar opcion: ");
            int opcion;
            opcion = scanner.nextInt();
            
            switch (opcion){
                
                case 1: 
                            
                    String binario;

                    while (true) {
                        System.out.print("Ingrese cadena binaria: ");
                        scanner.nextLine();
                        binario = scanner.nextLine();

                        if (binario.length() == 8 && binario.replace("0", "").replace("1", "").isEmpty()) {
                            break;
                        } 
                        else {
                            System.out.println("*Cad1ena inválida, ingrese de nuevo*");
                        }
                    }

                    int decimal = convertirBinarioADecimal(binario);
                    System.out.println("El número convertido es: " + decimal);
                                break;
                
                case 2:
                    
                
                case 3:
                    
                case 4:
                    menu = false;
                    break;
                    
            }
            
        }while(menu == true);        
    }

    public static int convertirBinarioADecimal(String binario) {
        int decimal = 0;
        int potencia = 1; 

        for (int i = binario.length() - 1; i >= 0; i--) {
            if (binario.charAt(i) == '1') {
                decimal += potencia;
            }
            potencia *= 2;
        }
        return decimal;
    }
}

