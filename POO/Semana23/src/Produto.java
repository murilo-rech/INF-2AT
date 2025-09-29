public class Produto {
    private String nome;
    private int quantidadeEmEstoque;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEmEstoque += quantidade;
        } else {
            System.out.println("Quantidade a adicionar deve ser positiva.");
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidadeEmEstoque) {
            this.quantidadeEmEstoque -= quantidade;
        } else {
            System.out.println("Quantidade a remover deve ser positiva e menor ou igual ao estoque atual.");
        }
    }
}
