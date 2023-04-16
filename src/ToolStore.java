public class ToolStore extends normalLocation{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in TOOL STORE");
        System.out.println("1 - Weapon");
        System.out.println("2 - Armory");
        System.out.println("3 - Log out");
        System.out.println("Select case");
        int selectCase = Location.input.nextInt();
        while (selectCase <1 || selectCase>3)
        {
            System.out.println("invalide value");
            selectCase=input.nextInt();
        }
        switch (selectCase)
        {
            case 1:
                printWeapon();
                break;

            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("See you :)");
                break;
        }

        return true;
    }
    public void printWeapon()
    {
        System.out.println("----------weapons----------------");
        for(Weapon w: Weapon.weapons())
        {
            System.out.println(w.getName() + " price "+w.getDamage()+" damage ");
        }
    }
    public void printArmor()
    {

        System.out.println("Armors");
    }
}
