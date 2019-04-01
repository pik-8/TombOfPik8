package model.effects;

public enum Condition {
    POISON, SLEEP;

    private Effect effect;

    public Effect getEffect () {
        return this.effect;
    }

    private Condition () {
        switch (this.name()) {
            case "POISON":
                this.effect = new Effect("Poison", 4) {
                    @Override
                    public void applyEffect() {
                        //TODO implement an effect.
                        System.out.println("POISON!!!11!!");
                    }
                };
                break;
            case "SLEEP":
                this.effect = new Effect("Sleep", 4) {
                    @Override
                    public void applyEffect() {
                        //TODO implement an effect.
                    }
                };
                break;

        }
    }
}
