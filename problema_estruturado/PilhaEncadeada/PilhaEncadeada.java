package PilhaEncadeada;
import ListaEncadeada.ListaEncadeada;

public class PilhaEncadeada{
  private ListaEncadeada pilha;

  public PilhaEncadeada(){
    this.pilha = new ListaEncadeada();
  }


  public void preencherPilha(int dado){
    pilha.insereUltimo(dado);
  }

  public int desempilha(){
    if(estaVazio()){
      return -1;
    }else{
    return pilha.removeUltimo().getInfo();
  }
  }

  public int top(){
    return pilha.getLast().getInfo();
  }

  public void mostra_pilha(){
    pilha.imprime();
  }

  public Boolean estaVazio(){
    return pilha.estaVazia(); 
  }



  
}