public class Retangulo {
    private double largura;
    private double altura;

    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {
        if (largura > 0) {
            this.largura = largura;
        } else {
            System.out.println("Largura deve ser positiva.");
        }
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Altura deve ser positiva.");
        }
    }

    public double getArea() {
        return largura * altura;
    }
    public double getPerimetro() {
        return 2 * (largura + altura);
    }
}
