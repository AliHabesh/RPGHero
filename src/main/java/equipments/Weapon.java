package equipments;

public class Weapon extends Item{
    private WeaponType weaponType;
    private int weaponDamage;

    public Weapon(String name, int requiredLevel ,WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, Slot.Weapon);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType=" + weaponType +
                ", weaponDamage=" + weaponDamage +
                '}';
    }
}
