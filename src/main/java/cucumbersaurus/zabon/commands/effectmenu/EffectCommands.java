package cucumbersaurus.zabon.commands.effectmenu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EffectCommands implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){

            Player p = (Player) sender;
            new EffectGui(p, 27, "이펙트 창");
            return true;

        }
        else{
            sender.sendMessage("콘솔에서는 사용 할 수 없습니다.");
            return true;
        }
    }
}
