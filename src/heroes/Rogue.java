package heroes;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name);
        this.setHeroAttributes(new HeroAttributes(2, 6, 1));
    }

    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+4);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+1);

    }
}