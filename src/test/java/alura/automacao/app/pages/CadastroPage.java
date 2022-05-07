package alura.automacao.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import alura.automacao.app.AppiumDriverConfig;
import alura.automacao.app.ResultInteraction;

public class CadastroPage {
    public static final By.ById ID_INPUT_NOME = new By.ById("br.com.alura.aluraesporte:id/input_nome");
    public static final By.ById ID_INPUT_SENHA = new By.ById("br.com.alura.aluraesporte:id/input_senha");
    public static final By.ById ID_INPUT_CONFIRMACAO_SENHA = new By.ById("br.com.alura.aluraesporte:id/input_confirmar_senha");
    public static final By.ById ID_BTN_CADASTRAR = new By.ById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    public static final By.ById ID_MENSAGEM_ERRO = new By.ById("br.com.alura.aluraesporte:id/erro_cadastro");
    private final AppiumDriverConfig config;
    private final WebElement inputNome;
    private final WebElement inputSenha;
    private final WebElement inputConfirmacaoSenha;
    private final WebElement botaoCadastrar;


    public CadastroPage(final AppiumDriverConfig config) {
        this.config = config;
        this.inputNome = config.getDriver().findElement(ID_INPUT_NOME);
        this.inputSenha = config.getDriver().findElement(ID_INPUT_SENHA);
        this.inputConfirmacaoSenha = config.getDriver().findElement(ID_INPUT_CONFIRMACAO_SENHA);
        this.botaoCadastrar = config.getDriver().findElement(ID_BTN_CADASTRAR);
    }

    public CadastroPage prencherCadastro(final String usuario, final String senha, final String confirmacaoSenha) {
        this.inputNome.sendKeys(usuario);
        this.inputSenha.sendKeys(senha);
        this.inputConfirmacaoSenha.sendKeys(confirmacaoSenha);
        return this;
    }

    public Boolean verificaErro() {
        final WebDriverWait espera = new WebDriverWait(config.getDriver(), Duration.ofSeconds(10));
        System.out.println(espera.until(ExpectedConditions.presenceOfElementLocated(ID_MENSAGEM_ERRO)).getText());
        if (config.hasElement(ID_MENSAGEM_ERRO)) {
            final WebElement labelErro = config.getDriver().findElement(ID_MENSAGEM_ERRO);
            return "Senhas não conferem".equals(labelErro.getText());
        }
        return false;
    }

    public ResultInteraction<LoginPage, CadastroPage> clickBotaoCadastrar() {
        this.botaoCadastrar.click();
        return ResultInteraction.both(() -> new LoginPage(config), () -> this);
    }

}
