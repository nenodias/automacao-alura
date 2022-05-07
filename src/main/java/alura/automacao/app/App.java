package alura.automacao.app;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            final AppiumDriverConfig config = AppiumDriverConfig.getInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
