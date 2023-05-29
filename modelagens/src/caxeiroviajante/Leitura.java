package caxeiroviajante;
import java.io.*;


public class Leitura {

    public void Leitura(){
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("a280.txt"))) {
            String linha;
            String[] valores;
            boolean inicio = false;
            while ((linha = br.readLine()) != null) {
                valores = linha.trim().split(" ");
                if (valores[0].equals("EOF")) {
                    inicio = false;
                }

                if (inicio) {
                    System.out.println(linha);
                    System.out.print(valores[valores.length - 1]);
                    System.out.print( " ");
                    System.out.println(valores[valores.length - 2]);
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


