import ArvoreBinaria.ArvoreBinaria;
import NodeArvore.Node;

public class Main {
  public static void main(String[] args) {

      //  FilaEncadeada fila = new FilaEncadeada();
      //  FilaEncadeada fila2 = new FilaEncadeada();
      //  fila.Insere(1);
      //  fila.Insere(2);
      //  fila.Insere(5);
      //  fila.Insere(10);
  
   


      //   fila2.Insere(3);
      //   fila2.Insere(4);
      //   fila2.Insere(7);
      //   fila2.Insere(15);
  
      //   Merge.merge(fila, fila2);

        // PilhaEncadeada pilha = new PilhaEncadeada();

        // pilha.preencherPilha(1);
        // pilha.preencherPilha(3);
        // pilha.preencherPilha(4);
        // pilha.preencherPilha(5);
        // pilha.mostra_pilha();

        // BuscaBinaria busca = new BuscaBinaria();
        // int[] dados = {10,20,30,40,50};
        // System.err.println(busca.binary(dados,9,0,4));
        Node raiz = new Node(10,null,null);
        ArvoreBinaria arvore1 = new ArvoreBinaria(raiz);
        arvore1.inserir(raiz,5);
        arvore1.inserir(raiz,15);
        arvore1.inserir(raiz,16);
        arvore1.inserir(raiz,25);
        arvore1.inserir(raiz,12);
        arvore1.inserir(raiz,18);

 
        //arvoreBinaria.remover_menor_elemento(arvoreBinaria.getRaiz());

        arvore1.remover(raiz, 12);

        arvore1.pre_ordem(arvore1.getRaiz());

        System.out.println(arvore1.balanceamento(raiz)); 
    

      }


    
  }

    

