
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class App {

  static ArrayList<Integer> posiçõesJogador= new ArrayList<Integer>();
  static ArrayList<Integer> posiçõesCpu= new ArrayList<Integer>();
    public static void main(String[] args) throws Exception {
     
char [] [] boardGame = {{' ', '|', ' ', '|', ' '},
  {'-', '+', '-', '+', '-'},
  {' ', '|', ' ', '|', ' '},
  {'-', '+', '-', '+', '-'},
  {' ', '|', ' ', '|', ' '}};

  printboardGame(boardGame);
  
   while(true){ 
  Scanner scan = new Scanner(System.in);    
  System.out.println("Digite sua posição (1-9)");
  int position = scan.nextInt();

  while(posiçõesJogador.contains(position) || posiçõesCpu.contains(position)){
   System.out.println("Posição Ocupada! Selecione uma posição vazia");
    position = scan.nextInt();
  }
    
  System.out.println(position);
  
 posLocal(boardGame, position, "player");
 String resultado = checkVencedor();
 if(resultado.length() > 0){
   System.out.println(resultado);
   break;
 }

 Random rand = new Random();
 int cpuPos = rand.nextInt(9) + 1;
 while(posiçõesCpu.contains(position) || posiçõesCpu.contains(posiçõesCpu)){
  System.out.println("Posição Ocupada! Selecione uma posição vazia");
   position = scan.nextInt();
 }
  posLocal(boardGame, cpuPos, "cpu");
  printboardGame(boardGame);
       
 resultado = checkVencedor();
if(resultado.length() > 0){
  System.out.println(resultado);
  break;
}
  
      
    }
   }
   
  public static void printboardGame(char [][] boardGame){
    for(char [] row : boardGame){
        for(char c : row){
            System.out.print(c);
        }
        System.out.println();
     }

  }

  

  public static void posLocal(char [] [] boardGame,int position, String user){
    
    char symbol =' ';
    
    if(user.equals("player")) {
        symbol = 'X';
        posiçõesJogador.add(position);
    } else if(user.equals("cpu")){
        symbol = 'O';
        posiçõesCpu.add(position);
    }
    
    
    switch(position){
        case 1:
        boardGame[0][0] = symbol;
        break;  
        case 2:
        boardGame[0][2] = symbol;
        break;
        case 3:
        boardGame[0][4] = symbol;
        break;
        case 4:
        boardGame[2][0] = symbol;
        break;
        case 5:
        boardGame[2][2] = symbol;
        break;
        case 6:
        boardGame[2][4] = symbol;
        break;
        case 7:
        boardGame[4][0] = symbol;
        break;
        case 8:
        boardGame[4][2] = symbol;
        break;
        case 9:
        boardGame[4][4] = symbol;
        break;
        default:
        break;
  }
  }

public static String checkVencedor(){
   
   List fileiradeCima = Arrays.asList(1, 2, 3);   
   List fileiradoMeio = Arrays.asList(4, 5, 6);   
   List fileiradeBaixo = Arrays.asList(7, 8, 9);
   List colunaEsq = Arrays.asList(1, 4, 7);   
   List colunaMeio = Arrays.asList(2, 5, 8);   
   List colunaDir = Arrays.asList(3, 6, 9);
   List xColumn = Arrays.asList(1, 5, 9);   
   List xColumn2 = Arrays.asList(7, 5, 3);
  
   List<List> vitória;
    vitória = new ArrayList<>();
    vitória.add(fileiradeCima);
    vitória.add(fileiradoMeio);
    vitória.add(fileiradeBaixo);
    vitória.add(colunaEsq);
    vitória.add(colunaMeio);
    vitória.add(colunaDir);
    vitória.add(xColumn);
    vitória.add(xColumn2);

    for(List l : vitória){
      if(posiçõesJogador.containsAll(l)){
       return "Você Venceu!";
      } else if(posiçõesCpu.containsAll(l)){
        return "Você Perdeu!";
      } else if(posiçõesJogador.size() + posiçõesCpu.size() == 9){
        return "CAT";
      }
    }
   return "";
    
 }
}