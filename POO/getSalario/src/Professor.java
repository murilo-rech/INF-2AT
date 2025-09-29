public class Professor extends Funcionario {
    private String titulacao;

    public String getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public double getSalario() {
        double base = super.getSalario();

        switch (titulacao.toLowerCase()) {
            case "especialista": return base + 1250.00;
            case "mestre": return base + 2000.00;
            case "doutor": return base + 4000.00;
            default: return base;
        }
    }
}
