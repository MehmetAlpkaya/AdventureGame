import java.util.Scanner;

public class Game
{
    private Scanner input=new Scanner(System.in);

    public void start()
    {
        System.out.println("Welcome to ADVENTURE GAME !!");
        System.out.println("Please enter a name !!");
        String name=input.next();
        System.out.println("Please enter a location");
        String location=input.next();
        Player player=new Player(name);
        System.out.println("Hello "+player.getName()+" welcome to game");
        System.out.println("Please select a character :");
        player.selectCharacter();

        Location location1=null;
        while (true)
        {
            System.out.println("------------------------------------------");
            System.out.println("Locations");
            System.out.println("1 Safe House");
            System.out.println("2 Tool Store");
            System.out.println("Please select a location !!");
            int  selectLoc=input.nextInt();

            switch (selectLoc) {
                case 1:
                    location1=new SafeHouse(player);
                    break;
                case 2:
                    location1=new ToolStore(player);
                    break;
                default:
                    location1=new SafeHouse(player);
            }
            if(!location1.onLocation())
            {
                System.out.println("GAME OVER");
                break;
            }
        }


    }
}
