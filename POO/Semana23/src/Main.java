public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        // Testando valores válidos
        p1.setNome("Ana");
        p1.setIdade(25);
        System.out.println("Nome: " + p1.getNome()); // Saída: Ana
        System.out.println("Idade: " + p1.getIdade()); // Saída: 25
        // Testando valores inválidos
        // Testando valores inválidos
        p1.setNome(""); // Deve exibir erro
        p1.setIdade(-5); // Deve exibir erro e setar para 0
        System.out.println("Nome após tentativa inválida: " + p1.getNome()); // Saída: Ana (mantém o valor anterior)
        System.out.println("Idade após tentativa inválida: " + p1.getIdade()); // Saída: 0

        System.out.println("--------------------");
        System.out.println("--------------------");

        ContaBancaria conta = new ContaBancaria("12345-6");

        System.out.println("Saldo inicial: R$" + conta.getSaldo()); // Saída: 0.0

        conta.depositar(500.0);
        System.out.println("Saldo após depósito: R$" + conta.getSaldo()); // Saída: 500.0

        conta.sacar(200.0);
        System.out.println("Saldo após saque: R$" + conta.getSaldo()); // Saída: 300.0

        conta.sacar(400.0); // Deve dar erro de saldo insuficiente
        System.out.println("Saldo final: R$" + conta.getSaldo()); // Saída: 300.0

        System.out.println("--------------------");
        System.out.println("--------------------");

        Produto produto = new Produto();
        produto.setNome("Notebook");

        System.out.println("Estoque inicial de " + produto.getNome() + ": " + produto.getQuantidadeEmEstoque());

        produto.adicionarEstoque(50);
        System.out.println("Estoque atual: " + produto.getQuantidadeEmEstoque()); // Saída: 50

        produto.removerEstoque(20);
        System.out.println("Estoque atual: " + produto.getQuantidadeEmEstoque()); // Saída: 30

        produto.removerEstoque(40); // Deve dar erro
        System.out.println("Estoque final: " + produto.getQuantidadeEmEstoque()); // Saída: 30

        System.out.println("--------------------");
        System.out.println("--------------------");

        Retangulo meuRetangulo = new Retangulo();
        meuRetangulo.setLargura(10.0);
        meuRetangulo.setAltura(5.0);

        System.out.println("Largura: " + meuRetangulo.getLargura());
        System.out.println("Altura: " + meuRetangulo.getAltura());
        
        // A área e o perímetro são calculados sob demanda
        System.out.println("Área: " + meuRetangulo.getArea()); // Saída: 50.0
        System.out.println("Perímetro: " + meuRetangulo.getPerimetro()); // Saída: 30.0
    }
}
