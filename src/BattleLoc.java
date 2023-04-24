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
            if(combat(obsNumber))
            {
                System.out.println(this.getName()+" you defeated all the enemies");
                return true;
            }

        }
        if (select.equals("R"))
        {}

        return true;
    }
    public boolean combat(int obsNumber)
    {
        for (int i=1; i<=obsNumber;i++)
        {
            playerStatus();
            obstacleStatus();
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0)
            {
                System.out.println("<F> ight or <R>un");
                String s=input.nextLine().toUpperCase();
                if(s.equals("F"))
                {
                    System.out.println("you hit the monster!! ");

                    obstacle.setHealth(this.obstacle.getHealth()-this.getPlayer().totalDamage());
                    afterHit();


                    if(this.getObstacle().getHealth()>0)
                    {
                        int obsDamage=getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();
                        if(obsDamage<=0)
                        {
                            obsDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obsDamage);
                        afterHit();
                    }
                    else System.out.println("Obstacle Deadh");
                }
            }
        }
        return true;
    }
    public void afterHit()
    {
        System.out.println("After hit obstacle health:"+this.getObstacle().getHealth());
        System.out.println("After hit player health:"+this.getPlayer().getHealth());

    }
    public void playerStatus()
    {
        System.out.println("Player Status");
        System.out.println("-----------------------");
        System.out.println("Health :"+this.getPlayer().getHealth());
        System.out.println("Weapon :"+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor :"+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block :"+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage :"+this.getPlayer().totalDamage());
        System.out.println("Money :"+this.getPlayer().getMoney());



    }
    public void  obstacleStatus()
    {
        System.out.println(this.obstacle.getName()+" Status");
        System.out.println("----------------------------------");
        System.out.println("Obstacle Health :"+ this.getObstacle().getHealth());
        System.out.println("Obstacle Damage :"+  this.getObstacle().getDamage());
        System.out.println("Obstacle Aword  :"+ this.getObstacle().getAward());
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
