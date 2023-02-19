package serpientes_y_escaleras;

import java.util.Scanner;

public class Serpientes_y_Escaleras {
    Scanner accion = new Scanner(System.in);
    int tablero[][] = new int[8][8];
    char jugador[][] = new char[8][8];
    char trampas[][] = new char [8][8];
    int posicion = 0;
    int jugadorfila = 7;
    int jugadorcolumna = 7;
    boolean comparador = true;
        
    public void juego(){
        Scanner AccionJuego = new Scanner(System.in);
        jugador[jugadorfila][jugadorcolumna] = '@';
        while (posicion <= 64) {
            System.out.println("\n+------------------------------------------+");
            System.out.println("|         Serpientes y Escaleras           |");
            System.out.println("+------------------------------------------+");
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (jugador[i][j] == '@') {
                        System.out.printf("|  %3d", tablero[i][j]);
                    } else {
                        System.out.printf("|  %3d", tablero[i][j]);
                    }
                }

                System.out.println("|");
                for (int j = 0; j < jugador.length; j++) {
                    System.out.print("|  ");
                    if (jugador[i][j] == '@') {
                        if (trampas[i][j] == '#') {
                            System.out.print("#");
                        } else {
                            System.out.print(" ");
                        }
                        System.out.print(" " + jugador[i][j] + "");
                    } else {
                        if (trampas[i][j] == '#') {
                            System.out.print("  #");
                        } else {
                            System.out.print("   ");
                        }
                    }
                }
                System.out.println("|");
                System.out.println("+------------------------------------------+");
            }
            System.out.println("|          Acciones Disponibles            |");
            System.out.println("+------------------------------------------+");
            System.out.println("1. Para tirar los dados presiona 'D'\n"+
                    "2. Para regresar al menu presiona 'M'");
            System.out.print("Ingrese su opción: ");
            String opcion = AccionJuego.nextLine();
            System.out.println("+------------------------------------------+");
            

