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
    public double damage() {
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.Weapon);
        HeroAttributes heroAttributes = totalAttributes();
        return  weapon != null ? weapon.getWeaponDamage() * (1+heroAttributes.getDexterity()/100.0) : 1;
    }



    @Override
    public Item equipArmor(Armor armor) throws InvalidArmorException {
        if ((armor.getArmorType() == ArmorType.Leather) || (armor.getArmorType() == ArmorType.Mail) && armor.getRequiredLevel() == this.getLevel()){
            this.getEquipment().put(armor.getSlot(), armor);
            return armor;
        }

        throw new InvalidArmorException();
    }

    @Override
    public Item equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if ((weapon.getWeaponType() == WeaponType.Daggers || weapon.getWeaponType() == WeaponType.Swords) && this.getLevel() == weapon.getRequiredLevel()){
            this.getEquipment().put(weapon.getSlot(), weapon);
            return weapon;
        }



        throw new InvalidWeaponException();
    }
}
