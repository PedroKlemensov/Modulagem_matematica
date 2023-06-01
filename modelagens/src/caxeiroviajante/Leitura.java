package caxeiroviajante;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Leitura {

    public ArrayList<Vertice> vertices;

    public void Leitura(){
        vertices = new ArrayList<Vertice>();
        StringBuilder conteudo = new StringBuilder();

        String nome = "att48.txt";
        System.out.println("escolha o caso de teste: 1 a280: 2 att28: 3 att532");
        Scanner s = new Scanner(System.in);
        int resposta = s.nextInt();
        if (resposta == (1)){
            nome = "a280.txt";
        }else if (resposta == (2)){
            nome = "att48.txt";
        } else if (resposta == (3)) {
            nome = "att532.txt";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nome))) {
            String linha;
            String[] valores;
            boolean inicio = false;
            while ((linha = br.readLine()) != null) {
                valores = linha.trim().split(" ");
                if (valores[0].equals("EOF")) {
                    inicio = false;
                }

                if (inicio) {


                    double v1 = Double.parseDouble(valores[valores.length - 2]);
                    double v2 = Double.parseDouble(valores[valores.length - 1]);
                    vertices.add(new Vertice(v1, v2));

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


