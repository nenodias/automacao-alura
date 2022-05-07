package alura.automacao.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import alura.automacao.app.AppiumDriverConfig;
import alura.automacao.app.ResultInteraction;

public class LoginPage {
    private final AppiumDriverConfig config;
    private final WebElement botaoCadastrar;
    private final WebElement inputUsuario;
    private final WebElement inputSenha;
    private final WebElement botaoLogar;

    public LoginPage(final AppiumDriverConfig config) {
        this.config = config;
        this.botaoCadastrar = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        this.inputUsuario = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/input_usuario"));
        this.inputSenha = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/input_senha"));
        this.botaoLogar = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/login_botao_logar"));
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
