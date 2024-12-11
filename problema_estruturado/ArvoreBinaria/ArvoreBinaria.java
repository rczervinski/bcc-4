package ArvoreBinaria;
import NodeArvore.*;
public class ArvoreBinaria {
  private Node raiz; 

  public ArvoreBinaria(Node info){
    this.raiz = info;
  }

  public Node getRaiz(){
    return raiz;
  }


  public Node inserir(Node no, int info) {
    if (no == null) {
        return new Node(info, null, null);
    }

    if (info < no.getInfo()) {
        no.setEsquerda(inserir(no.getEsquerda(), info));


        if (balanceamento(no) > 1) {
            if (info < no.getEsquerda().getInfo()) {
                return rotacaoDireita(no);
            } else {
                return duplaRotacaoDireita(no); 
            }
        }
    } else if (info > no.getInfo()) {
        no.setDireita(inserir(no.getDireita(), info));


        if (balanceamento(no) < -1) {
            if (info > no.getDireita().getInfo()) {
                return rotacaoEsquerda(no); 
            } else {
                return duplaRotacaoEsquerda(no); 
            }
        }
    }

    return no;
}


  public Node rotacaoDireita(Node no){
    Node novaRaiz = no.getEsquerda();
    no.setEsquerda(novaRaiz.getDireita());
    novaRaiz.setDireita(no);
    return novaRaiz;
}

  public Node rotacaoEsquerda(Node no){
    Node novaRaiz = no.getDireita();
    no.setDireita(novaRaiz.getEsquerda());
    novaRaiz.setEsquerda(no);
    return novaRaiz;
}

//duplaDireita - filho pra esquerda e raiz direita  
//duplaEsquerdw - filho pra direita e raiz pra esquerda
  public Node duplaRotacaoDireita(Node no){
    no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
    return rotacaoDireita(no);
  }

  public Node duplaRotacaoEsquerda(Node no){
    no.setDireita(rotacaoDireita(no.getDireita()));
    return rotacaoEsquerda(no);
  }

  public void in_ordem(Node raiz){
    if(raiz != null){

      in_ordem(raiz.getEsquerda());

      System.out.println(raiz.getInfo() + " ");

      in_ordem(raiz.getDireita());


    }
 
  }


  public void pre_ordem(Node raiz){
    if(raiz != null){

      System.out.println(raiz.getInfo() + " ");
      pre_ordem(raiz.getEsquerda());
      pre_ordem(raiz.getDireita());
    }
 
  }

  public void pos_ordem(Node raiz){
    if(raiz != null){

      pos_ordem(raiz.getEsquerda());
      pos_ordem(raiz.getDireita());
      System.out.println(raiz.getInfo() + " ");
    }
 
  }



  public Node remover_maior_elemento(Node raiz){


    if(raiz == null){
      return null;
    }


    if(raiz.getDireita() == null){
      return raiz.getEsquerda();
    }

    raiz.setDireita(remover_maior_elemento(raiz.getDireita()));
                                  //null

    return raiz;

    //          40
    //      30      50
    //   25           60
    //     27       55
  }


  public Node remover_menor_elemento(Node raiz){
    if(raiz == null){
      return null;
    }


    if(raiz.getEsquerda() == null){
      return raiz.getDireita();
    }

    raiz.setEsquerda(remover_menor_elemento(raiz.getEsquerda()));
    return raiz;
  }



  public Node remover(Node no,int info) {
    if(no == null){
      return null;
    }



    if(info < no.getInfo()){
      no.setEsquerda(remover(no.getEsquerda(), info));

    } else if (info > no.getInfo()) {
      no.setDireita(remover(no.getDireita(), info));
        
    }else{

      if(no.getEsquerda() == null && no.getDireita() == null){
        return null;

      }else if (no.getEsquerda() == null) {
          return no.getDireita();

      }else if (no.getDireita() == null){
        return no.getEsquerda();

      }else{
        Node novoPai = remover_menor_elemento(no.getDireita());
        no.setInfo(novoPai.getInfo());
      }

      int balanceamento = balanceamento(no); 

      if(balanceamento > 1 && balanceamento(no.getEsquerda()) >= 0){

      }
    }

    int balanceamento = balanceamento(no);

    if (balanceamento > 1 && balanceamento(no.getEsquerda()) >= 0) {
        return rotacaoDireita(no);
    }

    if (balanceamento > 1 && balanceamento(no.getEsquerda()) < 0) {
        no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
        return rotacaoDireita(no);
    }

    if (balanceamento < -1 && balanceamento(no.getDireita()) <= 0) {
        return rotacaoEsquerda(no);
    }

    if (balanceamento < -1 && balanceamento(no.getDireita()) > 0) {
        no.setDireita(rotacaoDireita(no.getDireita()));
        return rotacaoEsquerda(no);
    }

    return no;

}



public Node buscar(int elemento){
  Node atual = raiz; 
  while(atual != null && atual.getInfo()!= elemento){
    if(elemento > atual.getInfo()){
      atual = atual.getDireita();
    }else{
      atual = atual.getEsquerda();
    }
    
  }
  return null; 
}

public int altura(Node no) {
  if (no == null) {
      return 0; 
  }
  int esquerda = altura(no.getEsquerda());
  int direita = altura(no.getDireita());
  return 1 + Math.max(esquerda, direita);
}


public int balanceamento(Node no){

  if(no == null){
    return 0;
  }

  int esquerda = altura(no.getEsquerda());
  int direita = altura(no.getDireita()); 

  int balanceamento = esquerda - direita; 
  return balanceamento;

  
}
}