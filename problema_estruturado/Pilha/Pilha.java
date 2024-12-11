package Pilha;


public class Pilha{
  private final int max;
  private int topo;
  private final Integer[] dado;

  public Pilha(int max){
    this.max = max;
    this.topo = -1;
    this.dado = new Integer[max];

  }
  



  public boolean estaCheio(){
    return topo == max-1;
  }
   
  public boolean estaVazio(){
    return topo == -1;
  }

  public Integer top() {
    if (estaVazio()) {
        return null; 
    }
    return this.dado[this.topo];
}

  public  void preencherPilha(int valor){
    if(!estaCheio()){
      int verPilha = dado[++topo] = valor;
      System.out.println(verPilha);
      
    }
  }
 
  

  public Integer desempilha(){
    if(!estaVazio()){
      int elemento = this.dado[this.topo]; 
      topo -= 1;
      return elemento;

    }
    return null;
  }



  
}