public class Main {
    public static void main(String[] args) {
        ProcessadorAluno sistema = new ProcessadorAluno();

        sistema.cadastrarAluno("2025001", "Ana", "ana@ifsul.edu", Serie.PRIMEIRO);
        sistema.registrarNota("2025001", 8);
        sistema.registrarNota("2025001", 4.5);
        sistema.registrarPagamento("2025001", 250.00);

        sistema.verificarStatus("2025001", 250.00);

        sistema.registrarAdvertenciaPorFaltaEmAvaliacao("2025001", true);

        sistema.exportarCSV();
    }
}
