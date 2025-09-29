import java.util.ArrayList;
import java.util.List;

public class AlunoRepositorio {
    private List<Aluno> lista = new ArrayList<>();

    public void salvar(Aluno aluno) {
        lista.add(aluno);
    }

    public Aluno buscarPorRa(String ra) {
        for (Aluno a : lista) {
            if (a.getRa().equals(ra)) return a;
        }
        return null;
    }

    public List<Aluno> listarTodos() {
        return lista;
    }
}
