package alura.automacao.app;

import java.util.Optional;
import java.util.function.Supplier;

public class ResultInteraction<SUCCESS, ERROR> {
    private final Optional<SUCCESS> success;
    private final Optional<ERROR> error;

    private ResultInteraction(SUCCESS success, ERROR error) {
        this.success = Optional.ofNullable(success);
        this.error = Optional.ofNullable(error);
    }

    public static<SUCCESS, ERROR> ResultInteraction<SUCCESS, ERROR> both(Supplier<SUCCESS> successSupplier, Supplier<ERROR> errorSupplier){
        SUCCESS success = null;
        ERROR error = null;
        try{
            success = successSupplier.get();
        }catch (Exception ex){

        }
        try{
            error = errorSupplier.get();
        }catch (Exception ex){

        }
        return new ResultInteraction(success, error);
    }

    public static<SUCCESS, ERROR> ResultInteraction<SUCCESS, ERROR> sucess(SUCCESS success){
        return new ResultInteraction(success, null);
    }

    public static<SUCCESS, ERROR> ResultInteraction<SUCCESS, ERROR> fail(ERROR error){
        return new ResultInteraction(null, error);
    }

    public boolean isSuccess() {
        return success.isPresent();
    }

    public boolean isFail() {
        return error.isPresent();
    }

    public SUCCESS success() {
        return success.get();
    }

    public ERROR fail() {
        return error.get();
    }
}
