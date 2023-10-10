import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EnderecoBuilderTeste {

    @Test
    public void testEnderecoBuilder() {
        Endereco endereco = Endereco.builder()
                .rua("Rua ali perto")
                .setor("Setor bem ali")
                .cep("#####-##")
                .numero(12)
                .cidade("Goiânia")
                .estado("Goiás")
                .quadra("Quadra logo ali")
                .bloco("Bloco cá do lado")
                .build();
        assertTrue(
                endereco.equals(
                        new Endereco(
                                "Rua ali perto",
                                "Setor bem ali",
                                "#####-##",
                                12,
                                "Goiânia",
                                "Goiás",

                                "Bloco cá do lado",
                                "Quadra logo ali"
                        )
                )
        );
    }

}
