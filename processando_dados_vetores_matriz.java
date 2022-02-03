
public class bass {
   
    public static void main(String[] args) {
     
        int[][] vetorProposto = { { 23, 44, 56, 39, 81},
                                  { 67, 39, 41, 78, 13},
                                  { 52, 19,  47, 88, 64}};
       
      
        for (int i = 0; i < vetorProposto.length; i++) ordenar(vetorProposto[i]);
        
        divisores (vetorProposto);
        
        fibonacci(vetorProposto);
        
        maiorMenor (vetorProposto);
        
        for (int i = 0; i < vetorProposto.length; i++) ehPrimo(vetorProposto[i], i);
        System.out.println("____________________________________");
        System.out.println("");
        for (int i = 0; i < vetorProposto.length; i++) mc(vetorProposto[i] ,i);
        
        
       
        
        }

    public static void mc (int [] vet, int i){
        int [] imagem = vet.clone();
        int[] z = vet.clone();
        ordenar(vet);   
     
        dias(imagem);
        System.out.println("mdc do vetor " + i);
        mdc(vet, imagem);
        System.out.println("");
        System.out.println("mmc do vetor " + i);
        mmc(z, imagem);
        System.out.println("------------------------------");
        System.out.println("");
    }

    public static boolean diferente (int[] vet, int d){
        int cont2 = 0;
 
        boolean f = true;

        for(int i = 0; i < vet.length; i++)if(vet[i] == 1) cont2++;
        
        ordenar(vet);
        if(vet[0] + 1 < d) f = false;
        if(cont2 > 0)f = false;
        
        return f;
    }

    public static void mdc (int [] vet, int [] vet2){
        int divisor = 2;
        int acumulador = 1;
        
        int[] imagem = new int[vet.length];
      
        String solucaoFinal = ""; 
        String s = "";
        
        while(diferente(vet, divisor)){ 
            while(conferir(vet, divisor) == 5){ 
                solucaoFinal = transformacao(vet,vet2);
                System.out.println(solucaoFinal + "| " + divisor);
                
                for(int i = 0; i < vet.length; i++){
                    if(vet[i] % divisor == 0 && vet[i] > 1){
                        vet[i] = numeroNovo(vet[i], divisor);
                        imagem[i] = vet[i];
                    }
                }
                acumulador = acumulador * divisor;

            }
            
            divisor = novoPrimo(divisor, imagem);

        }
       solucaoFinal = transformacao(vet, vet2);
        
       int linha = contador (solucaoFinal + "| " + acumulador);
        
       for(int i = 0; i < linha; i++) s = s + '_';
        
       System.out.println(s);
       System.out.println(solucaoFinal + "| " + acumulador);
    }

    public static void mmc (int [] vet, int [] vet2){
        int divisor = 2;
        int acumulador = 1;
        
        int[] imagem = new int[vet.length];
       
        String solucaoFinal = ""; 
        String s = "";
        
        while(conferir(vet, 0) != vet.length){
            while(conferir(vet, divisor) > 0){
                solucaoFinal = transformacao(vet,vet2);
                System.out.println(solucaoFinal + "| " + divisor);

                for(int i = 0; i < vet.length; i++){
                    if(vet[i] % divisor == 0 && vet[i] > 1){
                        vet[i] = numeroNovo(vet[i], divisor);
                        imagem[i] = vet[i];
                    }
                }
                acumulador = acumulador * divisor;
            }
            divisor = novoPrimo(divisor, imagem);
        }
        
       solucaoFinal = transformacao(vet, vet2);
        
       int linha = contador (solucaoFinal + "| " + acumulador);
        
       for(int i = 0; i < linha; i++) s = s + '_';
        
       System.out.println(s);
       System.out.println(solucaoFinal + "| " + acumulador);
    }
    
    public static int novoPrimo(int num, int[] vet){
        
        while(true){
         num++;
         if(num%2 != 0) break;
            
        }
         return num;
    }

    public static String transformacao(int[] vet, int[] vet2){
        
        String[] y = new String[vet.length];
        String retorno = "";

        int contador;
        int[] quantidadeVariante = new int [vet.length];
        int[] quantidadeFixa = new int [vet.length];

      for(int i = 0; i < vet2.length; i++)quantidadeFixa[i] = vet2[i];

      for(int i = 0; i < vet.length; i++){
            y[i] = Integer.toString(vet[i]);
            quantidadeVariante[i] = contador(y[i]);
           
        }
          for(int i = 0; i < vet.length; i++){
                if(quantidadeFixa[i] == quantidadeVariante[i]){
                    retorno = retorno + y[i] + " ";
              
                    } else{contador = quantidadeVariante[i];
                        while(contador < quantidadeFixa[i]){
                            y[i] = " " + y[i];
                            contador++;
                  
                        }retorno = retorno + y[i] + " ";
                    }
            }
       
       return retorno;
    }

