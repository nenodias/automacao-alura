package alura.automacao.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import alura.automacao.app.AppiumDriverConfig;

public class ListaProdutosPage {
    public static final By.ById ID_BTN_LOGOUT = new By.ById("br.com.alura.aluraesporte:id/menu_principal_deslogar");
    public static final By.ById ID_LISTA_PRODUTOS = new By.ById("br.com.alura.aluraesporte:id/produtos");
    public static final By.ById ID_FRAME_PRODUTOS = new By.ById("br.com.alura.aluraesporte:id/listaProdutos");
    public static final By.ById ID_FRAME_PAGAMENTOS = new By.ById("br.com.alura.aluraesporte:id/listaPagamentos");
    private final AppiumDriverConfig config;
    private final WebElement menuDeslogar;
    private final WebElement listaProdutos;
    private final WebElement frameListaProdutos;
    private final WebElement frameListaPagamentos;

    public ListaProdutosPage(AppiumDriverConfig config) {
        this.config = config;
        this.menuDeslogar = config.getDriver().findElement(ID_BTN_LOGOUT);
        this.listaProdutos = config.getDriver().findElement(ID_LISTA_PRODUTOS);
        this.frameListaProdutos = config.getDriver().findElement(ID_FRAME_PRODUTOS);
        this.frameListaPagamentos = config.getDriver().findElement(ID_FRAME_PAGAMENTOS);
    }

    public LoginPage deslogar(){
        this.menuDeslogar.click();
        return new LoginPage(config);
    }
}