            switch (opcion) {
                case ("d"):
                    int dado = (int) (Math.random() * (6 - 2) + 2);
                    System.out.println( "⠀⠀⠀⡿⡍⡖⠲⡄⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀\n" +
                                        "⠀⠀⡼⠙⠚⠁⠀⠸⣄⡤⠖⠦⣄⠀⠀⢸⠿⣿⣷⡀  ┌───────────────┐\n" +
                                        "⠀⠀⡇⠀⠀⢀⡖⢰⡏⠀⠀⠀⠘⡄⡠⢼⣦⠈⣿⣇    |                           |\n" +
                                        "⣀⣠⡾⠒⡒⠋⠀⡞⡄⠀⡏⡇⠀⣿⣞⡎⢏⡿⠛⠛    |      Tu dado lanzo:       |\n" +
                                        "⠛⠋⠀⢠⠃⠀⢸⠀⡇⠀⣷⠀⢸⠉⠉⡇⢸⠀⠀⠀    |             "+dado+"             |\n" +
                                        "⠀⠀⠀⢸⠀⠀⢸⣀⠇⠀⢸⠀⠘⢀⡜⠁⡸⠀⠀⠀    |                           |\n" +
                                        "⠀⠀⠀⠘⡆⠀⠈⠁⠀⢀⣿⠀⠈⠉⠀⢰⠃⠀⠀⠀   └───────────────┘\n" +
                                        "⠀⠀⠀⠀⠘⠦⣀⣀⣤⠾⠀⠓⠤⠴⠞⠛⠀⠀⠀⠀");

                    int nuevaPosicion = posicion + dado;
                    
                    if (comparador) {
                        for (int i = 0; i < tablero.length; i++) {
                            for (int j = 0; j < tablero[i].length; j++) {
                                if (tablero[i][j] == nuevaPosicion + 1) {
                                    jugadorfila = i;
                                    jugadorcolumna = j;
                                    comparador = false;
                                    break;
                                }
                            }
                        }
                    }else{
                        for (int i = 0; i < tablero.length; i++) {
                            for (int j = 0; j < tablero[i].length; j++) {
                                if (tablero[i][j] == nuevaPosicion + 1) {
                                    jugadorfila = i;
                                    jugadorcolumna = j;
                                    break;
                                }
                            }
                        }
                    }

                    jugador = new char[8][8];
                    jugador[jugadorfila][jugadorcolumna] = '@';
                    posicion = nuevaPosicion;

                    if (jugador[jugadorfila][jugadorcolumna] == '@') {
                        if (trampas[jugadorfila][jugadorcolumna] == '#') {
                            System.out.println("┌────────────────────────┐");
                            System.out.println("│    ⚠  ¡Has caído en una trampa! ⚠     │");
                            System.out.println("└────────────────────────┘");
                        }
                    }
                    
                    if (nuevaPosicion >= 64) {
                        for (int i = 0; i < tablero.length; i++) {

                            for (int j = 0; j < jugador[i].length; j++) {
                                if (jugador[i][j] == '@') {
                                    jugador[i][j] = ' ';
                                }
                            }
                        }
                        System.out.println("\n+------------------------------------------+");
                        System.out.println("|         Serpientes y Escaleras           |");
                        System.out.println("+------------------------------------------+");
                        for (int i = 0; i < tablero.length; i++) {
                            for (int j = 0; j < tablero[i].length; j++) {
                                if (jugador[i][j] == '@') {
                                    System.out.printf("|  %3d", tablero[i][j]);
                                } else {
                                    System.out.printf("|  %3d", tablero[i][j]);
                                }
                            }

                            System.out.println("|");
                            for (int j = 0; j < jugador.length; j++) {
                                System.out.print("|  ");
                                if (jugador[i][j] == '@') {
                                    if (trampas[i][j] == '#') {
                                        System.out.print("#");
                                    } else {
                                        System.out.print(" ");
                                    }
                                    System.out.print(" " + jugador[i][j] + "");
                                } else {
                                    if (trampas[i][j] == '#') {
                                        System.out.print("  #");
                                    } else {
                                        System.out.print("   ");
                                    }
                                }
                            }
                            System.out.println("|");
                            System.out.println("+------------------------------------------+");
                        }
                    }
            
            
                    
                    
                    if (posicion > 64) {
                        System.out.println("                       __\n"
                                + "                     .'  '.\n"
                                + "                 _.-'/  |  \\\n"
                                + "    ,        _.-\"  ,|  /  0 `-.\n"
                                + "    |\\    .-\"       `--\"\"-.__.'=====================-,\n"
                                + "    \\ '-'`        .___.--._)=========================|\n"
                                + "     \\            .'      |                          |\n"
                                + "      |     /,_.-'        |        FELICIDADES       |\n"
                                + "    _/   _.'(             |            HAZ           |\n"
                                + "   /  ,-' \\  \\            |           GANADO         |\n"
                                + "   \\  \\    `-'            |                          |\n"
                                + "    `-'                   '--------------------------'\n");
                    }

                    break;
                    
                case "m":
                    menu_pausa();
                    break;
                    
                default:
                    System.out.println("Ingresa la opcion correcta por favor.");
                    break;
            }
        }
    }    
    
    public void reiniciarJuego() {
        posicion = 0;
        jugadorfila = 7;
        jugadorcolumna = 7;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < jugador[i].length; j++) {
                if (jugador[i][j] == '@') {
                        jugador[i][j] = ' ';
                }
            }
        }
    }
    
    public static void reiniciarTablero(int[][] tablero, char [][] trampas) {

        int numeracion = 64;
        boolean verificador = true;
        
        for (int i = 0; i < tablero.length; i++) {
            if (verificador) {
                for (int j = tablero[i].length - 1; j >= 0; j--) {
                    tablero[i][j] = numeracion;
                    numeracion--;
                    verificador = false;
                }
            } else {
                for (int j = 0; j < tablero[i].length; j++) {
                    tablero[i][j] = numeracion;
                    numeracion--;
                }
                verificador = true;
            }
        }
        
        for (int i = 0; i < trampas.length; i++) {
            for (int j = 0; j < trampas[i].length; j++) {
                trampas[i][j] = ' ';     
            }  
        }
        
        for (int i = 0; i < trampas.length; i++) {
            int trampasGeneradas = 0;
            for (int j = 0; j < trampas[i].length; j++) {
                if (trampas[i][j] != '#') {
                    if (Math.random() * 10 < 6 && trampasGeneradas < 4) {
                        trampas[i][j] = '#';
                        trampasGeneradas++;
                    } else {
                        trampas[i][j] = ' ';
                    }
                }
            }
        }
    }
    
    int menu_principal(int opcion){

        boolean menu = true;
        
        while (menu){
            System.out.println("***********************************");
            System.out.println("*         MENU PRINCIPAL          *");
            System.out.println("***********************************");
            System.out.println("* 1. Iniciar Juego                *");
            System.out.println("* 2. Salir                        *");
            System.out.println("***********************************");
            System.out.print("Ingrese su opción: ");
            System.out.print("Ingrese un dato: ");
            if (accion.hasNextInt()) {
                opcion = accion.nextInt();
                switch (opcion) {
                    case 1:
                        reiniciarJuego();
                        reiniciarTablero(tablero, trampas);
                        jugador[jugadorfila][jugadorcolumna] = '@';
                        menu = false;
                        break;

                    case 2:
                        System.out.println("===================================");
                        System.out.println("|       ¡Gracias por jugar!       |");
                        System.out.println("|¡Esperamos verte de nuevo pronto!|");
                        System.out.println("===================================");
                        menu = false;
                        break;

                    default:
                        System.out.println("┌────────────────────────┐");
                        System.out.println("│         ¡Esta opcion no existe!        │");
                        System.out.println("└────────────────────────┘");
                        break;
                }
            } else if (accion.hasNext()) {
                String opcion3 = accion.next();
                
                switch (opcion3){
                    default:
                        System.out.println("┌────────────────────────┐");
                        System.out.println("│         ¡Esta opcion no existe!        │");
                        System.out.println("└────────────────────────┘");
                        break;
                }
            } else {
                System.out.println("┌────────────────────────┐");
                System.out.println("│         ¡Esta opcion no existe!        │");
                System.out.println("└────────────────────────┘");
            }

            
        }
        return opcion;
        
        
        
    }
    
    public void menu_pausa(){
        boolean menu_pausa = true;
        int opcion2 = 0;
        
        while (menu_pausa){
            System.out.println("***********************************");
            System.out.println("*         MENU PRINCIPAL          *");
            System.out.println("***********************************");
            System.out.println("* 1. Iniciar Juego Nuevo          *");
            System.out.println("* 2. Retomar Juego                *");
            System.out.println("* 3. Salir                        *");
            System.out.println("***********************************");
            System.out.print("Ingrese su opción: ");
            
            if (accion.hasNextInt()) {
                opcion2 = accion.nextInt();
                switch (opcion2) {
                    case 1:
                        menu_pausa = false;
                        reiniciarJuego();
                        reiniciarTablero(tablero, trampas);
                        jugador[jugadorfila][jugadorcolumna] = '@';
                        break;
                    case 2:
                        juego();
                        menu_pausa = false;

                        break;
                    case 3:
                        System.out.println("===================================");
                        System.out.println("|       ¡Gracias por jugar!       |");
                        System.out.println("|¡Esperamos verte de nuevo pronto!|");
                        System.out.println("===================================");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("┌────────────────────────┐");
                        System.out.println("│         ¡Esta opcion no existe!        │");
                        System.out.println("└────────────────────────┘");
                        break;
                }
            } else if (accion.hasNext()) {
                String opcion3 = accion.next();
                
                switch (opcion3){
                    default:
                        System.out.println("┌────────────────────────┐");
                        System.out.println("│         ¡Esta opcion no existe!        │");
                        System.out.println("└────────────────────────┘");
                        break;
                }
                
            } else {
                System.out.println("┌────────────────────────┐");
                System.out.println("│         ¡Esta opcion no existe!        │");
                System.out.println("└────────────────────────┘");
            }
            
            
        }
        
    }
    
    public static void main(String[] args) {
        Serpientes_y_Escaleras tablero = new Serpientes_y_Escaleras();
        
        boolean bucle = true;
        
        while(bucle){
            int opcion = 0;
            opcion = tablero.menu_principal(0);
            if(opcion == 1){
                tablero.juego();
            }else{
                bucle = false;
            }
        }
        
        

    }
    
}
