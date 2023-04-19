public abstract class BattleLoc extends Location{

    private Obstacle obstacle; // BattleLoc have a obstacle
    private String award;
    public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
    }
    @Override
    public boolean onLocation() {
        System.out.println("you are in "+this.getName() );
        System.out.println("Be careful");

        return true;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
