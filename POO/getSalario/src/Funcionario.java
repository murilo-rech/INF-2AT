public class Funcionario extends Pessoa {
    private String categoria;

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getSalario() {
        switch (categoria) {
            case "A": return 5000.00;
            case "B": return 6000.00;
            case "C": return 7500.00;
            default: return 0.00;
        }
    }
}
