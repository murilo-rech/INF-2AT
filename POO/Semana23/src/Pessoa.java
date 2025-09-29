public class Pessoa {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.err.println("Nome não pode ser vazio.");
        }else{
        this.nome = nome;
        }
    }
    public void setIdade(int idade) {
        if (idade < 0) {
            this.idade = 0;
            System.err.println("Idade não pode ser negativa. Definida como 0.");
        }else{
            this.idade = idade;
        }
    }
}
