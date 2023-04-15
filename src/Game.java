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


    }
}
