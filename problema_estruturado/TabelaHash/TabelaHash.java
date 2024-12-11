package TabelaHash;
import ListaEncadeada.ListaEncadeada;  
import java.util.Random;
import java.util.Scanner;

public class TabelaHash {
    int colisao; 
    ListaEncadeada[] listaEncadeadas;

    public TabelaHash(int tamanho){
        this.listaEncadeadas = new ListaEncadeada[tamanho]; 
        this.colisao = 0;
        preencherTabela(tamanho * 0.9);
    }

        
    public int funcaoHash(int chave){
        return chave % listaEncadeadas.length;
    }

    public void preencherTabela(double tamanho){
        Random random = new Random();
   
        for(int i = 0; i < tamanho; i++){
            int randomNumber = random.nextInt(1_000_001);
            insere(randomNumber);

        }
    }

                                    // 1 - 201
                                    // 2 - 102
                                    // 3 - 303
                                    // 4 - 804

    public void insere(int chave){  
        int indice = funcaoHash(chave);
        if (listaEncadeadas[indice] == null) {
            listaEncadeadas[indice] = new ListaEncadeada();
        }

        if(!listaEncadeadas[indice].estaVazia()){
            colisao++;
        }


        if(listaEncadeadas[indice].estaVazia()){
          listaEncadeadas[indice].insereUltimo(chave);    
        }else{
            listaEncadeadas[indice].insereOrdenado(chave);
        }
               

    }

    public Boolean busca(int chave){
        int indice = funcaoHash(chave); 
        if (listaEncadeadas[indice] == null) {
            return false;
        }

        if (listaEncadeadas[indice].getNode(chave) == null) {
            return false;
        }


        if(chave == listaEncadeadas[indice].getNode(chave).getInfo()){
            return true;
        }
        
        return false;
    }

   
    public void imprime() {
        System.out.println("Colisões > "+ colisao);
        for (int i = 0; i < listaEncadeadas.length; i++) {
            
            System.out.print(i + " ");
            
            if (listaEncadeadas[i] != null) {
                listaEncadeadas[i].imprime();
            } else {
                System.out.println("-1");
            }
        }
    }
    

    public void user_interface(){
        @SuppressWarnings("resource")

        Scanner scanner = new Scanner(System.in);
        int choose = 0;
      
        do{
          
            imprime();
       
            System.out.print("Digite um valor para busca > ");
            choose = scanner.nextInt();

            if(choose == -1){
                System.out.println("Encerrando programa.");
                return;
            }

            Boolean busca = busca(choose);
        
            if(busca == false || busca == null){
                System.out.println("O valor não existe!\n");
               
            }else{
                System.out.println("O valor " + choose + " existe!\n");
            }


        }while( choose != -1);
        
    }
}
