package cucumbersaurus.zabon.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class Wasans implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage("와! 샌즈! 아시는구나!");
            ItemStack sansBone = new ItemStack(Material.BONE);

            ItemMeta sansBoneItemMeta= sansBone.getItemMeta();
            sansBoneItemMeta.setDisplayName("와! 샌즈!");
            sansBoneItemMeta.setLore(Arrays.asList("그냥 샌즈의 뼈다."));
            sansBone.setItemMeta(sansBoneItemMeta);

            Inventory playerInventory = player.getInventory();
            playerInventory.addItem(sansBone);
            return true;
        }
        return false;
    }
}