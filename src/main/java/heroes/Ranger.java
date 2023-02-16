package heroes;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

public class Ranger extends Hero{

    public Ranger(String name) {
        super(name);
        this.setHeroAttributes(new HeroAttributes(1, 7, 1));
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+5);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+1);
    }



    @Override
    public int damage() {
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.Weapon);
        HeroAttributes heroAttributes = totalAttributes();
        return heroAttributes.getDexterity() + weapon.getWeaponDamage();
    }

    @Override
    public void display() {

    }

    @Override
    Item isArmorEquipable(Armor armor) throws InvalidArmorException {
        if ((armor.getArmorType() == ArmorType.Leather) || (armor.getArmorType() == ArmorType.Mail))
            return armor;

        throw new InvalidArmorException("Ranger can only wear leather or mail !");
    }

    @Override
    Item isWeaponEquipable(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() != WeaponType.Bows)
            throw new InvalidWeaponException("Mage can only equip Staff or Wands as weapons !");

        return weapon;
    }
}