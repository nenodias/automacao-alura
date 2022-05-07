package alura.automacao.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import alura.automacao.app.AppiumDriverConfig;
import alura.automacao.app.ResultInteraction;

public class LoginPage {
    public static final By.ById ID_BTN_CADASTRAR = new By.ById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    public static final By.ById ID_INPUT_USUARIO = new By.ById("br.com.alura.aluraesporte:id/input_usuario");
    public static final By.ById ID_INPUT_SENHA = new By.ById("br.com.alura.aluraesporte:id/input_senha");
    public static final By.ById ID_BTN_LOGIN = new By.ById("br.com.alura.aluraesporte:id/login_botao_logar");
    private final AppiumDriverConfig config;
    private final WebElement botaoCadastrar;
    private final WebElement inputUsuario;
    private final WebElement inputSenha;
    private final WebElement botaoLogar;

    public LoginPage(final AppiumDriverConfig config) {
        this.config = config;
        this.botaoCadastrar = config.getDriver().findElement(ID_BTN_CADASTRAR);
        this.inputUsuario = config.getDriver().findElement(ID_INPUT_USUARIO);
        this.inputSenha = config.getDriver().findElement(ID_INPUT_SENHA);
        this.botaoLogar = config.getDriver().findElement(ID_BTN_LOGIN);
    }

    public CadastroPage irParaCadastro(){
        this.botaoCadastrar.click();
        return new CadastroPage(config);
    }

    public ResultInteraction<ListaProdutosPage, LoginPage> logar(final String usuario, final String senha){
        this.inputUsuario.sendKeys(usuario);
        this.inputSenha.sendKeys(senha);
        this.botaoLogar.click();
        return ResultInteraction.both(()-> new ListaProdutosPage(config), () -> this);
    }

}
