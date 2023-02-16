package heroes;

import com.sun.jdi.Value;
import equipments.Armor;
import equipments.Item;
import equipments.Slot;
import equipments.Weapon;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     *
     * @param armor
     * @return the argument that was passed in to the parameter if the item is equipable
     * @throws InvalidArmorException
     */
    abstract Item isArmorEquipable(Armor armor) throws InvalidArmorException;

    /**
     *
     * @param weapon
     * @return the argument that was passed in to the parameter if the item is equipable
     * @throws InvalidWeaponException
     */
    abstract Item isWeaponEquipable(Weapon weapon) throws InvalidWeaponException;

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

    public HashMap<Slot, Item> getEquipment() {
        return equipment;
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

    /**
     * Calculates the Heroes sum of levelling attributes and the armor attributes from the equipments.
     */
    public HeroAttributes totalAttributes(){
        var armorList = equipment.entrySet().stream().filter(entry -> entry.getValue() instanceof Armor);
        Map<String, Integer> attributeSumMap = new HashMap<>(Map.of("strength", 0, "dexterity",0, "intelligence", 0));

        armorList.forEach(entry -> {
            Armor armor = (Armor) entry.getValue();
           attributeSumMap.put("strength",  armor.getArmorAttribute().getStrength()+heroAttributes.getStrength());
            attributeSumMap.put("dexterity",  armor.getArmorAttribute().getDexterity()+heroAttributes.getDexterity());
            attributeSumMap.put("intelligence",  armor.getArmorAttribute().getIntelligence()+heroAttributes.getIntelligence());

        });

        return new HeroAttributes(attributeSumMap.get("strength"), attributeSumMap.get("dexterity"), attributeSumMap.get("intelligence"));
    }

    /**
     * Calculates the damage a hero deals which is based in their currently
     * equipped weapon and increased by their attributes.
     */
    public abstract int damage();

    /**
     * Displays the heroes data
     */
    public void display(){
        System.out.println( "Hero{" +
                "name='" + name + '\'' +
                ", Class=" +  getClass().getName()+
                ", level=" + level +
                ", heroAttributes=" + totalAttributes() +
                ", damage=" + damage() +
                '}'
        );
    }



}
