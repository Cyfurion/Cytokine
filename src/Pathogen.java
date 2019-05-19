public abstract class Pathogen {
    private int health, maxHealth, damage, recharge;
    private double accuracy;
    private String type;

    public Pathogen(int health, int maxHealth, int damage, int recharge, double accuracy, String type) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.recharge = recharge;
        this.accuracy = accuracy;
        this.type = type;
    }

    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getDamage() { return damage; }
    public int getAttackSpeed() { return recharge; }
    public double getAccuracy() { return accuracy; }
    public String getType() { return type; }

    public void changeHealth(double delta, boolean flat) {
        if (flat) {
            health += delta;
        } else {
            health *= (1 + delta);
        }
        if (health < 0) {
            health = 0;
        } else if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void changeMaxHealth(double delta, boolean flat) {
        if (flat) {
            maxHealth += delta;
        } else {
            maxHealth *= (1 + delta);
        }
        if (maxHealth < 0) { maxHealth = 0; }
        if (delta > 0) { changeHealth(delta, flat); }
        changeHealth(0, false);
    }

    public void changeDamage(double delta, boolean flat) {
        if (flat) {
            damage += delta;
        } else {
            damage *= (1 + delta);
        }
        if (damage < 0) { damage = 0; }
    }

    public void changeRecharge(double delta, boolean flat) {
        if (flat) {
            recharge += delta;
        } else {
            recharge *= (1 + delta);
        }
        if (recharge < 0) { recharge = 0; }
    }

    public void changeAccuracy(double delta){
        accuracy += delta;
        if (accuracy < 0) { accuracy = 0; }
    }


}
