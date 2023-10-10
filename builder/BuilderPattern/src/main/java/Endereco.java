import java.util.Objects;

public class Endereco {

    private String rua;
    private String setor;
    private String cep;
    private Integer numero;
    private String cidade;
    private String estado;
    private String bloco;
    private String quadra;

    public Endereco(String rua, String setor, String cep, Integer numero, String cidade, String estado, String bloco, String quadra) {
        this.rua = rua;
        this.setor = setor;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.bloco = bloco;
        this.quadra = quadra;
    }

    public static EnderecoBuilder builder() {
        return new EnderecoBuilder();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(rua, endereco.rua) && Objects.equals(setor, endereco.setor) && Objects.equals(cep, endereco.cep) && Objects.equals(numero, endereco.numero) && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado) && Objects.equals(bloco, endereco.bloco) && Objects.equals(quadra, endereco.quadra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, setor, cep, numero, cidade, estado, bloco, quadra);
    }
}
