import java.util.*;
class Hangman {
  public static void main(String[] args) {   
    Scanner sc= new Scanner(System.in); 
    String str1="GRDLAB";
    String str2="INTERAMS";
    String str3="SKYWALK";
    String str4="TEKMUSIC";
    String str5="EXAMLY";
    String hangword;
    int i, j,a,err,flag,k,l,d,FINAL; 
    System.out.print("\033[H\033[2J");  
    System.out.flush();    
    System.out.println("");
    System.out.println("Congragulations on clearing level 2 of the Memory game");
    System.out.println("You will now be challenged in a game of Hangman");
    System.out.println("");
    System.out.println("RULES:");
    System.out.println("");
    System.out.println("1.A word will be choosen and a small clue regarding the same will be given");
    System.out.println("2.You can make only upto 7 wrong gueses after which the game terminates and you move on to the next level of the memory game ");
    System.out.println("3.All the words are related to PSG Tech so it should'nt be too hard.");
    System.out.println("4.That's it! Now you will choose a number which will generate the word and the game will begin");
    System.out.println("5.Please enter the letters you guess in UPPERCASE");
    System.out.println("");
    System.out.println("ALL THE BEST ");
    System.out.println("");
    System.out.println("Choose a number between 1-5");
    err=0;
    a= sc.nextInt();  
    switch(a){
      case 1:
        System.out.println("Clue: If your in the Computer Science Department you were in this room A LOT.");
        hangword=str1;
        break;
      case 2:
        System.out.println("Clue: Those few days when there is no class but you still go to college");
        hangword=str2;
        break;
      case 3:
        System.out.println("Clue: This is an iconic part of not just our college but possibly the whole of Coimbatore");
        hangword=str3;
        break;
      case 4:
        System.out.println("Clue: Any to almost all college events arent completed without this group showing up and putting up a show");
        hangword=str4;
        break;
      case 5:
        System.out.println("Clue: Your online semester was made hard by this unexpected guest");
        hangword=str5;
        break;
      default:
        System.out.println("Number not between 1-5. A random word has been choosen for you by default");
        System.out.println("Clue: Your online semester was made hard by this unexpected guest");
        hangword=str5;
        break;
    }
    System.out.println("");
    System.out.println("The game now begins");
    System.out.println("");
    System.out.println("Your word:");
    j=hangword.length();
    char[] history = new char[j];
    for(i=0;i<j;i++){
       System.out.print("* ");
    }
    System.out.println("");
    System.out.println("");
    d=0;
    while(err<7){  
        System.out.println("");
        System.out.println("GUESS LETTER IN UPPERCASE");    
        char c = sc.next().charAt(0); 
        flag=0;
        for(i=0;i<j;i++)
        {
            if(c==hangword.charAt(i)){
              System.out.print(" "+c );
              System.out.print(" ");
              flag=1;
              history[i]=c;
            }
            else{
              System.out.print(" * ");
              
            }
        }
        System.out.println("");       
      if(flag==0){
       err=err+1;
        switch(err){
          case 1:
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
            break;
          case 2:
            //System.out.print("\033[H\033[2J");  
            //System.out.flush();
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
            break;
          case 3:
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
            break;
          case 4:
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
            break;
          case 5:
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
            break;
          case 6:
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");

            break;
          case 7:
            System.out.println("GAME OVER!");
            System.out.println("The word was "+hangword);
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            break;
       
      }      
      } 
      else{
         System.out.println("Thats correct! Keep on going");
         d=d+1;
         for (char s:history) {
            System.out.print(s + "  "); 
         }
         FINAL=0;
         for(i=0;i<j;i++){   
            if(history[i]==hangword.charAt(i))
            FINAL=FINAL+1;
            if(FINAL==hangword.length()){
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println( " Thats right! ");
            System.out.println( " The word was  "+hangword);
            System.out.println( " CONGRAGULATIONS!!! "); 
            System.out.println( " You have won this game!");

            System.out.println( " NEXT LEVEL OF MEMORY GAME COMING UP ")
            ;  
            System.out.println( " ALL THE BEST!!"); 
            err=8;
            break;          
          }
        }  
        }
     if(err==8)
          break;    
    }
  }
}
