package heroes_testing;

import equipments.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import heroes.Hero;
import heroes.HeroAttributes;
import heroes.Mage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class MageTest {

    @Test
    public void check_Hero_Initialization_values(){
        Hero hero = new Mage("Gandalf");
        assertTrue(hero.getName().equals("Gandalf") && hero.getLevel() == 1 &&
                hero.getHeroAttributes().getStrength() == 1 &&
                hero.getHeroAttributes().getDexterity() == 1 &&
                hero.getHeroAttributes().getIntelligence() == 8);
    }

    @Test
    public void increase_Hero_level(){
        Hero hero = new Mage("Gandalf");
        //Test levels before leveling up
        assertTrue(hero.getLevel() == 1 &&
                hero.getHeroAttributes().getStrength() == 1 &&
                hero.getHeroAttributes().getDexterity() == 1 &&
                hero.getHeroAttributes().getIntelligence() == 8);
        hero.LevelUp();
        //Test levelUp(); after initialization
        assertTrue(hero.getLevel() == 2 &&
                hero.getHeroAttributes().getStrength() == 2 &&
                hero.getHeroAttributes().getDexterity() == 2 &&
                hero.getHeroAttributes().getIntelligence() == 13);
    }

    @Test
    public void hero_Equip_Armor(){
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("divineShirt", 2, Slot.Body, ArmorType.Cloth, attributes);
        Hero hero = new Mage("Gandalf");
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
        Weapon weapon = new Weapon("MrStaff", 2, WeaponType.Staffs, 1);
        Hero hero = new Mage("Gandalf");
        assertThrows(InvalidWeaponException.class, () -> {
            hero.equipWeapon(weapon);
        });
    }

    @Test
    public void total_attributes_no_equipment(){
        Hero hero = new Mage("Gandalf");
        HeroAttributes heroAttributes = hero.totalAttributes();
        System.out.println(heroAttributes);
        assertTrue(heroAttributes.getStrength() == 1 && heroAttributes.getDexterity() == 1 && heroAttributes.getIntelligence() == 8);

    }

    @Test
    public void total_attributes_one_armor_equipment() throws InvalidArmorException {
        Hero hero = new Mage("Gandalf");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("MageHat", 1, Slot.Head, ArmorType.Cloth, attributes);
        hero.equipArmor(armor);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 2 && heroAttributes.getDexterity() == 2 && heroAttributes.getIntelligence() == 9);
    }

    @Test
    public void total_attributes_two_armor_equipments() throws InvalidArmorException {
        Hero hero = new Mage("Gandalf");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        Armor armor = new Armor("MageHat", 1, Slot.Head, ArmorType.Cloth, attributes);
        Armor armor2 = new Armor("MageShirt", 1, Slot.Body, ArmorType.Cloth, attributes);
        hero.equipArmor(armor);
        hero.equipArmor(armor2);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 3 && heroAttributes.getDexterity() == 3 && heroAttributes.getIntelligence() == 10);

    }

    @Test
    public void total_attributes_replace_armor_equipment() throws InvalidArmorException {
        Hero hero = new Mage("Gandalf");
        HeroAttributes attributes = new HeroAttributes(1, 1, 1);
        HeroAttributes attributes2 = new HeroAttributes(1, 1, 1);
        Armor firstArmor = new Armor("MageHat", 1, Slot.Head, ArmorType.Cloth, attributes);
        Armor replceArmor = new Armor("MageShirt", 1, Slot.Head, ArmorType.Cloth, attributes2);
        hero.equipArmor(firstArmor);
        hero.equipArmor(replceArmor);
        HeroAttributes heroAttributes = hero.totalAttributes();
        assertTrue(heroAttributes.getStrength() == 2 && heroAttributes.getDexterity() == 2 && heroAttributes.getIntelligence() == 9);
    }

    @Test
    public void hero_damage_no_weapon_equipment() throws InvalidWeaponException {
        Hero hero = new Mage("Gandalf");
        Weapon weapon = new Weapon("Staff", 1, WeaponType.Staffs, 1);
        hero.equipWeapon(weapon);
        double heroTotalDamage = hero.damage();
        System.out.println(heroTotalDamage);
        assertTrue(heroTotalDamage == 0.09);
    }

    @Test
    public void hero_damage_weapon_equipped(){

    }

    @Test
    public void hero_damage_replace_weapon_equipment(){

    }

    @Test
    public void hero_damage_weapon_and_armor_equipment(){

    }



}
