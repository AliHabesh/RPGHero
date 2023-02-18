# RPGHeroes


## Description
This is a console application in Java that allows players to create heroes, equip them with items and level them up. The application allows the player to select from four classes; Mage, Ranger, Rogue, and Warrior. Each class has unique attributes, and the player can equip the hero with specific items such as armor and weapons that will enhance their abilities.



# Heroes

## Each hero has the following fields:
* Level - all heroes start at level 1
* LevelAttributes - total from all levels
* Equipment - holds currently equipped items
* ValidWeaponTypes - a list of weapon types a hero can equip based on their subclass
*  ValidArmorTypes - a list of armor types a hero can equip based on their subclass

## Heroes have the following public facing methods:
* Constructor - each hero is created by passing just a name.
* LevelUp - increases the level of a character by 1 and increases their LevelAttributes
* Equip - two variants, for equipping armor and weapons
* Damage - damage is calculated on the fly and not stored
* TotalAttributes - calculated on the fly and not stored
* Display - details of Hero to be displayed

# Test

## Unit tests
JUnit tests were written for all major classes and methods using the JUnit testing framework. These tests verify that individual units of code are working as expected.

## Continuous Integration (CI)
Code changes are frequently tested and integrated into the main codebase to detect and fix issues early on in the development process. In the case of RPGHeroes, CI tests would be used to automate the process of testing the codebase every time a change is made to the repository on GitHub.




