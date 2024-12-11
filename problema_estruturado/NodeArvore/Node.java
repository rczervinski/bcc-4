package NodeArvore;

public class Node {
  private Integer info;
  private Node esquerda; 
  private Node direita; 

  public Node (int info, Node esquerda, Node direita){
    this.info = info;
    this.esquerda = esquerda;
    this.direita = direita;
  }

  public Integer getInfo(){
    return info;
  }

  public Node getEsquerda(){
    return esquerda;
  }

  public Node getDireita(){
    return direita;
  }

  public void setInfo(Integer informacao){
    info = informacao;
  }

  public void setDireita(Node direita){
    this.direita = direita;

  }

  public void setEsquerda(Node esquerda){
    this.esquerda = esquerda;
  }
}
