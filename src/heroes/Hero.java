package heroes;

/**
 * Abstract class which is the foundation class for all the heroes
 */
public abstract class Hero {
    private String name;
    private int level;
    private HeroAttributes heroAttributes;


    public Hero(String name){
        this.name = name;
    }

    public abstract void LevelUp();

    
}
