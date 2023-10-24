public enum PontoCardeal {

    N("Norte"),
    S("Sul"),
    L("Leste"),
    O("Oeste"),
    NE("Nordeste"),
    SE("Sudeste"),
    SO("Sudoeste"),
    NO("Noroeste");

    private final String description;

    PontoCardeal(String description) {
        this.description = description;
    }

}
