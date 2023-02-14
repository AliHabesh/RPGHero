package heroes;

import equipments.Armor;
import equipments.Item;
import equipments.Slot;
import exceptions.InvalidArmorException;

import java.util.HashMap;

/**
 * Abstract class which is the foundation class for all the heroes
 */
public abstract class Hero {
    private String name;
    private int level;
    private HeroAttributes heroAttributes;

    private HashMap<Slot, Item> equipment;

    public Hero(String name){
        this.name = name;
        initializeEquipment();
    }

    /**
     Initializes equipments with null values for each Slot enum value.
     **/
    private void initializeEquipment(){
        this.equipment = new HashMap<>();
        this.equipment.put(Slot.Head, null);
        this.equipment.put(Slot.Body, null);
        this.equipment.put(Slot.Legs, null);
        this.equipment.put(Slot.Weapon, null);
    }

    abstract Item isItemEquipable(Armor armor) throws InvalidArmorException;

    public abstract void LevelUp();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HeroAttributes getHeroAttributes() {
        return heroAttributes;
    }

    public void setHeroAttributes(HeroAttributes heroAttributes) {
        this.heroAttributes = heroAttributes;
    }
}
