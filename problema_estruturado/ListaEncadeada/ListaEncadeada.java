package ListaEncadeada;
import FilaEncadeada.Node;


public class ListaEncadeada {
  private Node lista;
  public ListaEncadeada(){
    lista = null; 
  }


  public Node getNode(int info){
    Node atual = lista;
    while(atual != null){
      if(atual.getInfo() != -1 && atual.getInfo() == info){
        return atual;
      }
      atual = atual.getNext();
    }
    return null;
  }


  public Boolean estaVazia(){
    return this.lista == null; 
  }


  public Node getLast(){
    if(lista == null){
      return null;
    }
    Node atual = lista;
    while(atual.getNext() != null){// diff de null
      atual = atual.getNext();
    }

    return atual;
  }

  public int getFirstInfo(){
    return lista.getInfo();
  }
  
  public void inserePrimeiro(int info){
    Node novo = new Node();
    novo.setInfo(info);
    novo.setNext(lista);
    lista = novo;
    }
  
  public void insereDepois(Node node, int info){

    Node novo = new Node();
    novo.setInfo(info);
    
    novo.setNext(node.getNext());
    node.setNext(novo);
   

  }

  public void insereUltimo(int info){
    if(lista == null){
      lista = new Node();
      lista.setInfo(info);
    }else{

        Node atual = lista;
        while(atual.getNext() != null){
          atual = atual.getNext();
        }
        Node novo = new Node();
        novo.setInfo(info);
        atual.setNext(novo);
        
      }
    }
    
  

    public void insereOrdenado(int info) {
      Node novo = new Node();
      novo.setInfo(info);
  
      if (lista == null || lista.getInfo() >= info) {
         inserePrimeiro(info);      
      } else {
          Node atual = lista;
  
          while (atual.getNext() != null && atual.getNext().getInfo() < info) {
              atual = atual.getNext();
          }
  
          novo.setNext(atual.getNext());
          atual.setNext(novo);
      }
  }

  public Node removePrimeiro(){

    Node removedNode = lista;
    
    lista = lista.getNext();
    removedNode.setNext(null);
    return removedNode;

  }

  public Node removeUltimo() {
    if (lista == null) {
        return null; 
    }
    if (lista.getNext() == null) {
        Node ultimo = lista;
        lista = null;  
        return ultimo;
    }
    Node atual = lista;

    while (atual.getNext().getNext() != null) {
        atual = atual.getNext();
    }

    Node ultimo = atual.getNext();
    atual.setNext(null);

    return ultimo;
}

  
  public Node removeNode(Node node){
    if(node.getNext() == null){
      removeUltimo();
    }else{

      Node atual = lista; 

      while(atual != null && atual.getNext() != node){
        atual = atual.getNext();
      }
      Node anterior = atual;
      Node proximo = node.getNext();

      anterior.setNext(proximo);
      node.setNext(null);
      return node; 

    }
  
    return null;
  }

  public void imprime(){
    Node atual = lista;
    while(atual != null){
      System.out.print(atual.getInfo() + " -> ");
      atual = atual.getNext();


    }
    System.out.println("null");
  }
  

}


