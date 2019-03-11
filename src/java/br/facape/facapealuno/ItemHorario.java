package br.facape.facapealuno;

/**
 * Created by claudiohenrique on 28/09/14.
 */
public class ItemHorario {

    private String horario;
    private String diaSemana;
    private String disciplina;
    private String nomeProfessor;

    public ItemHorario(String horario, String diaSemana, String disciplina, String nomeProfessor) {
        super();
        this.horario = horario;
        this.diaSemana = diaSemana;
        this.disciplina = disciplina;
        this.nomeProfessor = nomeProfessor;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDiaSemana() {
        return this.diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getNomeProfessor() {
        return this.nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

}
