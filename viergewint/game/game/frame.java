package game;
import java.util.Scanner;
public class frame 
    {
        static Scanner scanner = new Scanner(System.in);
        static String clear;
        static field feld;
        public static void main(String[] args)
        {
            clear = "";
            for (int i = 0; i < 10; i++) 
            {
                clear += '\n';
            }
            scriptstarten();
        }

        public static void scriptstarten()
        {
            /*this is the starting screen */
            System.out.print("Welcome to conect 4" + '\n');
            System.out.println("");
            System.out.println("What do you want to do?");
            System.out.println("");
            System.out.println("1 Start new game");
            System.out.println("2 about the game/help");
            System.out.println("3 credits");
            System.out.println("4 Exit the Programm");
            System.out.print("Typ in your number: ");
            int in = scanner.nextInt();
            switch (in)
            {
                case 1:
                    System.out.println(clear);
                    scriptgameen();
                    break;
                    
                case 2:
                
                    System.out.println(clear);
                    abouten();
                    break;

                case 3:
                    System.out.println(clear);
                    credits();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Goodbye, until next time");
                    break;
                
                default:
                    System.out.println("");
                    System.out.println("Number is out of bounds, please select a new one");
                    scriptstarten();
                    break;
            }
        }
        
        public static void scriptgameen()
        {
            /*
             * Emulates the game 
             */
            feld = new field();
            System.out.print("What is the name of the first player: ");
            String player1 = scanner.next();
            System.out.println("");
            System.out.print("What is the name of the second player: ");
            String player2 = scanner.next();
            System.out.println("");
            System.out.println(clear);
            int collum = 1;
            int winning = 0;
            while (!feld.win(collum, 2) && winning == 0) 
            { 
                System.out.println(player1 + " Its your turn");
                System.out.print("in what collum do you want to insert your stone: ");
                collum = scanner.nextInt();
                System.out.println("");
                if (feld.turn(collum, 1))
                {
                    System.out.println(feld.show());
                }
                else
                {
                    System.out.println("The collum is full, your turn will be skiped");
                    
                }
                if (!feld.win(collum, 1))
                {
                    System.out.println(player2 + " Its your turn");
                    System.out.print("in what collum do you want to insert your stone: ");
                    collum = scanner.nextInt();
                    System.out.println("");
                    if (feld.turn(collum, 2))
                    {
                        System.out.println(feld.show());
                    }
                    else
                    {
                        System.out.println("The collum is full, your turn will be skiped");
                    }
                }
                else
                {
                    winning = 1;
                }
                
            }  
            
             
        }

        public static void credits()
        {
            /*
             * Outputs a text with the credits
             */
            System.out.println("This game was made by axis_alexis");
            System.out.println("Programm used to write the code: Visual Studio Code");
            System.out.println("Language used: Java");
            contin();

            System.out.println("What do you want to do?");
            System.out.println("");
            System.out.println("1 Start new game");
            System.out.println("2 about the game");
            System.out.println("3 Exit the Programm");
            System.out.print("Typ in your number: ");
            int in = scanner.nextInt();
            switch (in)
            {
                case 1:
                    System.out.println(clear);
                    scriptgameen();
                    break;
                    
                case 2:
                
                    System.out.println(clear);
                    abouten();
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("Goodbye, until next time");
                    break;
                
                default:
                    System.out.println("");
                    System.out.println("Number is out of bounds, please select a new one");
                    abouten();
                    break;
            }
        }

        public static void abouten()
        {
            //Tells you something about the game
            System.out.println("This is Conect 4");
            System.out.println("Like the title says, you need to conect four pices to win");
            System.out.println("the connection can be made diaogani, verticaly or horonzontaly");
            System.out.println("You can insert one stone at a time. During your turn, you can pick a collum");
            System.out.println("your stone will fall towards the bottom");
            System.out.println("");
            contin();
            System.out.println("What do you want to do?");
            System.out.println("");
            System.out.println("1 Start new game");
            System.out.println("2 Credits");
            System.out.println("3 Exit the Programm");
            System.out.print("Typ in your number: ");
            int in = scanner.nextInt();
            switch (in)
            {
                case 1:
                    System.out.println(clear);
                    scriptgameen();
                    break;
                    
                case 2:
                
                    System.out.println(clear);
                    credits();
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("Goodbye, until next time");
                    break;
                
                default:
                    System.out.println("");
                    System.out.println("Number is out of bounds, please select a new one");
                    abouten();
                    break;
            }
        }

        private static void scriptwinen(String name)
        {
            /*
             * Is put out after winning
             */
           System.out.println(clear);
           System.out.println("Player: " + name + " has won");
           System.out.println("");
           System.out.println(feld.show());
           System.out.println("");
           contin();
           System.out.println("What do you want to do?");
            System.out.println("");
            System.out.println("1 Start new game");
            System.out.println("2 Credits");
            System.out.println("3 Exit the Programm");
            System.out.print("Typ in your number: ");
            int in = scanner.nextInt();
            switch (in)
            {
                case 1:
                    System.out.println(clear);
                    scriptgameen();
                    break;
                    
                case 2:
                
                    System.out.println(clear);
                    credits();
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("Goodbye, until next time");
                    break;
                
                default:
                    System.out.println("");
                    System.out.println("Number is out of bounds, please select a new one");
                    abouten();
                    break;

            }
        }

        private static void contin()
        {
            //* This function is just a prozess to wait for a key input to continue */
            System.out.println("");
            System.out.println("Press any symbol and enter to continue");
            scanner.next();
            System.out.println("");
        }
    }
