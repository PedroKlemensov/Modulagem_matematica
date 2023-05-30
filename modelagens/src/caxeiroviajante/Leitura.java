package caxeiroviajante;
import java.io.*;


public class Leitura {

    public void Leitura(){
        StringBuilder conteudo = new StringBuilder();
        //o arquevo a280 e inpossivel de trabalar de maneira generiaca pq ele e mal formatado os espaço sao
        // todos mal feitos nem mesmo usando trin da pra usar isso direito entao usar os outros gradecido

        try (BufferedReader br = new BufferedReader(new FileReader("att48.txt"))) {
            String linha;
            String[] valores;
            boolean inicio = false;
            while ((linha = br.readLine()) != null) {
                valores = linha.trim().split(" ");
                if (valores[0].equals("EOF")) {
                    inicio = false;
                }

                if (inicio) {
                    System.out.println("//////comeco////////");

                    System.out.println(linha);
                    System.out.println(" ");
                    System.out.print(Integer.parseInt(valores[valores.length - 2]));
                    System.out.print( " ");
                    System.out.println(Integer.parseInt(valores[valores.length - 1]));
                    System.out.println( " ");
                    System.out.println("///////////FIM//////////");
                    System.out.println( " ");




                }

                if (valores[0].equals("NODE_COORD_SECTION")) {
                    inicio = true;
                }


                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());

        }
        //System.out.println(conteudo);

    }


    }


