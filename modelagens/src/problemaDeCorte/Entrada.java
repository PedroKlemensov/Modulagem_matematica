//<<<<<<< Updated upstream
////package problemaDeCorte;
////
////public class Entrada {
////    public static void main(String[] args) {
////        int total = 150;
////
////        int[] tamanho  = {80 , 60 ,50};
////        int[][]  cortes;
////
////
////
////
////    }
////
////
////    public void calculo() {
////        for (int i = 0; i < tamanho.length; i++) {
////            int valor = total;
////            resto(total, tamanho[i]);
////            for (int j = i++; j < tamanho.length; j++) {
////
////            }
////
////        }
////    }
////
////    public int resto(int valor , int tipo) {
////
////        int cont = 0;
////        for (int i = 0; valor < tipo; i++) {
////            valor = valor - tipo;
////            cont = i;
////        }
////
////        return cont;
////    }
////}
//=======
//package problemaDeCorte;
//
//public class Entrada {
//
//    int total = 150;
//
//    int[] tamanho  = {80 , 60 ,50};
//
//    int[][]  cortes;
//    int[] tipos = new int[tamanho.length];
//    int contador =0;
//    public  void calculo() {
//
//        for (int i = 0; i < tamanho.length; i++) {
//            int valor = total;
//            tipos[i] =resto(valor, tamanho[i]);
//            for (int j = i++; j < tamanho.length; j++) {
//                calculamais(tipos, j, valor);
//            }
//
//        }
//    }
//
//    public void calculamais(int[] tipos, int posicao, int valor){
//        for(int i=posicao;i>tamanho.length;i++){
//            resto(valor,tamanho[i]);
//            cortes[contador]=tipos;
//            contador++;
//        }
//
//
//    }
//
//    public int resto(int valor , int tipo) {
//
//        int cont = 0;
//        for (int i = 0; valor < tipo; i++) {
//            valor = valor - tipo;
//            cont = i;
//        }
//
//        return cont;
//    }
//
//
//}
//>>>>>>> Stashed changes
