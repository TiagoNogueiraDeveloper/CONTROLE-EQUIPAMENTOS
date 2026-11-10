package PROJETOINOO;

public abstract class Equipamento {
    private String codigoPatrimonio;
    private String descricao;
    private double valor;
    private int anoAquisicao;
    private StatusManutencao statusManutencao;

    public Equipamento(String codigoPatrimonio, String descricao, double valor, int anoAquisicao, StatusManutencao statusManutencao) {
        this.codigoPatrimonio = codigoPatrimonio;
        this.descricao = descricao;
        this.valor = valor;
        this.anoAquisicao = anoAquisicao;
        this.statusManutencao = statusManutencao;
    }

    public void atualizarStatus(StatusManutencao statusManutencao){
        this.statusManutencao = statusManutencao;
    };
    public abstract double calcularDepreciacaoAnual();
    public double valorAtual(int anoReferencia){
        int anos = Math.max(0, anoReferencia - anoAquisicao);
        double valorAtual = valor - calcularDepreciacaoAnual() * anos;
        return valorAtual;
    }
    public abstract String getCategoria();

    public String getCodigoPatrimonio() {
        return codigoPatrimonio;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    public StatusManutencao getStatusManutencao() {
        return statusManutencao;
    }
}
