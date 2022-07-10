package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.shared.dominio.evento.PublicadoDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;
    private final PublicadoDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadoDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    public void executa(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);

        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        publicador.publicar(evento);
    }
}