    public static int numeroNovo(int x, int y){
        int resultado = x / y;
        
        return resultado;
    }

     public static int conferir(int vet[], int x){
        int acumulador = 0;
       
        if (x == 0) for(int i = 0; i < vet.length; i++)  if (vet[i] == 1) acumulador++;
        if (x > 1) for(int i = 0; i < vet.length; i++)  if (vet[i] % x == 0) acumulador++; 
                
        return acumulador;
    }

    public static void dias (int [] vet){
        String [] y = new String[vet.length];

        for(int i = 0; i < vet.length; i++){
            y[i] = Integer.toString(vet[i]);
            vet[i] = contador(y[i]);
        }
    }

    public static int contador(String x){
        int contador = 0;
        for(int i = 0; i < x.length(); i++)contador++;
        
        return contador;
    }

    public static void fibonacci(int [][]vetorProposto){
    int contador = 0;
        
    for(int i = 0; i <vetorProposto.length; i++){
        for(int j = 0; j < vetorProposto[i].length; j++){    
          if(fibo(vetorProposto[i][j]))contador++; 
          
        }
        System.out.println("vetor " + i + " possui "+ contador + " numero pertencentes a sequencia fibonacci. ");
        
        contador = 0;
    }
    System.out.println("_____________________________________________________"); 
     
    }
    
    public static boolean fibo (int x){
     boolean f = false;
     int t1 = 0;
     int t2 = 1;           
     int soma = 0;
        
        while(soma < x){
            soma = t2 + t1;
            t1 = t2;
            t2 = soma;
            if(x == soma) f = true;
    
            
    }
       return f; 
    }
    
    public static void divisores (int [][] vetorProposto){
        int divisor = 0;
        int quantosDivisor = 1;
        int c = 0;
        int d = 0;
        
      
       
       for(int i = 0; i < vetorProposto.length; i++){
           for(int j = 0; j < vetorProposto[i].length; j++){
               
               while(divisor < ((vetorProposto[i][j]/2) + 1)){
                    divisor++; 
                   if(vetorProposto[i][j]% divisor == 0){
                       quantosDivisor++;

                   }
                 
               }
              divisor = 0;  
                
             if(quantosDivisor > c){
                c = quantosDivisor;
                d = vetorProposto[i][j];
               
               } quantosDivisor = 1;
                  
                 
           }
           
          System.out.println("o numero do vetor " + i + " com maior quantidade de divisores é o " + d + " com " + c + " divisores. "); 
       
               c = 0;
       }
       System.out.println("_____________________________________________________");
    }
    
    public static void maiorMenor (int[][] vetorProposto){
       int aux = 0;
       int aux2 = 0;
        
        for(int i = 0; i < vetorProposto.length ; i++){
           if(vetorProposto[i][0] < aux || i == 0) aux = vetorProposto[i][0];
           if(vetorProposto[i][vetorProposto[i].length - 1] > aux2)aux2 = vetorProposto[i][vetorProposto[i].length - 1];
           
             System.out.println("o menor numero do vetor " + i + " é " + vetorProposto[i][0] + " e o seu maior numero é " + vetorProposto[i][vetorProposto[i].length - 1] + ".");
             
       }
       System.out.println();
       System.out.println("o menor numero da matriz é " + aux + " e o maior numero é " + aux2 + ".");
       System.out.println("_____________________________________________________");
       
    }
    
    public static void ehPrimo(int[] n, int l){
       boolean resp = true;
       int cont = 0;
       int numero;
      
       String p = " numeros primos.";
       for(int j = 0; j < n.length; j++){
        numero = n[j];
       if(numero!=2){
            for(int i = 2; i< ((numero/2)+1); i++){
                if((numero%i)==0){
                    resp = false;
                    break;
                }
            }
       }
       if(resp || numero == 2)cont++;
       resp = true;
       }
       if(cont == 1) p = " numero primo.";
       System.out.println("o vetor "+ l + " possui "+ cont + p);
     
    }
    
    public static void ordenar (int [] x){
       int contador = 0;
       int aux;
       boolean achei;
        do {
            achei = false;
            for(int j = 0; j < (x.length - 1) - contador; j++){
                
                if(x[j] > x[j+1]) {
                    aux = x[j+1];
                    x[j+1] = x[j];
                    x[j] = aux;
                    achei = true;
                    
                } 
            } 
            contador++;
        }while(achei);
    }
}
