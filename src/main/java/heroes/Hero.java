package heroes;

import equipments.Armor;
import equipments.Item;
import equipments.Slot;
import equipments.Weapon;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class which is the foundation class for all the heroes
 */
public abstract class Hero {
    private String name;
    private int level = 1;
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
    public abstract Item equipArmor(Armor armor) throws InvalidArmorException;

    /**
     *
     * @param weapon
     * @return the argument that was passed in to the parameter if the item is equipable
     * @throws InvalidWeaponException
     */
    public abstract Item equipWeapon(Weapon weapon) throws InvalidWeaponException;

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
            Map<String, Integer> attributeSumMap = new HashMap<>(Map.of("strength", this.getHeroAttributes().getStrength(), "dexterity",this.getHeroAttributes().getDexterity(), "intelligence", this.getHeroAttributes().getIntelligence()));

            armorList.forEach(entry -> {
                Armor armor = (Armor) entry.getValue();
                attributeSumMap.put("strength",  attributeSumMap.get("strength") + armor.getArmorAttribute().getStrength());
                attributeSumMap.put("dexterity",  attributeSumMap.get("dexterity") + armor.getArmorAttribute().getDexterity());
                attributeSumMap.put("intelligence",  attributeSumMap.get("intelligence") + armor.getArmorAttribute().getIntelligence());
            });

            return new HeroAttributes(attributeSumMap.get("strength"), attributeSumMap.get("dexterity"), attributeSumMap.get("intelligence"));
        }

    /**
     * Calculates the damage a hero deals which is based in their currently
     * equipped weapon and increased by their attributes.
     */
    public abstract double damage();

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
