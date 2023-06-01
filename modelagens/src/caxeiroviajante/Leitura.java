package caxeiroviajante;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Leitura {

    public ArrayList<Vertice> vertices;

    public void Leitura(){
        vertices = new ArrayList<Vertice>();
        StringBuilder conteudo = new StringBuilder();
        //o arquevo a280 e inpossivel de trabalar de maneira generiaca pq ele e mal formatado os espaço sao
        // todos mal feitos nem mesmo usando trin da pra usar isso direito entao usar os outros gradecido

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
                    System.out.println("//////comeco////////");

                    System.out.println(linha);
                    System.out.println(" ");
                    double v1 = Double.parseDouble(valores[valores.length - 2]);
                    double v2 = Double.parseDouble(valores[valores.length - 1]);
                    System.out.println( " ");
                    vertices.add(new Vertice(v1, v2));
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


