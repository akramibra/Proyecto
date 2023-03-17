public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        controlador controlador = new controlador();
        vista vista = new vista();
        vista.Menu();
        controlador.imprimir();
        
    }
}
