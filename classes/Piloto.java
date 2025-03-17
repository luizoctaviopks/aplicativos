package classes;


public class Piloto {
    private String nome;
    private String cpf;
    private String brevee;
    private Aeronave[] aeronaves; // Array de aeronaves
    private int aeronaveCount; // Contador para o número de aeronaves

    public Piloto() {
        this.aeronaves = new Aeronave[2]; // Defina um tamanho máximo
        this.aeronaveCount = 0; // Inicializa o contador
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBrevee(String brevee) {
        this.brevee = brevee;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarAeronave(Aeronave aeronave) {
        if (aeronaveCount < aeronaves.length) {
            aeronaves[aeronaveCount] = aeronave;
            aeronaveCount++;
        } else {
            System.out.println("Capacidade máxima de aeronaves atingida!");
        }
    }

    public void ExibirDados() {
        System.out.println("\nNome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Breve: " + brevee);
        System.out.println("Aeronaves:");
        for (int i = 0; i < aeronaveCount; i++) {
            System.out.println("  Modelo: " + aeronaves[i].getModelo() + ", Número de Série: " + aeronaves[i].getNumeroSerie());
        }
    }
}