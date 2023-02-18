package equipments;

import heroes.HeroAttributes;

public class Armor extends Item{
    private ArmorType armorType;
    private HeroAttributes armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttributes armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public HeroAttributes getArmorAttribute() {
        return armorAttribute;
    }
}
