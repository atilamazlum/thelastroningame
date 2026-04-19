public class PlayerState {
    public int hp;
    public int money;
    public String weapon;
    public int vikingHp;
    public int wizardHp;
    public boolean hasSilverRing;

    public PlayerState() {
        reset();
    }

    public void reset() {
        hp = 15;
        money = 10000;
        weapon = "KNIFE";
        vikingHp = 30;
        wizardHp = 90;
        hasSilverRing = false;
    }
}
