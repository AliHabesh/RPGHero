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
    public double damage() {
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.Weapon);
        HeroAttributes heroAttributes = totalAttributes();
        return  weapon.getWeaponDamage() * (1+heroAttributes.getDexterity()/100);
    }

    @Override
    public Item equipArmor(Armor armor) throws InvalidArmorException {
        if ((armor.getArmorType() == ArmorType.Leather) || (armor.getArmorType() == ArmorType.Mail))
            return armor;

        this.getEquipment().put(armor.getSlot(), armor);
        throw new InvalidArmorException();
    }

    @Override
   public Item equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() != WeaponType.Bows)
            throw new InvalidWeaponException();

        this.getEquipment().put(weapon.getSlot(), weapon);
        return weapon;
    }
}
