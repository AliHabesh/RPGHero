package equipment_testing;

import equipments.*;
import heroes.HeroAttributes;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArmorTest {

    @Test
    public void check_Armor_Initialization_Values(){
        Armor armor = new Armor("Steel", 1, Slot.Body, ArmorType.Plate, new HeroAttributes(1, 1, 1));
        assertTrue(armor.getName().equals("Steel") &&
                armor.getRequiredLevel() == 1 &&
                armor.getSlot() == Slot.Body &&
                armor.getArmorType() == ArmorType.Plate
        );
    }
}
