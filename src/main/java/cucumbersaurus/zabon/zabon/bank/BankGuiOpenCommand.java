package cucumbersaurus.zabon.zabon.bank;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BankGuiOpenCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){

            Player p = (Player) sender;
            new BankGui(p, 54, "은행");

        }
        else{
            sender.sendMessage("콘솔에서는 사용 할 수 없습니다.");
        }
        return true;
    }
}
