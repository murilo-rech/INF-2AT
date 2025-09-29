public class AcademicoService {
    private AlunoRepositorio repo;
    private NotificacaoService notificacao;

    public AcademicoService(AlunoRepositorio repo, NotificacaoService notificacao) {
        this.repo = repo;
        this.notificacao = notificacao;
    }

    public void registrarNota(String ra, double nota) {
        Aluno aluno = repo.buscarPorRa(ra);
        if (aluno == null) {
            System.out.println("[ERRO] Aluno não encontrado: " + ra);
            return;
        }
        aluno.getNotas().add(nota);
        System.out.println("[NOTA] RA " + ra + " recebeu " + nota);
        gerarBoletim(ra);
    }

    // Sobrecarga
    public void registrarNota(String ra, int notaInteira) {
        registrarNota(ra, (double) notaInteira);
    }

    public double calcularMedia(String ra) {
        Aluno aluno = repo.buscarPorRa(ra);
        if (aluno == null) return 0.0;
        if (aluno.getNotas().isEmpty()) return 0.0;

        double soma = 0;
        for (double n : aluno.getNotas()) soma += n;
        return soma / aluno.getNotas().size();
    }

    public void gerarBoletim(String ra) {
        Aluno aluno = repo.buscarPorRa(ra);
        if (aluno == null) return;

        double media = calcularMedia(ra);
        System.out.println("[BOLETIM] " + aluno.getNome() +
            " | RA: " + aluno.getRa() + " | Média: " + media);

        if (media < 6.0) {
            notificacao.enviarEmail(aluno.getEmail(),
                "Atenção ao desempenho",
                "Sua média atual é " + media + ". Procure o professor.");
        }
    }
}
