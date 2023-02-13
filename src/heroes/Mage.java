package heroes;

public class Mage extends Hero{


    public Mage(String name){
        super(name);
        this.setHeroAttributes(new HeroAttributes(1, 1, 8));
    }
    @Override
    public void LevelUp() {
        this.setLevel(getLevel()+1);
        this.getHeroAttributes().setDexterity(this.getHeroAttributes().getDexterity()+1);
        this.getHeroAttributes().setStrength(this.getHeroAttributes().getStrength()+1);
        this.getHeroAttributes().setIntelligence(this.getHeroAttributes().getIntelligence()+5);
    }
}
