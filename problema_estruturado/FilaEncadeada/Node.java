package FilaEncadeada;

public class Node{
  private Integer informacao;
  private Node proximo;
  public Node(){
    informacao = null;
    proximo = null;
  }

  public int getInfo(){
    return informacao;
  }
  public void setInfo(int info){
    informacao = info;
  }

  public Node getNext(){
    return proximo;
  }

  public void setNext(Node proximo){
    this.proximo = proximo;
  }


  }




