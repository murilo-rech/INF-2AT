public class RelatorioService {
    private AlunoRepositorio repo;
    private AcademicoService academico;

    public RelatorioService(AlunoRepositorio repo, AcademicoService academico) {
        this.repo = repo;
        this.academico = academico;
    }

    public void exportarCSV() {
        System.out.println("[EXPORT] alunos.csv");
        for (Aluno aluno : repo.listarTodos()) {
            double media = academico.calcularMedia(aluno.getRa());
            System.out.println(aluno.getRa() + ";" +
                               aluno.getNome() + ";" +
                               aluno.getEmail() + ";" +
                               aluno.getSerie() + ";" +
                               media);
        }
    }
}
