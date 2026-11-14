public enum StatusManutencao {
    EM_MANUTENCAO("Em manutenção"),
    OPERACIONAL("Operacional"),
    INATIVO("Inativo"),
    DANIFICADO("Danificado");

    private String descricao;

    StatusManutencao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
