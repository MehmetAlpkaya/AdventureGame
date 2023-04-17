public class ToolStore extends normalLocation{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in TOOL STORE");
        boolean onShow=true;

        while (onShow){
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
                buyWeapon();
                break;

            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("See you :)");
                onShow=false;
                break;
        }


    }
        return true;
    }
    public void printWeapon()
    {
        System.out.println("----------weapons----------------");
        for(Weapon w: Weapon.weapons())
        {
            System.out.println("< "+w.getId()+
                    w.getName() + " price "+
                    w.getPrice()+" damage "+
                    w.getDamage()+" > ");
        }
        System.out.println("For back enter - 0");


    }

    public void buyWeapon()
    {
        System.out.println("Select a weapon :");
        int selectWeaponId =input.nextInt();

        while (selectWeaponId<0 ||selectWeaponId>Weapon.weapons().length)
        {
            System.out.println("Enter valid value :");
            selectWeaponId=input.nextInt();
        }

        if(selectWeaponId != 0)
        {
            Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponId);

            if (selectedWeapon != null)
            {
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney())
                    System.out.println("You have insufficient balance");
                else{
                    int balance= getPlayer().getMoney()-selectedWeapon.getPrice();
                    System.out.println("You got "+selectedWeapon.getName()+ "");
                    this.getPlayer().setMoney(balance);
                    System.out.println("you have "+getPlayer().getMoney()+" money");
                    System.out.println("first Weapon :"+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("last weapon :"+this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }


    }
    public void printArmor()
    {
        System.out.println("----------Armors----------------");
        for(Armor w: Armor.armors())
        {
            System.out.println("< "+w.getId()+" "+
                    w.getName() + " price "+
                    w.getPrice()+" block "+
                    w.getBlock()+" > ");
        }
        System.out.println("Armors");
    }
    public void buyArmor()
    {
        System.out.println(" Select a armor");
        int selectArmorId=input.nextInt();
        while (selectArmorId<1|| selectArmorId>Armor.armors().length)
        {
            System.out.println("Please select a valid id");
            selectArmorId= input.nextInt();
        }

        Armor selectArmor=Armor.getArmorObjById(selectArmorId);

        if (selectArmor != null)
        {
            if(selectArmor.getPrice()>this.getPlayer().getMoney())
                System.out.println("You have insufficient balance");
            else{
                int balance= getPlayer().getMoney()-selectArmor.getPrice();
                System.out.println("You got "+selectArmor.getName()+ "");
                this.getPlayer().setMoney(balance);
                System.out.println("you have "+getPlayer().getMoney()+" money");

                this.getPlayer().getInventory().setArmor(selectArmor);
                System.out.println("last Armor :"+this.getPlayer().getInventory().getArmor().getName());
            }
        }

    }
}
