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
            player.printInfo();
            System.out.println("------------------------------------------");
            System.out.println("Locations");
            System.out.println("1 Safe House");
            System.out.println("2 Tool Store");
            System.out.println("3 Enter the cave, be careful, you may encounter the zombie");
            System.out.println("4 Enter the forest, be careful, you may encounter the vampire");
            System.out.println("5 Enter the cave, be careful, you may encounter the bear");
            System.out.println("0 Log out");
            System.out.println("Please select a location !!");
            int  selectLoc=input.nextInt();

            switch (selectLoc) {
                case 0:
                    location1=null;
                    break;
                case 1:
                    location1=new SafeHouse(player);
                    break;
                case 2:
                    location1=new ToolStore(player);
                    break;
                case 3:
                    location1 =new Cave(player);
                    break;
                case 4:
                    location1=new Forest(player);
                    break;
                case 5:
                    location1=new River(player);
                    break;

                default:
                    location1=new SafeHouse(player);
            }
            if(location1==null)
            {
                System.out.println("You give up easily see you :( ");
                break;
            }
            if(!location1.onLocation())
            {
                System.out.println("GAME OVER");
                break;
            }


        }


    }
}
