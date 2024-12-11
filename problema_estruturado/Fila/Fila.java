package Fila;
public class Fila{
  public int primeiro;
  public int ultimo;
  private Integer[] dados; 

  public Fila(int capacidade){
    this.dados = new Integer[capacidade];
    this.ultimo = -1;
    this.primeiro = 0;

  }
  
  public Boolean estaCheia(){
    return (ultimo + 1) % dados.length == primeiro;

  }

  public Boolean estaVazia(){
    return (ultimo  == -1);
  }

  public Integer[] getDados(){
    return dados;
  }

  
  public int getFirst(){
    return dados[primeiro];
  }

  
  public int getLast(){
    return dados[ultimo];
  }


  public void Insere(int valor){
 
    if(estaVazia()){
      primeiro = 0;
      ultimo = 0;
      
    }
    if(estaCheia()){
      System.out.println("Fila cheia");
      return;

    }else{
      while(dados[ultimo] != null){
        ultimo = (ultimo + 1) % dados.length; // 0
          //0          //4 % 4   0
      }
      
    } //// 0
    dados[ultimo] = valor;
  }

  public int Remove(){
    if(estaVazia()){
      System.out.println("Fila esta vazia");
      return -1;
    }
    int valor = dados[primeiro];
    dados[primeiro] = null;
    if(primeiro == ultimo){ // um emelento
      primeiro = 0;
      ultimo = -1;
    }else{
      do{
      primeiro = (primeiro + 1) % dados.length;
      }while(dados[primeiro] == null && primeiro != ultimo);
      // 4 5 6
      // 0 1 2

      // 
    }
    return valor;
  }

  public void Imprime() {
    System.out.print("[");
    int count = dados.length;
    
    for (int i = primeiro; i < dados.length; i++) {
        System.out.print(dados[i]);
        if (i < dados.length - 1) {
            System.out.print(", ");
        }
    }
    
    if (ultimo < primeiro) {
        for (int i = 0; i <= ultimo; i++) {
            if (i == 0 || i < ultimo) {
                System.out.print(", ");
            }
            System.out.print(dados[i]);
        }
    }

    System.out.println("]");
}

public void Ordenar(){
    if(estaVazia()){
      System.out.println("Esta vazia");
    }

  Integer[] temp = new Integer[dados.length];
  int count = 0;

  while(!estaVazia()){
    temp[count++] = Remove(); 
  }

  for(int i = 0; i < count - 1; i++){
    for(int j = 0; j < count - 1; j++){
      if(temp[j] != null && temp[j + 1] != null && temp[j] > temp[j+1]){
        Integer tempValue = temp[j+1];
        temp[j+1] = temp[j];
        temp[j] = tempValue;
      }
    }
  }


  for(int i = 0; i < count; i++){
    Insere(temp[i]);
  }
}

}

  



