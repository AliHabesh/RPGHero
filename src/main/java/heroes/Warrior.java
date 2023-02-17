package heroes;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

public class Warrior extends Hero{


    public Warrior(String name) {
        super(name);
        this.setHeroAttributes(new HeroAttributes(5, 2, 1));

    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+2);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+3);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+1);
    }



    @Override
    public int damage() {
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.Weapon);
        HeroAttributes heroAttributes = totalAttributes();
        return  weapon.getWeaponDamage() * (1+heroAttributes.getStrength()/100);
    }

    @Override
    public void display() {

    }

    @Override
    public Item equipArmor(Armor armor) throws InvalidArmorException {
        if ((armor.getArmorType() == ArmorType.Plate) || (armor.getArmorType() == ArmorType.Mail))
            return armor;

        throw new InvalidArmorException();
    }

    @Override
    public Item equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() == WeaponType.Axes
                || weapon.getWeaponType() == WeaponType.Hammers
                || weapon.getWeaponType() == WeaponType.Swords)
            return weapon;


        throw new InvalidWeaponException();
    }
}
