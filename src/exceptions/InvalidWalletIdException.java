package exceptions;

public class InvalidWalletIdException extends IllegalArgumentException{
    public InvalidWalletIdException(){
        super("Invalid wallet ID");
    }
}
