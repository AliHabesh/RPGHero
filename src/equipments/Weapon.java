package equipments;

public class Weapon extends Item{
    private WeaponType weaponType;
    private int weaponDamage;

    public Weapon(String name, int requiredLevel ,WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, Slot.Weapon);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }




}
