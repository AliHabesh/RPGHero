package equipments;

import heroes.HeroAttributes;

public class Armor extends Item{
    private ArmorType armorType;
    private HeroAttributes armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public HeroAttributes getArmorAttribute() {
        return armorAttribute;
    }
}
