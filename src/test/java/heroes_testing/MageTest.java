package heroes_testing;

import heroes.Hero;
import heroes.Mage;
import org.junit.Assert;
import org.junit.Test;

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


}
