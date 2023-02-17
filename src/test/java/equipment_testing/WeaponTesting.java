package equipment_testing;

import equipments.Item;
import equipments.Slot;
import equipments.Weapon;
import equipments.WeaponType;
import heroes.Hero;
import heroes.Mage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeaponTesting {

    @Test
    public void check_Weapon_Initialization_values(){
        Weapon weapon = new Weapon("MrAxe", 1, WeaponType.Axes, 1);
        assertTrue(weapon.getName().equals("MrAxe") &&
                weapon.getRequiredLevel() == 1 &&
                weapon.getWeaponType() == WeaponType.Axes &&
                weapon.getWeaponDamage() == 1
        );
    }
}
