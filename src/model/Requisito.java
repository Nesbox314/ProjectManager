package model;

public class Requisito {

    int id;
    int idProjeto;
    String nome;
    String descricao;
    String modulo;
    String funcionalidade;
    String datacriacao;
    int idAutor;
    String fase;
    String complexidade;
    String prioridade;
    String versao;
    String ultimoautor;
    String dataultimacriacao;
    String esforco;
    String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(String funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getUltimoautor() {
        return ultimoautor;
    }

    public void setUltimoautor(String ultimoautor) {
        this.ultimoautor = ultimoautor;
    }

    public String getDataultimacriacao() {
        return dataultimacriacao;
    }

    public void setDataultimacriacao(String dataultimacriacao) {
        this.dataultimacriacao = dataultimacriacao;
    }

    public String getEsforco() {
        return esforco;
    }

    public void setEsforco(String esforco) {
        this.esforco = esforco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
