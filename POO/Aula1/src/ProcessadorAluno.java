public class ProcessadorAluno {
    private AlunoRepositorio repo;
    private NotificacaoService notificacao;
    private AcademicoService academico;
    private FinanceiroService financeiro;
    private RelatorioService relatorio;

    public ProcessadorAluno() {
        this.repo = new AlunoRepositorio();
        this.notificacao = new NotificacaoService();
        this.academico = new AcademicoService(repo, notificacao);
        this.financeiro = new FinanceiroService(repo, notificacao);
        this.relatorio = new RelatorioService(repo, academico);
    }

    public void cadastrarAluno(String ra, String nome, String email, Serie serie) {
        if (repo.buscarPorRa(ra) != null) {
            System.out.println("[ERRO] Já existe aluno com RA " + ra);
            return;
        }
        Aluno aluno = new Aluno(ra, nome, email, serie);
        repo.salvar(aluno);
        System.out.println("[CADASTRO] " + nome + " cadastrado na série " + serie);
        notificacao.enviarEmail(email, "Bem-vindo(a)!", "Seu cadastro foi criado com sucesso.");
    }

    public void registrarNota(String ra, double nota) {
        academico.registrarNota(ra, nota);
    }

    public void registrarNota(String ra, int notaInteira) {
        academico.registrarNota(ra, notaInteira);
    }

    public void registrarPagamento(String ra, double valor) {
        financeiro.registrarPagamento(ra, valor);
    }

    public void verificarStatus(String ra, double mensalidade) {
        StatusPagamento status = financeiro.verificarStatusPagamento(ra, mensalidade);
        System.out.println("Status financeiro: " + status.getRotulo());
    }

    public void exportarCSV() {
        relatorio.exportarCSV();
    }

    public void registrarAdvertenciaPorFaltaEmAvaliacao(String ra, boolean faltou) {
        Aluno aluno = repo.buscarPorRa(ra);
        if (aluno == null) return;
        if (faltou) {
            System.out.println("[OCORRENCIA] RA " + ra + " recebeu advertência por falta em avaliação.");
            notificacao.enviarEmail(aluno.getEmail(),
                "Advertência registrada",
                "Compareça à coordenação para ciência.");
        }
    }
}
