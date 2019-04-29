public class Game {
    private ImmuneSystem immuneSystem;
    private Body mainBody;

    public static int turnNumber = 1;

    // Parameter stageID refers to type of disease in this game. Higher stageID means more difficult pathogens.
    public Game(int stageID) {
        mainBody = new Body();
        immuneSystem = new ImmuneSystem();
        switch (stageID) {
            case 0:
                mainBody.changeGlobalHP(1000000, true);
                break;
            case 1:
                mainBody.changeGlobalHP(1000000, true);
                break;
            case 2:
                mainBody.changeGlobalHP(800000, true);
                break;
            default:
                throw new IllegalArgumentException("Game ID is unknown. Terminating program.");
        }
    }

    public boolean runTurn() {
        System.out.printf("%02d:%02d:%02d", turnNumber / 3600, (turnNumber / 60) % 60, turnNumber % 60);
        turnNumber++;
        mainBody.runCombat();
        return mainBody.changeGlobalHP(-50000, true);
    }
}
