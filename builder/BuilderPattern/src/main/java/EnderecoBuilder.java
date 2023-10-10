public class EnderecoBuilder {

    private String _rua;
    private String _setor;
    private String _cep;
    private Integer _numero;
    private String _cidade;
    private String _estado;
    private String _bloco;
    private String _quadra;

    public EnderecoBuilder rua(String rua) {
        this._rua = rua;
        return this;
    }

    public EnderecoBuilder setor(String setor) {
        this._setor = setor;
        return this;
    }

    public EnderecoBuilder cep(String cep) {
        this._cep = cep;
        return this;
    }

    public EnderecoBuilder numero(Integer numero) {
        this._numero = numero;
        return this;
    }

    public EnderecoBuilder cidade(String cidade) {
        this._cidade = cidade;
        return this;
    }

    public EnderecoBuilder estado(String estado) {
        this._estado = estado;
        return this;
    }

    public EnderecoBuilder bloco(String bloco) {
        this._bloco = bloco;
        return this;
    }

    public EnderecoBuilder quadra(String quadra) {
        this._quadra = quadra;
        return this;
    }

    public Endereco build() {
        return new Endereco(
                this._rua,
                this._setor,
                this._cep,
                this._numero,
                this._cidade,
                this._estado,
                this._bloco,
                this._quadra
        );
    }

}
