package cucumbersaurus.zabon.commands;

import cucumbersaurus.zabon.gui.TestGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GuiCommands implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){

            Player p = (Player) sender;
            new TestGui(p, 9, "테스트");

        }
        else{
            sender.sendMessage("콘솔에서는 사용 할 수 없습니다.");
            return true;
        }
        return false;
    }
}
