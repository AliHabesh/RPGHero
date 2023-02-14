package heroes;

import equipments.Armor;
import equipments.ArmorType;
import equipments.Item;
import exceptions.InvalidArmorException;

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
    Item isItemEquipable(Armor armor) throws InvalidArmorException {
        if ((armor.getArmorType() == ArmorType.Leather) || (armor.getArmorType() == ArmorType.Mail))
            return armor;

        throw new InvalidArmorException("Ranger can only wear leather or mail !");
    }
}
