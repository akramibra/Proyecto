import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


/*
* CLASE ENCARGADA DE MOSTRAR EL FUNCIONAMIENTO DEL PROGRAMA
*/
public class controlador {
    static Scanner scan = new Scanner(System.in);
    static lispinstructions decode = new lispinstructions();
    static space env = space.getInstance();
    
    public void imprimir(){
        //Menu inicial del interprete de Lisp
        while(true){
            
            String expresion = scan.nextLine();
            String result = decode.expressions(expresion);
            env.ejecutar(expresion, result);     
            }
        }
}