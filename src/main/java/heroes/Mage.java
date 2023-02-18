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
    public Item equipArmor(Armor armor) throws InvalidArmorException {
        if (armor.getArmorType() != ArmorType.Cloth || armor.getRequiredLevel() != this.getLevel()){
            throw new InvalidArmorException();
        }


        this.getEquipment().put(armor.getSlot(), armor);
        return armor;
    }

    @Override
    public Item equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if ((weapon.getWeaponType() == WeaponType.Staffs || weapon.getWeaponType() == WeaponType.Wands) &&
                weapon.getRequiredLevel() == this.getLevel()){
            this.getEquipment().put(weapon.getSlot(), weapon);
            return weapon;
        }

        throw new InvalidWeaponException();
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+1);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+5);
    }


    @Override
    public double damage() {
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.Weapon);
        HeroAttributes heroAttributes = totalAttributes();
        return  weapon != null ? weapon.getWeaponDamage() * (1+heroAttributes.getIntelligence()/100.0) : 1;
    }




}
