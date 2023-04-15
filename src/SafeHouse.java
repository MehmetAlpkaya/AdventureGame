public class SafeHouse extends normalLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in SAFE HOUSE !!");
        System.out.println("you are full of life");
        return true;
    }
}
