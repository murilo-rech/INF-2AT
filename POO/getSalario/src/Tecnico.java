public class Tecnico extends Funcionario {
    private String nivel;

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public double getSalario() {
        double base = super.getSalario();

        switch (nivel.toUpperCase()) {
            case "I": return base + 500.00;
            case "II": return base + 750.00;
            case "III": return base + 1250.00;
            default: return base;
        }
    }
}
