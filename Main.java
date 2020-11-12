import java.util.*;
import java.io.*;

class sleep {
  void sleepfor(int n) {
    try {
      Thread.sleep(1000*n);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
class clrscr{
  public static void cls(){
    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
  }
}
class getchar
{
    public static void getch()
    {
      Scanner s = new Scanner(System.in);
      String ch = s.nextLine();
    }
}

class Memory{
  Scanner input = new Scanner(System.in);
  sleep s= new sleep();
  getchar g = new getchar();
  clrscr c=new clrscr();
  
  void LevelOne(){
    c.cls();
    Random rand = new Random(); 
      int[][] matrix = new int[2][2];
      for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
        	matrix[i][j]=rand.nextInt(40);
        }
      }
      System.out.println("\n\n 'CONCENTRATION is the root of all higher abilities in a man.'");
      System.out.println("\t\t\t\t\t -----Bruce Lee-----");
      System.out.println("\n\n\n\t\t\t\t\t  LEVEL ONE!");
      System.out.println("\t\tYOU WILL BE GIVEN A 2x2 GRID OF INTEGERS.");
      System.out.println("\t\t\t\tTIME LIMIT: 5 SECONDS");
      System.out.println("\t\t\t\t\t  ALL THE BEST!");
      s.sleepfor(1);
      System.out.print("\n\t\t\t\t\t  |----|----| ");
      for(int i=0;i<2;i++){
        System.out.print("\n\t\t\t\t\t  |");
        for(int j=0;j<2;j++){
        	System.out.print(" ");
          System.out.print(String.format("%02d", matrix[i][j]));
          System.out.print(" |");
        }
        System.out.print("\n\t\t\t\t\t  |----|----|");
      }
      System.out.print("\n\n\n\t\t\t\t  Time Left 5 ");
      for(int i=4;i>0;i--)
      {
        s.sleepfor(1);
        System.out.print(i+" ");
      }
      System.out.println("\n\t\t\t\t\t   TIMES UP!!!");
      s.sleepfor(1);
      c.cls();
      System.out.println("\n\n\n\n\n\n\t\t\t\tEnter all the Integers in order \n");
      int[][] ans = new int[2][2];
      int flag=0;
      for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
          System.out.print("\t\t\t\t\t\t\t  ");
            ans[i][j]=input.nextInt();
          if(ans[i][j]!=matrix[i][j]){
            System.out.println("\n\t\t\t\t\t\t WRONG ANSWER!\n\t\t\t\t  PROGRAM WILL BE TERMINATED");
            flag=flag+1;
            break;
          }
        }
      }
      if(flag==0){
        System.out.println("\n\t\t\t\t\tGOOD JOB! CORRECT ANSWER!");
        System.out.println("\n\t\t\t\tNOW YOU HAVE UNLOCKED TIC TAC TOE");
      }
      s.sleepfor(3);
      LevelTwo();
  }
  
  
  void LevelTwo(){
    c.cls();
    Random rand = new Random(); 
    int[][] matrix = new int[3][3];
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        matrix[i][j]=rand.nextInt(40);
      }
    }
    System.out.println("\n\n 'CONCENTRATION is the root of all higher abilities in a man.'");
        System.out.println("\t\t\t\t\t -----Bruce Lee-----");
        System.out.println("\n\n\n\t\t\t\t\t  LEVEL TWO!");
        System.out.println("\t\tYOU WILL BE GIVEN A 3x3 GRID OF INTEGERS.");
        System.out.println("\t\t\t\tTIME LIMIT: 9 SECONDS");
        System.out.println("\t\t\t\t\t  ALL THE BEST!");
        s.sleepfor(1);
    String lineSplit = "";
    int k=0;
    StringJoiner splitJoiner = new StringJoiner("|", "|", "|");
    for (int index = 0; index < matrix[0].length; index++) {
        splitJoiner.add(String.format("%4s", "").replace(" ", "-"));
    }
    lineSplit = splitJoiner.toString();
    for (int[] row : matrix) {
        k++;
        System.out.print("\n\t\t\t\t     ");
        StringJoiner sj = new StringJoiner(" | ", "| ", " |");
        for (int col : row) {
          
            sj.add(String.format("%02d", col));
        }
        System.out.println(lineSplit);
        System.out.print("\t\t\t\t     ");
        if(k!=3){
        System.out.print(sj.toString());
        System.out.print("\t\t\t\t     ");
        }
        else{
          System.out.print(sj.toString());
        System.out.print("\n\t\t\t\t     ");
        }
    }
    System.out.print(lineSplit);
    System.out.print("\n\n\n\t\t\t\t  Time Left 9 ");
      for(int i=8;i>0;i--)
      {
        s.sleepfor(1);
        System.out.print(i+" ");
      }
      System.out.println("\n\t\t\t\t\t   TIMES UP!!!");
      s.sleepfor(1);
      c.cls();
      System.out.println("\n\n\n\n\n\n\t\t\t\tEnter all the Integers in order \n");
      int[][] ans = new int[3][3];
      int flag=0;
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
          System.out.print("\t\t\t\t\t\t\t  ");
            ans[i][j]=input.nextInt();
          if(ans[i][j]!=matrix[i][j]){
            System.out.println("\n\t\t\t\t\t\t WRONG ANSWER!\n\t\t\t\t  PROGRAM WILL BE TERMINATED");
            flag=flag+1;
            break;
          }
        }
      }
      if(flag==0){
        System.out.println("\n\t\t\t\t\tGOOD JOB! CORRECT ANSWER!");
        System.out.println("\n\t\t\t\tNOW YOU HAVE UNLOCKED HANGMAN");
      }
      s.sleepfor(3);
      LevelThree();
 }

 void LevelThree(){
    c.cls();
    Random rand = new Random(); 
    int[][] matrix = new int[4][4];
    for(int i=0;i<4;i++){
      for(int j=0;j<4;j++){
        matrix[i][j]=rand.nextInt(40);
      }
    }
    System.out.println("\n\n 'CONCENTRATION is the root of all higher abilities in a man.'");
        System.out.println("\t\t\t\t\t -----Bruce Lee-----");
        System.out.println("\n\n\n\t\t\t\t\t  LEVEL THREE!");
        System.out.println("\t\tYOU WILL BE GIVEN A 4x4 GRID OF INTEGERS.");
        System.out.println("\t\t  MAXIMUM NUMBER OF CORRECT SHOULD BE 9.");
        System.out.println("\t\t\t\tTIME LIMIT: 16 SECONDS");
        System.out.println("\t\t\t\t\t  ALL THE BEST!");
        s.sleepfor(1);
    String lineSplit = "";
    int k=0;
    StringJoiner splitJoiner = new StringJoiner("|", "|", "|");
    for (int index = 0; index < matrix[0].length; index++) {
        splitJoiner.add(String.format("%4s", "").replace(" ", "-"));
    }
    lineSplit = splitJoiner.toString();
    for (int[] row : matrix) {
        k++;
        System.out.print("\n\t\t\t\t  ");
        StringJoiner sj = new StringJoiner(" | ", "| ", " |");
        for (int col : row) {
          
            sj.add(String.format("%02d", col));
        }
        System.out.println(lineSplit);
        System.out.print("\t\t\t\t  ");
        if(k!=4){
        System.out.print(sj.toString());
        System.out.print("\t\t\t\t  ");
        }
        else{
          System.out.print(sj.toString());
        System.out.print("\n\t\t\t\t  ");

        }

    }
    System.out.print(lineSplit);
    System.out.print("\n\n\n  Time Left 16 ");
      for(int i=15;i>0;i--)
      {
        s.sleepfor(1);
        System.out.print(i+" ");
      }
      System.out.println("\n\t\t\t\t\t   TIMES UP!!!");
      s.sleepfor(1);
      c.cls();
      System.out.println("\n\n\n\n\n\n\t\t\t\tEnter all the Integers in order \n");
      int[][] ans = new int[4][4];
      int flag=0;
      for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
          System.out.print("\t\t\t\t\t\t\t  ");
            ans[i][j]=input.nextInt();
          if(ans[i][j]==matrix[i][j]){
            flag=flag+1;
            
          }
        }
      }
      if(flag>=9){
        System.out.println("\n\t\t\t\t\tGOOD JOB! CORRECT ANSWER!");
        System.out.println("\n\t\t\t\tNOW YOU HAVE UNLOCKED SNAKE GAME");
      }
      else{
        
        System.out.println("\n\t\t\t\t\t\t WRONG ANSWER!\n\t\t\t\t PROGRAM WILL BE TERMINATED");
      }
      s.sleepfor(3);
      LevelFour();
 }

 void LevelFour(){
    c.cls();
    Random rand = new Random(); 
    int[][] matrix = new int[5][5];
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        matrix[i][j]=rand.nextInt(40);
      }
    }
    System.out.println("\n\n 'CONCENTRATION is the root of all higher abilities in a man.'");
        System.out.println("\t\t\t\t\t -----Bruce Lee-----");
        System.out.println("\n\n\n\t\t\t\t\t  LEVEL FIVE!");
        System.out.println("\t\tYOU WILL BE GIVEN A 5x5 GRID OF INTEGERS.");
        System.out.println("\t\t  MAXIMUM NUMBER OF CORRECT SHOULD BE 15.");
    
        System.out.println("\t\t\t\tTIME LIMIT: 28 SECONDS");
        System.out.println("\t\t\t\t\t  ALL THE BEST!");
        s.sleepfor(1);
    String lineSplit = "";
    int k=0;
    StringJoiner splitJoiner = new StringJoiner("|", "|", "|");
    for (int index = 0; index < matrix[0].length; index++) {
        splitJoiner.add(String.format("%4s", "").replace(" ", "-"));
    }
    lineSplit = splitJoiner.toString();
    for (int[] row : matrix) {
        k++;
        System.out.print("\n\t\t\t     ");
        StringJoiner sj = new StringJoiner(" | ", "| ", " |");
        for (int col : row) {
          
            sj.add(String.format("%02d", col));
        }
        System.out.println(lineSplit);
        System.out.print("\t\t\t     ");
        if(k!=5){
        System.out.print(sj.toString());
        System.out.print("\t\t\t     ");
        }
        else{
          System.out.print(sj.toString());
        System.out.print("\n\t\t\t     ");

        }

    }
    System.out.print(lineSplit);
    System.out.print("\n\n\n  Time Left 28 ");
      for(int i=27;i>0;i--)
      {
        s.sleepfor(1);
        System.out.print(i+" ");
      }
      System.out.println("\n\t\t\t\t\t   TIMES UP!!!");
      s.sleepfor(1);
      c.cls();
      System.out.println("\n\n\n\n\n\n\t\t\t\tEnter all the Integers in order \n");
      int[][] ans = new int[5][5];
      int flag=0;
      for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
          System.out.print("\t\t\t\t\t\t\t  ");
            ans[i][j]=input.nextInt();
          if(ans[i][j]==matrix[i][j]){
            flag=flag+1;
            
          }
        }
      }
      if(flag>=15){
        System.out.println("\n\t\t\t\t\tGOOD JOB! CORRECT ANSWER!");
        System.out.println("\n\t\t\t\tNOW YOU HAVE UNLOCKED SNAKE AND LADERS");
      }
      else{
        System.out.println("\n\t\t\t\t\t\t WRONG ANSWER!\n\t\t\t\t  PROGRAM WILL BE TERMINATED");
      }
      s.sleepfor(3);
 }
  

  void start(){
     System.out.println("\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t WELCOME");
     System.out.println("\t\t\t\t  To The Worlds Best Memory Game!");
     System.out.print("\n\n\n\n\n\t\t\t\t\t\t\tLoading .");
     for(int i=0;i<6;i++)
     {
       s.sleepfor(1);
       System.out.print(".");
     }
     rule();
  }
  void rule(){
    c.cls();
    System.out.println();
    System.out.println("\t\t\t\t\t\t This is group 3");
    System.out.println("\n\tTeam members: ");
    System.out.println("\n\t\t1. Anita Priyadharshini - 19z202");
    System.out.println("\t\t2. R.Divya Dharshini - 19z211");
    System.out.println("\t\t3. Johanna Smriti - 19z218");
    System.out.println("\t\t4. M.Keerthna - 19z225");
    System.out.println("\t\t5. Pranitha V.S. - 19z235");
    System.out.println();
    System.out.println("RULES: ");
    System.out.println("\nThis is a memorising game  ");
    System.out.println("Here you are given with a time limit to memorise the numbers in grid.");
    System.out.println("\nFor every correct answers you will be awarded with 3 points.");
    System.out.println("\nThere are 4 levels in this game : ");
    System.out.println("  Level 1 -> 2 x 2 grid");
    System.out.println("  If you clear this level you will be taken to Tic-Tac toe game.");
    System.out.println("\n  Level 2 -> 3 x 3 grid");
    System.out.println("  If you clear this level you will be taken to HANGMAN game.");
    System.out.println("\n  Level 3 -> 4 x 4 grid");
    System.out.println("   If you clear this level you will be taken to SNAKE game.");
    System.out.println("\n  Level 4 -> 5 x 5 grid");
    System.out.println("  If you clear this level you will be taken to SNAKE AND LADERS game.");

    System.out.print("\n\n\n\n\nPress Enter to start the game.");
    g.getch();
    c.cls();

    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t Level one .");
    for(int i=0;i<5;i++)
     {
       s.sleepfor(1);
       System.out.print(".");
     }
     c.cls();
     LevelOne();
  }

}

class Main  {
  public static void main(String[] args) {
    sleep s= new sleep();
    clrscr c=new clrscr();
    c.cls();
    Memory m= new Memory(); 
    m.start(); 
    //m.LevelFour();
    //s.sleepfor(5);
    //c.cls();
  }
}
