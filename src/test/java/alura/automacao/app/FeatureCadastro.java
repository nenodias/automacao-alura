package alura.automacao.app;

import org.junit.jupiter.api.Test;

import alura.automacao.app.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FeatureCadastro {

    @Test
    public void erro_ao_cadastrar_usuario_com_senhas_que_nao_conferem() {
        final AppiumDriverConfig config = AppiumDriverConfig.getInstance();
        final boolean erro = new LoginPage(config)
                .irParaCadastro()
                .prencherCadastro("fulano", "senha", "outra")
                .clickBotaoCadastrar()
                .fail().verificaErro();
        assertThat("Ocorreu erro ao cadastrar?", erro, is(equalTo(true)));

        //Retornando o estado da aplicação para o pŕoximo teste
        config.getDriver().navigate().back();
    }

    @Test
    public void cadastrar_usuario_valido_e_faz_login() {
        final AppiumDriverConfig config = AppiumDriverConfig.getInstance();
        final boolean isInListaProdutosPage = new LoginPage(config)
                .irParaCadastro()
                .prencherCadastro("fulano", "senha", "senha")
                .clickBotaoCadastrar()
                .success()
                    .logar("fulano", "senha")
                    .isSuccess();
        assertThat("Conseguiu se cadastrar e realizar login?", isInListaProdutosPage, is(equalTo(true)));
    }

}
