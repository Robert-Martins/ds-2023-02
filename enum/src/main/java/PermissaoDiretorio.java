public enum PermissaoDiretorio {

    ESCRITA("Permissão de escrita em arquivo"),
    LEITURA("Permissão de leitura de um arquivo"),
    EXECUCAO("Permissão de execução de um arquivo");

    private final String description;

    PermissaoDiretorio(String description) {
        this.description = description;
    }

}
