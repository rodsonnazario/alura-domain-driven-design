package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento) {
        System.out.printf(
                "Aluno com CPF %s matriculado em: %s%n"
                , ((AlunoMatriculado) evento).getCpfDoAluno()
                , evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
        );
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
