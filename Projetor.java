public class Projetor extends Equipamento {
    private String resolucaoMaxima;
    private boolean conexaoWIFI;
    private double DepreciacaoAnual = 0.10; // Depreciação anual de 10%
    public Projetor(String codigoPatrimonio, String descricao, double valor, int anoAquisicao, StatusManutencao statusManutencao, String resolucaoMaxima, boolean conexaoWIFI) {
        super(codigoPatrimonio, descricao, valor, anoAquisicao, statusManutencao);
        this.resolucaoMaxima = resolucaoMaxima;
        this.conexaoWIFI = conexaoWIFI;
    }

    public String getResolucaoMaxima() {
        return resolucaoMaxima;
    }
    public boolean getConexaoWIFI() {
        return conexaoWIFI;
    }
    public double getDepreciacaoAnual() {
        return DepreciacaoAnual;
    }
    public double calcularDepreciacaoAnual(){
        return getValor() * DepreciacaoAnual;
    }
    public String getCategoria(){
        return "Projetor";
    }
}
