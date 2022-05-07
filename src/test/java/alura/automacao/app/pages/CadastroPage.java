package alura.automacao.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import alura.automacao.app.AppiumDriverConfig;
import alura.automacao.app.ResultInteraction;
import io.appium.java_client.android.AndroidDriver;

public class CadastroPage {
    private final AppiumDriverConfig config;
    private final WebElement inputNome;
    private final WebElement inputSenha;
    private final WebElement inputConfirmacaoSenha;
    private final WebElement botaoCadastrar;


    public CadastroPage(final AppiumDriverConfig config) {
        this.config = config;
        this.inputNome = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/input_nome"));
        this.inputSenha = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/input_senha"));
        this.inputConfirmacaoSenha = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/input_confirmar_senha"));
        this.botaoCadastrar = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
    }

    public CadastroPage prencherCadastro(final String usuario, final String senha, final String confirmacaoSenha) {
        this.inputNome.sendKeys(usuario);
        this.inputSenha.sendKeys(senha);
        this.inputConfirmacaoSenha.sendKeys(confirmacaoSenha);
        return this;
    }

    public Boolean verificaErro() {
        final By byId = new By.ById("br.com.alura.aluraesporte:id/erro_cadastro");
        if (config.hasElement(byId)) {
            final WebElement labelErro = config.getDriver().findElement(byId);
            return "Senhas não conferem".equals(labelErro.getText());
        }
        return false;
    }

    public ResultInteraction<LoginPage, CadastroPage> clickCadastrar() {
        this.botaoCadastrar.click();
        return ResultInteraction.both(() -> new LoginPage(config), () -> this);
    }


    public Optional<LoginPage> irParaLogin() {
        if (!this.verificaErro()) {
            return Optional.of(new LoginPage(config));
        }
        return Optional.empty();
    }
}
