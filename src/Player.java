import java.util.Scanner;

public class Player
{
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input=new Scanner(System.in);

    public Player(String name)
    {
        this.name=name;
    }

    public void selectCharacter()
    {
        gameCharacter[] gameChar={new Samurai(),new Archer(),new Knight()};


        System.out.println("################################");
        for(gameCharacter x: gameChar)
        {
            System.out.println("Id :"+x.getId()+
                    "\t\t Character :"+x.getName()+
                    "\t\t Health"+x.getHealth()+
                    "\t\t Damage :"+ x.getDamage()+
                    "\t\t Para :"+x.getMoney());
        }
        System.out.println("--------------------------------");
        System.out.println("Bir karekter seçiniz");
        int selectChar=input.nextInt();

        switch (selectChar)
        {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Knight());
                break;
            case 3:
                initPlayer(new Archer());
                break;
            default:
                initPlayer(new Samurai());

        }
    }

    public void initPlayer(gameCharacter gameChar)
    {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
