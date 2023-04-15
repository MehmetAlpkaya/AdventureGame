public class ToolStore extends normalLocation{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in TOOL STORE");
        return true;
    }

}
