package Merge;
import Fila.Fila;
import FilaEncadeada.FilaEncadeada;

public class Merge {

  public static void merge(Fila fila1, Fila fila2) {
      System.out.println("Fila 1:");
      fila1.Imprime();

      System.out.println("Fila 2:");
      fila2.Imprime();

      System.out.println();

      Fila filaC = new Fila(fila1.getDados().length + fila2.getDados().length); 

      while (!fila1.estaVazia() && !fila2.estaVazia()) {
          if (fila1.getFirst() <= fila2.getFirst()) {
              filaC.Insere(fila1.Remove());
          } else {
              filaC.Insere(fila2.Remove());
          }
      }

      while (!fila1.estaVazia()) {
          filaC.Insere(fila1.Remove());
      }

      while (!fila2.estaVazia()) {
          filaC.Insere(fila2.Remove());
      }

      filaC.Imprime();
  }

  public static void merge(FilaEncadeada fila1, FilaEncadeada fila2) {
      System.out.println("Fila 1:");
      fila1.Imprime();

      System.out.println("Fila 2:");
      fila2.Imprime();

      System.out.println();

      FilaEncadeada filaC = new FilaEncadeada();

      while (!fila1.estaVazia() && !fila2.estaVazia()) {
          if (fila1.getFirst() <= fila2.getFirst()) {
              filaC.Insere(fila1.Remove());
          } else {
              filaC.Insere(fila2.Remove());
          }
      }

      while (!fila1.estaVazia()) {
          filaC.Insere(fila1.Remove());
      }

      while (!fila2.estaVazia()) {
          filaC.Insere(fila2.Remove());
      }

      filaC.Imprime();
  }
}
