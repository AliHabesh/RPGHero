package exceptions;

public class InvalidWeaponException extends Exception{

    public InvalidWeaponException(){
        super("Can not equipt this weapon");
    }
}
