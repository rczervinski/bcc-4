package BuscaBinaria;
public class BuscaBinaria {
  public int dados[];
  public int x;
  public int inicio;
  public int fim; 


  public int binary(int[] dados,int x, int inicio, int fim){
    int meio = inicio + (fim - inicio) / 2;

      if(inicio > fim){
        return -1;
      }
      if(dados[meio] == x){
        return x;
      }else{
        if(dados[meio] > x){
          return binary(dados, x, inicio, meio-1);
        }else{
          return binary(dados, x, meio+1, fim);
        }
      }
    //10 , 12 ,14 ,15, 22 ,37

   
  }


}

