package game;

public class field
{
    
    static public int[][] field;

    public field()
    {
        field = new int[7][7];
    }

    public boolean  turn(int collum, int player)
    {
        /*
         * This function is used to emulate a turn
         */
        collum = collum - 1;
        boolean temp = false; //a variable to check if a space is free in this collum
        int i = field.length - 1;
        while (!temp && i >= 0) 
        { 
            if (field[i][collum] == 0)
            {
                temp = true;
                field[i][collum] = player;
            }
            i = i - 1;
        }
        return temp;
        /*
         * if temp true = There is space and a stone is set
         * if temp false = There is no space in the collum
         */
    }
    public boolean win(int collum, int player)
    {
        /*
         * This function is used to check if the player has won
         */
        //System.out.println("win.start");
        boolean win = false;
        collum = collum - 1;
        boolean temp = false; //a variable to check if a space is free in this collum
        int i = field.length - 1;
        int fourhor = 0;
        while (!win && i >= 0) 
        { 
            //System.out.println("while beginn");
            if (field[i][collum] == player)
            {
                /*
                 * Checks if there are 4 Stones horizontal
                */
                fourhor = fourhor + 1;
                
                //System.out.println("There is a Stone from Player " + player);
                //System.out.println("fourhor = " + fourhor);
            }
            else
            {
                fourhor = 0;
            }
            if (field[i][collum] == player && collum + 1 < field[2].length && field[i][collum+1] == player && collum + 2 < field[2].length && field[i][collum+2] == player && collum + 3 < field[2].length && field[i][collum+3] == player)
            {
                /*
                 * vertical right
                 */
                //System.out.println("Win vertical right");
                //System.out.println("Player " + player + " has won");
                win = true;

            }
            else
            {
                if (field[i][collum] == player && collum - 1 >= 0 && field[i][collum-1] == player && collum - 2 >= 0 && field[i][collum-2] == player && collum -3 >= 0 && field[i][collum-3] == player)
                {
                    /*
                     * vertical left
                     */
                    //System.out.println("Win vertical left");
                    //System.out.println("Player " + player + " has won");
                win = true;
                }
                else
                {
                    if (field[i][collum] == player && collum + 1 < field[2].length && i + 1 < field.length && field[i+1][collum+1] == player && collum + 2 < field[2].length && i + 2 < field.length && field[i+2][collum+2] == player && i + 3 < field.length  && collum + 3 < field[2].length && field[i+3][collum+3] == player)
                    {
                        /*
                         * Dioganal down right
                         */
                        win = true;
                    }
                    else
                    {
                        if (field[i][collum] == player && collum - 1 >= 0 && i + 1 < field.length && field[i+1][collum-1] == player && collum - 2 >= 0 && i + 2 < field.length && field[i+2][collum-2] == player && i + 3 < field.length  && collum -3 >= 0 && field[i+3][collum-3] == player)
                        {
                            /*
                             * Diaogonal down left
                             */
                            win = true;
                        }
                        else
                        {
                            if (field[i][collum] == player && collum + 1 < field[2].length && i - 1 >= 0 && field[i-1][collum+1] == player && collum + 2 < field[2].length && i - 2 >= 0 && field[i-2][collum+2] == player && i -3 >= 0  && collum + 3 < field[2].length && field[i-3][collum+3] == player)
                            {
                                /*
                                 * Diaogonal up right
                                 */
                                win = true;
                            }
                            else
                            {
                                if (field[i][collum] == player && collum - 1 >= 0 && i - 1 >= 0 && field[i-1][collum-1] == player && collum - 2 >= 0 && i - 2 >= 0 && field[i-2][collum-2] == player && i - 3 >= 0 && collum - 3 >= 0 && field[i-3][collum-3] == player)
                                {
                                    /*
                                     * Diaogonal up left
                                     */
                                    win = true;
                                }
                            }
                        }
                    }
                }    
            }
            if (fourhor >= 4)
            {
                //System.out.println("Player " + player + " has won");
                win = true;
            }
            i = i - 1;
            //System.out.println("while end");
        }
        return win;
    }

    public String show()
    {
        /*
         * Shows of the field as a String
         */
        String feld = "";

        for (int x = 0; x < field[2].length; x++)
        {
            feld = feld + "| ";
            for (int y = 0; y < field.length; y++) 
            {
                feld = feld + field[x][y] + " ";
            }
            feld = feld + "|"+ '\n';
        }
        return feld;
    }

}
