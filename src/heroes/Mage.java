package heroes;

import equipments.Armor;
import equipments.ArmorType;
import equipments.Item;
import exceptions.InvalidArmorException;

public class Mage extends Hero{


    public Mage(String name){
        super(name);
        this.setHeroAttributes(new HeroAttributes(1, 1, 8));
    }
    
    @Override
    Item isItemEquipable(Armor armor) throws InvalidArmorException {
        if (armor.getArmorType() != ArmorType.Cloth){
            throw new InvalidArmorException("Mage can only wear cloth!");
        }

        return armor;
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+1);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+5);
    }
}
