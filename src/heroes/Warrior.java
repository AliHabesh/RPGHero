package heroes;

public class Warrior extends Hero{


    public Warrior(String name) {
        super(name);
        this.setHeroAttributes(new HeroAttributes(5, 2, 1));
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+2);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+3);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+1);
    }
}
