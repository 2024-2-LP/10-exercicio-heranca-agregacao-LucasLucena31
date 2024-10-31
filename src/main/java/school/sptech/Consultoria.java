package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Double getTotalSalarios(){
        Double salario = 0.0;
        for (Desenvolvedor devDaVez : desenvolvedores) {
            salario += devDaVez.calcularSalario();
        }
        return salario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int qtdMobile = 0;
        for (Desenvolvedor devDaVez : desenvolvedores) {
            if (devDaVez instanceof DesenvolvedorMobile){
                qtdMobile++;
            }
        }
        return qtdMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> busca = new ArrayList<>();
        for (Desenvolvedor devDaVez : desenvolvedores) {
            if (devDaVez.calcularSalario() >= salario){
                busca.add(devDaVez);
            }
        }
        return busca;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor mnrSalario = desenvolvedores.get(0);

        for (Desenvolvedor devDaVez : desenvolvedores) {
            if (devDaVez.calcularSalario() < mnrSalario.calcularSalario()){
                mnrSalario = devDaVez;
            }
        }
        return mnrSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> busca = new ArrayList<>();

        for (Desenvolvedor devDaVez : desenvolvedores) {
            if (devDaVez instanceof DesenvolvedorMobile){
                DesenvolvedorMobile devTp = (DesenvolvedorMobile) devDaVez;

                if (devTp.getLinguagem().equals(tecnologia) || devTp.getPlataforma().equals(tecnologia)){
                    busca.add(devTp);
                }
            } else if(devDaVez instanceof DesenvolvedorWeb){
                DesenvolvedorWeb devTp = (DesenvolvedorWeb) devDaVez;

                if (devTp.getFrontend().equals(tecnologia) || devTp.getBackend().equals(tecnologia) || devTp.getSgbd().equals(tecnologia)){
                    busca.add(devTp);
                }
            }
        }
        return busca;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> devs = buscarPorTecnologia(tecnologia);

        Double salario = 0.0;

        for (Desenvolvedor devDaVez : devs) {
            salario += devDaVez.calcularSalario();
        }
        return salario;
    }

}
