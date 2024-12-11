package FilaEncadeada;
import ListaEncadeada.ListaEncadeada;

public class FilaEncadeada {
  private ListaEncadeada fila; 
  public FilaEncadeada(){
    this.fila = new ListaEncadeada();
  }

  public void Insere(int dado){
    fila.insereUltimo(dado);
  }

  public int Remove(){
    return fila.removePrimeiro().getInfo();
  }

  public void Imprime(){
    fila.imprime();
  }

  public int getFirst(){
    return fila.getFirstInfo();
  }

  public Boolean estaVazia(){
    return fila.estaVazia();
  }
}


