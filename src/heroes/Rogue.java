package heroes;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name);
        this.setHeroAttributes(new HeroAttributes(2, 6, 1));
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+4);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+1);

    }

    @Override
    Item isArmorEquipable(Armor armor) throws InvalidArmorException {
        if ((armor.getArmorType() == ArmorType.Leather) || (armor.getArmorType() == ArmorType.Mail))
            return armor;

        throw new InvalidArmorException("Rogue can only wear leather or mail !");
    }

    @Override
    Item isWeaponEquipable(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() == WeaponType.Daggers || weapon.getWeaponType() == WeaponType.Swords)
            return weapon;


        throw new InvalidWeaponException("Mage can only equip Staff or Wands as weapons !");
    }
}
