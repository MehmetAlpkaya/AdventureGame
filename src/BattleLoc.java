import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{

    private Obstacle obstacle; // BattleLoc have a obstacle
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player, String name, Obstacle obstacle, String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }
    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacle();
        System.out.println("you are in "+this.getName() );
        System.out.println("Be careful, " + obsNumber+" " +getObstacle().getName()+" live on the "+getName());
        System.out.println("<F>ight or <R>un");
        String select  =input.nextLine();
        select=select.toUpperCase();
        if(select.equals("F"))
        {
            System.out.println("savaşş");
        }

        return true;
    }

    public int randomObstacle()
    {
        Random r=new Random();

        return r.nextInt(this.getMaxObstacle())+1;
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

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
