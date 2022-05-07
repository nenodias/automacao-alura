package alura.automacao.app;

import org.junit.jupiter.api.Test;

import alura.automacao.app.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FeatureCadastro {

    @Test
    public void erro_ao_cadastrar_usuario_com_senhas_que_nao_conferem() {
        final AppiumDriverConfig config = new AppiumDriverConfig();
        final boolean erro = new LoginPage(config)
                .irParaCadastro()
                .prencherCadastro("fulano", "senha", "outra")
                .clickCadastrar()
                .fail().verificaErro();
        assertThat("Ocorreu erro ao cadastrar?", erro, is(equalTo(true)));
    }

    @Test
    public void cadastrar_usuario_valido() {
        final AppiumDriverConfig config = new AppiumDriverConfig();
        final boolean isInLoginPage = new LoginPage(config)
                .irParaCadastro()
                .prencherCadastro("fulano", "senha", "senha")
                .clickCadastrar()
                .success()
                    .logar("fulano", "senha")
                    .isSuccess();
        assertThat("Esta na tela de login?", isInLoginPage, is(equalTo(true)));
    }

}
