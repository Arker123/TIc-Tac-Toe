import java.util.*;
public class TicTacToe {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nWelcome to Tic Tac Toe\n");

        System.out.println("Choose: \n      1. Player vs Player\n      2. Player vs Computer\n Option: ");
        int choose = sc.nextInt();

        if(choose == 1)
        {
            System.out.println("Player 1 <X>  -  Player 2 <O>\n");
            System.out.println("Board numbers are as follows: \n    1 | 2 | 3 \n    4 | 5 | 6 \n    7 | 8 | 9\n\n");

            int[] arr = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

            int turn = 0;
            int won = 0;

            int moves = 0;

            while(moves < 9)
            {
                if(turn == 0)
                {
                    System.out.println("Player 1 turn");
                }
                else
                {
                    System.out.println("Player 2 turn");
                }

                System.out.print("Enter your desired location [1-9] : ");
                int choice = sc.nextInt();
                if(arr[choice - 1] != -1)
                {
                    System.out.println("Please choose another location");
                    continue;
                }
                else
                {
                    moves = moves + 1;
                }

                if(turn == 1)
                {
                    arr[choice - 1] = 1;
                    turn = 0;
                }
                else
                {
                    arr[choice - 1] = 0;
                    turn = 1;
                }
                display(arr);

                won = isFinished(arr);
                if(won == 0)
                {
                    System.out.println("Player 1 won the match");
                    break;
                }
                else if(won == 1)
                {
                    System.out.println("Player 2 won the match");
                    break;
                }
            }

            if(moves == 9)
            {
                System.out.println("The match is a tie");
            }
        }
        else if(choose == 2)
        {
            System.out.println("Player <X>  -  Computer <O>\n");
            System.out.println("Board numbers are as follows: \n    1 | 2 | 3 \n    4 | 5 | 6 \n    7 | 8 | 9\n\n");

            int[] arr = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

            int turn = 0;
            int won = 0;

            int moves = 0;

            while(moves < 9)
            {
                int choice;
                if(turn == 0)
                {
                    System.out.println("Player's turn");
                    System.out.print("Enter your desired location [1-9] : ");
                    choice = sc.nextInt();
                }
                else
                {
                    System.out.println("Computer's turn");
                    choice = predictMove(arr);
                    System.out.println("The computer chose: " + choice);
                }

                if(arr[choice - 1] != -1)
                {
                    System.out.println("Please choose another location");
                    continue;
                }
                else
                {
                    moves = moves + 1;
                    //System.out.println(moves);
                }

                if(turn == 1)
                {
                    arr[choice - 1] = 1;
                    turn = 0;
                }
                else
                {
                    arr[choice - 1] = 0;
                    turn = 1;
                }
                display(arr);

                won = isFinished(arr);
                if(won == 0)
                {
                    System.out.println("Player 1 won the match");
                    break;
                }
                else if(won == 1)
                {
                    System.out.println("Computer won the match");
                    break;
                }

                
            }

            if(moves == 9)
            {
                System.out.println("The match is a tie");
            } 
        }
        else
        {
            System.out.println("Invalid option");
        }
    }

    public static void display(int[] arr)
    {
        for(int i=0;i<9;i++)
        {
            if(arr[i] != -1)
            {
                if((i+1)%3 == 0)
                {
                    if(arr[i] == 0)
                    {
                        System.out.print(" X ");
                    }
                    else
                    {
                        System.out.print(" O ");
                    }
                }
                else
                {
                    if(arr[i] == 0)
                    {
                        System.out.print(" X |");
                    }
                    else
                    {
                        System.out.print(" O |");
                    }
                }
            }
            else
            {
                if((i+1)%3 == 0)
                {
                    System.out.print("   ");
                }
                else
                {
                    System.out.print("   |");
                }
                
            }
            if((i+1)%3 == 0)
            {
                System.out.println();
            }
        }
        System.out.println();
    }
    public static int isFinished(int[] arr)
    {
        int w = -1;
        if((arr[0] == 0 && arr[1] == 0 && arr[2] == 0) || (arr[3] == 0 && arr[4] == 0 && arr[5] == 0) || (arr[6] == 0 && arr[7] == 0 && arr[8] == 0) || (arr[0] == 0 && arr[3] == 0 && arr[6] == 0) || (arr[1] == 0 && arr[4] == 0 && arr[7] == 0) || (arr[2] == 0 && arr[5] == 0 && arr[8] == 0) || (arr[0] == 0 && arr[4] == 0 && arr[8] == 0) || (arr[2] == 0 && arr[4] == 0 && arr[6] == 0))
        {
            return 0;
        }
        if((arr[0] == 1 && arr[1] == 1 && arr[2] == 1) || (arr[3] == 1 && arr[4] == 1 && arr[5] == 1) || (arr[6] == 1 && arr[7] == 1 && arr[8] == 1) || (arr[0] == 1 && arr[3] == 1 && arr[6] == 1) || (arr[1] == 1 && arr[4] == 1 && arr[7] == 1) || (arr[2] == 1 && arr[5] == 1 && arr[8] == 1) || (arr[0] == 1 && arr[4] == 1 && arr[8] == 1) || (arr[2] == 1 && arr[4] == 1 && arr[6] == 1))
        {
            return 1;
        }
        return -1;
    }
    public static int predictMove(int[] arr)
    {
        if((arr[0] == -1 && arr[1] == 0 && arr[2] == 0) || (arr[0] == -1 && arr[3] == 0 && arr[6] == 0) || (arr[0] == -1 && arr[4] == 0 && arr[8] == 0))
        {
            return 1;
        }
        if((arr[2] == -1 && arr[0] == 0 && arr[1] == 0) || (arr[2] == -1 && arr[5] == 0 && arr[8] == 0) || (arr[2] == -1 && arr[4] == 0 && arr[6] == 0))
        {
            return 3;
        }
        if((arr[6] == -1 && arr[0] == 0 && arr[3] == 0) || (arr[6] == -1 && arr[7] == 0 && arr[8] == 0) || (arr[6] == -1 && arr[4] == 0 && arr[2] == 0))
        {
            return 7;
        }
        if((arr[8] == -1 && arr[5] == 0 && arr[2] == 0) || (arr[8] == -1 && arr[7] == 0 && arr[6] == 0) || (arr[8] == -1 && arr[4] == 0 && arr[0] == 0))
        {
            return 9;
        }
        if((arr[1] == -1 && arr[0] == 0 && arr[2] == 0) || (arr[1] == -1 && arr[4] == 0 && arr[7] == 0))
        {
            return 2;
        }
        if((arr[3] == -1 && arr[0] == 0 && arr[6] == 0) || (arr[3] == -1 && arr[4] == 0 && arr[5] == 0))
        {
            return 4;
        }
        if((arr[5] == -1 && arr[8] == 0 && arr[2] == 0) || (arr[5] == -1 && arr[4] == 0 && arr[3] == 0))
        {
            return 6;
        }
        if((arr[7] == -1 && arr[6] == 0 && arr[8] == 0) || (arr[7] == -1 && arr[4] == 0 && arr[1] == 0))
        {
            return 8;
        }
        if((arr[4] == -1 && arr[0] == 0 && arr[8] == 0) || (arr[4] == -1 && arr[7] == 0 && arr[1] == 0) || (arr[4] == -1 && arr[2] == 0 && arr[6] == 0) || (arr[4] == -1 && arr[3] == 0 && arr[5] == 0))
        {
            return 9;
        }
        if(arr[4] == -1)
        {
            return 5;
        }
        else
        {
            for(int i=0;i<9;i++)
            {
                if(arr[i] == -1)
                    return i+1;
            }
        }
        return -1;
    }
}
//checks for same
// 0 1 2
// 3 4 5
// 6 7 8