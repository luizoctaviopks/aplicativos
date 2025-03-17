package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import classes.Aeronave;
import classes.Piloto;

public class AppPilotos {
    static Scanner input = new Scanner(System.in);
        public static void main(String[] args) throws InterruptedException, IOException {
            final int MAX_ELEMENTOS = 10;
            int opcao, qtdCadastrados = 0;
            Piloto[] pilotos = new Piloto[MAX_ELEMENTOS]; 
            Aeronave aeronave = new Aeronave();
            Scanner in = new Scanner(System.in);
            int pilContador = 0;
            String cpfDoPiloto = null;
               
            do {
                System.out.println("\n****\nMENU\n****\n");
                System.out.println("1 - Cadastrar piloto");
                System.out.println("2 - Listar pilotos cadastrados");
                System.out.println("3 - Localizar piloto pelo CPF");
                System.out.println("4 - Cadastrar aeronave");
                System.out.println("0 - Sair");                
                System.out.print("Opção: ");
    
                opcao = in.nextInt();
                in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior
    
                if (opcao == 1) {
                    // Se não há mais espaço no vetor, saio do cadastro
                    if (pilContador == MAX_ELEMENTOS) {
                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(in);
                        continue;
                    }
                
                    // Cadastre o piloto aqui
                    System.out.println("\nInforme o nome do piloto:");
                    String nome = input.nextLine();
                
                    System.out.println("\nInforme o cpf do piloto:");
                    String cpf = input.nextLine();
                
                    System.out.println("\nInforme o breve do piloto:");
                    String brevee = input.nextLine();
                
                    Piloto piloto = new Piloto();
                    piloto.setNome(nome);
                    piloto.setCpf(cpf);
                    piloto.setBrevee(brevee);
                
                    pilotos[pilContador] = piloto;
                    pilContador++;
                
                    System.out.println("\nPiloto cadastrado com sucesso.");
                    voltarMenu(in);

            } else if (opcao == 2) {//Listar Pilotos cadastrados
                                
                if (qtdCadastrados == 0) {
                    if (pilotos[0] == null) {
                        System.out.println("\nNenhum piloto cadastrado!");
                        voltarMenu(in);
                    } else {
                        for (int i = 0; i < pilotos.length; i++) {
                            if (pilotos[i] != null) {
                                pilotos[i].ExibirDados();                               

                            }
                        }
                    }
                }              

                voltarMenu(in);
            } else if (opcao == 3) {
                    // Exiba os pilotos aqui
                    System.out.println("\nInforme o cpf do piloto:");
                    cpfDoPiloto = input.next();
                
                    boolean pilotoEncontrado = false; // inicia como falso
                
                    for (int i = 0; i < pilotos.length; i++) {
                        if (pilotos[i] != null && pilotos[i].getCpf().equals(cpfDoPiloto)) {
                            pilotos[i].ExibirDados(); 
                            pilotoEncontrado = true; // entrega verdadeiro
                            voltarMenu(in);
                            break; 
                        }
                    }
                
                    if (!pilotoEncontrado) {
                        System.out.println("\nPiloto não encontrado com o CPF informado.");
                    }
            


            }  else if (opcao == 4) {
                if (pilContador == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(in);
                    continue;
                }
            
                System.out.println("\nInforme o CPF do piloto que vai pilotar esta aeronave:");
                cpfDoPiloto = input.next();
                boolean pilotoEncontrado = false;
            
                for (int i = 0; i < pilotos.length; i++) {
                    if (pilotos[i] != null && pilotos[i].getCpf().equals(cpfDoPiloto)) {
                        pilotos[i].ExibirDados(); 
                        pilotoEncontrado = true;
            
                        // Cadastro da aeronave
                        System.out.println("\nInforme o modelo da aeronave:");
                        String modelo = input.next();
            
                        System.out.println("\nInforme o número de série da aeronave:");
                        String numeroSerie = input.next();
            
                        aeronave = new Aeronave();
                        aeronave.setModelo(modelo);
                        aeronave.setNumeroSerie(numeroSerie);
            
                        // Vincula a aeronave ao piloto
                        pilotos[i].adicionarAeronave(aeronave);
                        System.out.println("\nAeronave cadastrada com sucesso!");
                        voltarMenu(in);
                        break;
                    }
                }
            
                if (!pilotoEncontrado) {
                    System.out.println("\nPiloto não encontrado com o CPF informado.");
                    voltarMenu(in);
                    continue;
                }
            }






            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
         } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
        
    }
    
}
