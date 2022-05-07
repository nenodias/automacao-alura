package alura.automacao.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import alura.automacao.app.AppiumDriverConfig;

public class ListaProdutosPage {
    private final AppiumDriverConfig config;
    private final WebElement menuDeslogar;
    private final WebElement listaProdutos;
    private final WebElement frameListaProdutos;
    private final WebElement frameListaPagamentos;

    public ListaProdutosPage(AppiumDriverConfig config) {
        this.config = config;
        this.menuDeslogar = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/menu_principal_deslogar"));
        this.listaProdutos = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/menu_principal_deslogar"));
        this.frameListaProdutos = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/listaProdutos"));
        this.frameListaPagamentos = config.getDriver().findElement(new By.ById("br.com.alura.aluraesporte:id/listaPagamentos"));
    }

    public LoginPage deslogar(){
        return new LoginPage(config);
    }
}
