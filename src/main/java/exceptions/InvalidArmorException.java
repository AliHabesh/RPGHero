package exceptions;

public class InvalidArmorException extends Exception{
    public InvalidArmorException(){
        super("You can not equip this item");
    }
}
