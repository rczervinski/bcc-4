package Validador;
import PilhaEncadeada.PilhaEncadeada;
import Pilha.Pilha;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Validador {

    public static void validador() {
    Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão > ");
        String expressao = scanner.next();
        char[] arrayExpressao = expressao.toCharArray(); 
        
        Pilha pilha = new Pilha(10); 
     
        int abreParenteses = 40;   // '('
        int fechaParenteses = 41;  // ')'
        int abreColchete = 91;     // '['
        int fechaColchete = 93;    // ']'
        int abreChave = 123;       // '{'
        int fechaChave = 125;      // '}'

        ArrayList<Integer> abreExpressao = new ArrayList<>(Arrays.asList(abreParenteses, abreColchete, abreChave));
        ArrayList<Integer> fechaExpressao = new ArrayList<>(Arrays.asList(fechaParenteses, fechaColchete, fechaChave));

        for(int expressaoChar : arrayExpressao){
          if(abreExpressao.contains(expressaoChar)){
          
              pilha.preencherPilha(expressaoChar);
            
            }else if (fechaExpressao.contains(expressaoChar)){
                if(!pilha.estaVazio()){
    
                  int topoPilha = pilha.top();
                  
                  if ((topoPilha == 40 && expressaoChar == 41) ||
                  (topoPilha == 91 && expressaoChar == 93) ||
                  (topoPilha == 123 && expressaoChar == 125 ))
                  {
                  pilha.desempilha(); 
                  }
                  else {
                  System.out.println("Expressão inválida.");
                  return;
                  }
              }
          }
        }
        
        if (pilha.estaVazio()) {
          System.out.println("Expressão válida.");
      } else {
          System.out.println("Expressão inválida.");
      }
    }


    public static void validador_encadeado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão > ");
        String expressao = scanner.next();
        char[] arrayExpressao = expressao.toCharArray(); 
        
        PilhaEncadeada pilha = new PilhaEncadeada(); 
     
        int abreParenteses = 40;   // '('
        int fechaParenteses = 41;  // ')'
        int abreColchete = 91;     // '['
        int fechaColchete = 93;    // ']'
        int abreChave = 123;       // '{'
        int fechaChave = 125;      // '}'

        ArrayList<Integer> abreExpressao = new ArrayList<>(Arrays.asList(abreParenteses, abreColchete, abreChave));
        ArrayList<Integer> fechaExpressao = new ArrayList<>(Arrays.asList(fechaParenteses, fechaColchete, fechaChave));

        for(int expressaoChar : arrayExpressao){
          if(abreExpressao.contains(expressaoChar)){
         
              pilha.preencherPilha(expressaoChar);
            
            }else if (fechaExpressao.contains(expressaoChar)){
                if(!pilha.estaVazio()){
    
                  int topoPilha = pilha.top();
                  
                  if ((topoPilha == 40 && expressaoChar == 41) ||
                  (topoPilha == 91 && expressaoChar == 93) ||
                  (topoPilha == 123 && expressaoChar == 125 ))
                  {
                  pilha.desempilha(); 
                  }
                  else {
                  System.out.println("Expressão inválida.");
                  return;
                  }
              }
          }
        }
        
        if (pilha.estaVazio()) {
          System.out.println("Expressão válida.");
      } else {
          System.out.println("Expressão inválida.");
      }
    }
}
