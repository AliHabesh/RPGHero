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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
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
}
