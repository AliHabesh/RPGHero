package heroes_testing;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import heroes.Hero;
import heroes.HeroAttributes;
import heroes.Mage;
import heroes.Ranger;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class RangerTest {
    @Test
    public void check_Hero_Initialization_values(){
        Hero hero = new Ranger("Durango Vyediko");
        assertTrue(hero.getName().equals("Durango Vyediko") && hero.getLevel() == 1 &&
                hero.getHeroAttributes().getStrength() == 1 &&
                hero.getHeroAttributes().getDexterity() == 7 &&
                hero.getHeroAttributes().getIntelligence() == 1);
    }

    @Test
    public void increase_Hero_level(){
        Hero hero = new Ranger("Durango Vyediko");
        //Test levels before leveling up
        assertTrue(hero.getLevel() == 1 &&
                hero.getHeroAttributes().getStrength() == 1 &&
                hero.getHeroAttributes().getDexterity() == 7 &&
                hero.getHeroAttributes().getIntelligence() == 1);
        hero.LevelUp();
        //Test levelUp(); after initialization
        assertTrue(hero.getLevel() == 2 &&
                hero.getHeroAttributes().getStrength() == 2 &&
                hero.getHeroAttributes().getDexterity() == 12 &&
                hero.getHeroAttributes().getIntelligence() == 2);
    }

    @Test
    public void hero_Equip_Armor(){
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("protector", 2, Slot.Body, ArmorType.Plate, attributes);
        Hero hero = new Ranger("Durango Vyediko");
        assertThrows(InvalidArmorException.class, () -> {
            hero.equipArmor(armor);
        });
    }

    @Test
    public void hero_Equip_WeaponType(){
        Weapon weapon = new Weapon("Axer", 1, WeaponType.Swords, 1);
        Hero hero = new Mage("Gandalf");
        assertThrows(InvalidWeaponException.class, () -> {
            hero.equipWeapon(weapon);
        });
    }

    @Test
    public void hero_Equip_Weapon_RequiredLevel(){
        Weapon weapon = new Weapon("MrBow", 2, WeaponType.Bows, 1);
        Hero hero = new Mage("Durango Vyediko");
        assertThrows(InvalidWeaponException.class, () -> {
            hero.equipWeapon(weapon);
        });
    }

    @Test
    public void total_attributes_no_equipment(){
        Hero hero = new Ranger("Durango Vyediko");
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 1 && heroAttributes.getDexterity() == 7 && heroAttributes.getIntelligence() == 1);
    }

    @Test
    public void total_attributes_one_armor_equipment() throws InvalidArmorException {
        Hero hero = new Ranger("Durango Vyediko");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("RangerHelmet", 1, Slot.Head, ArmorType.Leather, attributes);
        hero.equipArmor(armor);
        HeroAttributes heroAttributes = hero.totalAttributes();
        System.out.println(heroAttributes);
        assertTrue(heroAttributes.getStrength() == 2 && heroAttributes.getDexterity() == 8 && heroAttributes.getIntelligence() == 2);
    }

    @Test
    public void total_attributes_two_armor_equipments() throws InvalidArmorException {
        Hero hero = new Ranger("Durango Vyediko");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("RangerHelmet", 1, Slot.Head, ArmorType.Leather, attributes);
        Armor armor2 = new Armor("RangerShirt", 1, Slot.Body, ArmorType.Mail, attributes);
        hero.equipArmor(armor);
        hero.equipArmor(armor2);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 3 && heroAttributes.getDexterity() == 9 && heroAttributes.getIntelligence() == 3);
    }

    @Test
    public void total_attributes_replace_armor_equipment() throws InvalidArmorException {
        Hero hero = new Ranger("Durango Vyediko");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        HeroAttributes attributes2 = new HeroAttributes(1, 1, 1);
        Armor firstArmor = new Armor("RangerHelm", 1, Slot.Head, ArmorType.Leather, attributes);
        Armor replceArmor = new Armor("RangerHelm", 1, Slot.Head, ArmorType.Leather, attributes2);
        hero.equipArmor(firstArmor);
        hero.equipArmor(replceArmor);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 2 && heroAttributes.getDexterity() == 8 && heroAttributes.getIntelligence() == 2);
    }

    @Test
    public void hero_damage_no_weapon_equipment() {
        Hero hero = new Ranger("Durango Vyediko");
        double heroTotalDamage = hero.damage();
        System.out.println(heroTotalDamage);
        assertTrue(heroTotalDamage == 1);
    }

    @Test
    public void hero_damage_weapon_equipped() throws InvalidWeaponException {
        Hero hero = new Ranger("Durango Vyediko");
        Weapon weapon = new Weapon("RangerBow", 1, WeaponType.Bows, 1);
        hero.equipWeapon(weapon);
        double heroTotalDamage = hero.damage();
        System.out.println(heroTotalDamage);
        assertTrue(heroTotalDamage == 1.0);
    }

    @Test
    public void hero_damage_replace_weapon_equipment() throws InvalidWeaponException {
        Hero hero = new Ranger("Durango Vyediko");
        Weapon weapon = new Weapon("RangerBow", 1, WeaponType.Bows, 1);
        Weapon replacementWeapon = new Weapon("BowReplacement", 1, WeaponType.Bows, 2);
        hero.equipWeapon(weapon);
        hero.equipWeapon(replacementWeapon);
        double heroTotalDamage = hero.damage();
        System.out.println(heroTotalDamage);
        assertTrue(heroTotalDamage == 2.14);

    }

    @Test
    public void hero_damage_weapon_and_armor_equipment() throws InvalidWeaponException, InvalidArmorException {
        Hero hero = new Ranger("Durango Vyediko");

        Weapon weapon = new Weapon("StaffReplacement", 1, WeaponType.Bows, 2);
        hero.equipWeapon(weapon);

        HeroAttributes armorAttribute = new HeroAttributes(1, 3, 1);
        Armor armor = new Armor("Shirt", 1, Slot.Body, ArmorType.Mail, armorAttribute);
        hero.equipArmor(armor);

        double heroTotalDamage = hero.damage();
        System.out.println(heroTotalDamage);
        assertTrue(heroTotalDamage == 2.2);
    }

}
