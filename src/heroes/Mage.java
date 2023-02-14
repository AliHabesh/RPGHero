package heroes;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

public class Mage extends Hero{


    public Mage(String name){
        super(name);
        this.setHeroAttributes(new HeroAttributes(1, 1, 8));
    }

    @Override
    Item isArmorEquipable(Armor armor) throws InvalidArmorException {
        if (armor.getArmorType() != ArmorType.Cloth){
            throw new InvalidArmorException("Mage can only wear cloth!");
        }

        return armor;
    }

    @Override
    Item isWeaponEquipable(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() == WeaponType.Staffs || weapon.getWeaponType() == WeaponType.Wands){
            return weapon;
        }

        throw new InvalidWeaponException("Mage can only equip Staff or Wands as weapons !");
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+1);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+5);
    }
}
