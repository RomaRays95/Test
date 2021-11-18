public class MageSub extends Hero{
    private int mana;
    private int manaRegen;
    private int skillUpHealth;

    public MageSub(String name, String name2) {
        super(name, name2);
        mana = 10 + rand.nextInt(15);
        manaRegen = 23 + rand.nextInt(3);
        skillUpHealth = 25;
    }

    @Override
    public int attack() {
        mana += manaRegen;
        return super.attack();
    }

    @Override
    public void upLvl() {
        manaRegen += 3;
        skillUpHealth += 4;
        super.upLvl();
    }

    @Override
    public void upHealth(int i) {
        health += i;
        if (health > healthMax) health = healthMax;
        Main.logs.append(String.format("HP самого себя, теперь у него %d HP>", health));
    }

    @Override
    public int getMana() {
        return mana;
    }

    private int heal(){
        mana -= 25 + (super.getLvl() * 3);
        Main.logs.append(String.format("<%s лечит на %d ", super.getName(), skillUpHealth));
        return skillUpHealth;
    }

    private void skillUpLvl (){
        mana -= 30 + (super.getLvl() * 2);
        Main.logs.append(String.format("<%s поднимает уровень ", super.getName()));
    }
}