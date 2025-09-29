public class FinanceiroService {
    private AlunoRepositorio repo;
    private NotificacaoService notificacao;

    public FinanceiroService(AlunoRepositorio repo, NotificacaoService notificacao) {
        this.repo = repo;
        this.notificacao = notificacao;
    }

    public void registrarPagamento(String ra, double valorPago) {
        Aluno aluno = repo.buscarPorRa(ra);
        if (aluno == null) {
            System.out.println("[ERRO] Aluno não encontrado: " + ra);
            return;
        }
        aluno.getPagamentos().add(valorPago);
        System.out.println("[PAGAMENTO] RA " + ra + " pagou " + Dinheiro.formatar(valorPago));
    }

    public StatusPagamento verificarStatusPagamento(String ra, double valorMensalidade) {
        Aluno aluno = repo.buscarPorRa(ra);
        if (aluno == null) return StatusPagamento.ATRASADO;

        double totalPago = 0;
        for (double v : aluno.getPagamentos()) totalPago += v;

        return (totalPago >= valorMensalidade) ? StatusPagamento.EM_DIA : StatusPagamento.ATRASADO;
    }
}
