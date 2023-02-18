package heroes_testing;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import heroes.Hero;
import heroes.HeroAttributes;
import heroes.Mage;
import heroes.Warrior;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class WarriorTest {

    @Test
    public void check_Hero_Initialization_values(){
        Hero hero = new Warrior("Garen");
        assertTrue(hero.getName().equals("Garen") && hero.getLevel() == 1 &&
                hero.getHeroAttributes().getStrength() == 5 &&
                hero.getHeroAttributes().getDexterity() == 2 &&
                hero.getHeroAttributes().getIntelligence() == 1);
    }

    @Test
    public void increase_Hero_level(){
        Hero hero = new Warrior("Garen");
        //Test levels before leveling up
        assertTrue(hero.getLevel() == 1 &&
                hero.getHeroAttributes().getStrength() == 5 &&
                hero.getHeroAttributes().getDexterity() == 2 &&
                hero.getHeroAttributes().getIntelligence() == 1);
        hero.LevelUp();
        //Test levelUp(); after initialization
        assertTrue(hero.getLevel() == 2 &&
                hero.getHeroAttributes().getStrength() == 8 &&
                hero.getHeroAttributes().getDexterity() == 4 &&
                hero.getHeroAttributes().getIntelligence() == 2);
    }

    @Test
    public void hero_Equip_Armor(){
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("DivinePlate", 2, Slot.Body, ArmorType.Cloth, attributes);
        Hero hero = new Warrior("Garen");
        assertThrows(InvalidArmorException.class, () -> {
            hero.equipArmor(armor);
        });
    }

    @Test
    public void hero_Equip_WeaponType(){
        Weapon weapon = new Weapon("Axer", 1, WeaponType.Bows, 1);
        Hero hero = new Warrior("Garen");
        assertThrows(InvalidWeaponException.class, () -> {
            hero.equipWeapon(weapon);
        });
    }

    @Test
    public void hero_Equip_Weapon_RequiredLevel(){
        Weapon weapon = new Weapon("MrSword", 2, WeaponType.Swords, 1);
        Hero hero = new Warrior("Garen");
        assertThrows(InvalidWeaponException.class, () -> {
            hero.equipWeapon(weapon);
        });
    }

    @Test
    public void total_attributes_no_equipment(){
        Hero hero = new Warrior("Garen");
        HeroAttributes heroAttributes = hero.totalAttributes();
        System.out.println(heroAttributes);
        assertTrue(heroAttributes.getStrength() == 5 && heroAttributes.getDexterity() == 2 &&
                    heroAttributes.getIntelligence() == 1);

    }

    @Test
    public void total_attributes_one_armor_equipment() throws InvalidArmorException {
        Hero hero = new Warrior("Garen");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("WarriorHelmet", 1, Slot.Head, ArmorType.Plate, attributes);
        hero.equipArmor(armor);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 6 && heroAttributes.getDexterity() == 3 && heroAttributes.getIntelligence() == 2);
    }

    @Test
    public void total_attributes_two_armor_equipments() throws InvalidArmorException {
        Hero hero = new Warrior("Garen");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("WarriorHelmet", 1, Slot.Head, ArmorType.Mail, attributes);
        Armor armor2 = new Armor("WarriorVest", 1, Slot.Body, ArmorType.Plate, attributes);
        hero.equipArmor(armor);
        hero.equipArmor(armor2);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 7 && heroAttributes.getDexterity() == 4 && heroAttributes.getIntelligence() == 3);

    }

    @Test
    public void total_attributes_replace_armor_equipment() throws InvalidArmorException {
        Hero hero = new Warrior("Garen");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("WarriorHelmet", 1, Slot.Head, ArmorType.Mail, attributes);
        Armor armor2 = new Armor("WarriorHelmetTwo", 1, Slot.Head, ArmorType.Plate, attributes);
        hero.equipArmor(armor);
        hero.equipArmor(armor2);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 6 && heroAttributes.getDexterity() == 3 && heroAttributes.getIntelligence() == 2);
    }

    @Test
    public void hero_damage_no_weapon_equipment() {
        Hero hero = new Warrior("Garen");
        double heroTotalDamage = hero.damage();
        System.out.println(heroTotalDamage);
        assertTrue(heroTotalDamage == 1);
    }

    @Test
    public void hero_damage_weapon_equipped() throws InvalidWeaponException {
        Hero hero = new Warrior("Garen");
        Weapon weapon = new Weapon("MrHammer", 1, WeaponType.Hammers, 1);
        hero.equipWeapon(weapon);
        double heroTotalDamage = hero.damage();
        assertTrue(heroTotalDamage == 1.05);
    }

    @Test
    public void hero_damage_replace_weapon_equipment() throws InvalidWeaponException {
        Hero hero = new Warrior("Garen");
        Weapon weapon = new Weapon("MrHammer", 1, WeaponType.Hammers, 1);
        Weapon replacementWeapon = new Weapon("MrHammerTwo", 1, WeaponType.Hammers, 2);
        hero.equipWeapon(weapon);
        hero.equipWeapon(replacementWeapon);
        double heroTotalDamage = hero.damage();
        assertTrue(heroTotalDamage == 2.1);
    }

    @Test
    public void hero_damage_weapon_and_armor_equipment() throws InvalidWeaponException, InvalidArmorException {
        Hero hero = new Warrior("Garen");

        Weapon weapon = new Weapon("MrHammer", 1, WeaponType.Hammers, 2);
        hero.equipWeapon(weapon);

        HeroAttributes armorAttribute = new HeroAttributes(3, 1, 1);
        Armor armor = new Armor("Shirt", 1, Slot.Body, ArmorType.Plate, armorAttribute);
        hero.equipArmor(armor);

        double heroTotalDamage = hero.damage();
        assertTrue(heroTotalDamage == 2.16);
    }

}
