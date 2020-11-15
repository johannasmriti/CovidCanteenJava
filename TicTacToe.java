import java.util.*;
public class TicTacToe{    
    static ArrayList<Integer>playerPosition=new ArrayList<Integer>();
    static ArrayList<Integer>devicePosition=new ArrayList<Integer>();
    public static void main(String[] args){
        char[] [] gameBoard = {{' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '}};
        System.out.println("\n\t\t\t\t\tTIC TAC TOE");
        System.out.print("\n\t Player Symbol: X" );
        System.out.print("\n\t Player Symbol: O" );
        PrintGameBoard(gameBoard);
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("\n\t Enter place:");
            int playerPos = input.nextInt();
            while(playerPosition.contains(playerPos) || devicePosition.contains(playerPos))
            {
                System.out.print("\n\t Position taken! ENTER another position: ");
                playerPos=input.nextInt();
                break;
            }
            inputPosition(gameBoard, playerPos, "player");  
            Random rand = new Random();
            int devicePos = rand.nextInt(9)+1;
            while(playerPosition.contains(devicePos) || devicePosition.contains(devicePos)){
                devicePos = rand.nextInt(9)+1;
            }
            inputPosition(gameBoard, devicePos, "device");
            PrintGameBoard(gameBoard);
            checkWinner();
        }
        
    }    
    public static void PrintGameBoard(char[][] gameBoard){
        System.out.println();
        for(char[] row : gameBoard ){
          System.out.print("\n\t\t\t\t     ");
            for(char c : row ){
                
                System.out.print(c);
            }
        }
        System.out.println();
    }    
    public static void inputPosition(char[][] gameBoard,int pos,String user)
    {
        char symbol=' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPosition.add(pos);
        }
        else if(user.equals("device")){
            symbol = 'O';
            devicePosition.add(pos);
        }
        switch(pos){
            case 1:
              gameBoard[0][0]=symbol;
              break;
            case 2:
              gameBoard[0][2]=symbol;
              break;
            case 3:
              gameBoard[0][4]=symbol;
              break;
            case 4:
              gameBoard[2][0]=symbol;
              break;
            case 5:
              gameBoard[2][2]=symbol;
              break;
            case 6:
              gameBoard[2][4]=symbol;
              break;
            case 7:
              gameBoard[4][0]=symbol;
              break;
            case 8:
              gameBoard[4][2]=symbol;
              break;
            case 9:
              gameBoard[4][4]=symbol;
              break;
            default:
              break;
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftColumn = Arrays.asList(1,4,7);
        List midColumn = Arrays.asList(2,5,8);
        List rightColumn = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(7,5,3);
        List<List>winning=new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(leftColumn);
        winning.add(midColumn);
        winning.add(rightColumn);
        winning.add(diagonal1);
        winning.add(diagonal2);     
        for(List l : winning){
            if(playerPosition.containsAll(l)){
              System.out.println("\n\t Congratulations you won!");
              System.exit(0);
            }
            else if(devicePosition.containsAll(l)){
              System.out.println("\n\t Try again next time!");
              System.exit(0);
            }
            else if(playerPosition.size()+devicePosition.size()==9){
              System.out.println("\n\t Its a TIE"); 
              System.exit(0);
            }
        }
        return "";
    }
}
