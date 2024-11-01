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
                            System.out.println("*Cadena invalida, ingrese de nuevo*");
                        }
                    }

                    int decimal = convertirBinarioADecimal(binario);
                    System.out.println("El numero convertido es: " + decimal);
                    break;
                
                case 2:
                    String[] extensionesValidas = {"@gmail.com", "@outlook.com", "@unitec.edu"};
                    
                    System.out.print("Ingrese una direccion de correo: ");
                    scanner.nextLine();
                    String correo = scanner.nextLine();
                    
                    if (!tieneArroba(correo)) {
                        System.out.println("Correo invalido: no contiene '@'");
                        break;
                    }
                    
                    int mejorCoincidenciaIndice = -1;
                    double mejorPorcentajeCoincidencia = 0.0;

                    for (int i = 0; i < extensionesValidas.length; i++) {
                        double porcentajeCoincidencia = calcularPorcentajeCoincidencia(correo, extensionesValidas[i]);

                        if (porcentajeCoincidencia == 1.0) {
                            System.out.println("Correo valido con la extension " + extensionesValidas[i]);
                            break;
                        }
                        if (porcentajeCoincidencia > mejorPorcentajeCoincidencia) {
                            mejorPorcentajeCoincidencia = porcentajeCoincidencia;
                            mejorCoincidenciaIndice = i;
                        }
                    }
                    if (mejorPorcentajeCoincidencia > 0 && mejorPorcentajeCoincidencia < 1.0) {
                        System.out.println("Extension sugerida: " + extensionesValidas[mejorCoincidenciaIndice] + 
                                           " con porcentaje de coincidencia " + mejorPorcentajeCoincidencia);
                    } else if (mejorPorcentajeCoincidencia == 0.0) {
                        System.out.println("No hay coincidencia válida para el correo.");
                    }
                    break;
           
                case 3:
                    String oracion = "";
                    String palabra = "";
                    scanner.nextLine();
                    System.out.println("Ingrese cadena: ");
                    oracion = scanner.nextLine();
                    System.out.println("Ingrese palabra: ");
                    palabra = scanner.next();
                    
                    formarPalabra(oracion, palabra);
                    break;
                    
                case 4:
                    menu = false;
                    break;
                
                default:
                    System.out.println("Ingrese una opcion valida!");
                
            }
            
        } while(menu == true);        
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
    
    public static boolean tieneArroba(String correo) {
        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') {
                return true;
            }
        }
        return false;
    }

    public static double calcularPorcentajeCoincidencia(String correo, String extension) {
        int cuentaCoincidencias = 0;
        int indiceArroba = indiceDeArroba(correo);

        if (indiceArroba == -1) {
            return 0.0;
        }

        String extensionCorreo = correo.substring(indiceArroba);
        
        int longitudComparacion;
        if (extensionCorreo.length()< extension.length()) {
            longitudComparacion = extensionCorreo.length();
        } else {
            longitudComparacion = extension.length();
        }

    
        for (int i = 0; i < longitudComparacion; i++) {
            if (extensionCorreo.charAt(i)== extension.charAt(i)) {
                cuentaCoincidencias++;
            } else {
                break; 
            }
        }

        return (double) cuentaCoincidencias /extension.length();
    }

    public static int indiceDeArroba(String correo) {
        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') {
                return i;
            }
        }
        return -1;
    }
    
    
    public static void formarPalabra(String oracion, String palabra){
        
        String oracionModificada = "";
        String palabraFormada = "";
        boolean completado = true;
        int posicion = 1;
        
        for (int i = 0; i < palabra.length(); i++) {       
            char letraAct = palabra.charAt(i);
            boolean letraEncontrada = false;
            
            for (int j = 0; j < oracion.length(); j++) {
                char letraora = oracion.charAt(j);
                
                if (letraora == letraAct){
                    palabraFormada += letraAct;
                    oracionModificada += "*";
                    letraEncontrada = true;
                    posicion += 1;
                    break;
                } 
                else {
                    oracionModificada += letraora;
                }            
            }
            if (!letraEncontrada) {
                completado = false;
            }
        }
            
        System.out.println("Letras obtenidas:");
        System.out.println(oracionModificada);

        if (completado == true) {
        System.out.println("La palabra se completó: " + palabraFormada);
        } else {
        System.out.println("La palabra no se completó. Se logró formar: " + palabraFormada);
        }
        System.out.println("Posiciones: " + posicion);
    }
    
    
    
}
