package cucumbersaurus.zabon.commands.fileTest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class FileTestCommand implements CommandExecutor {

    public static HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            UUID uuid = p.getUniqueId();

            if(map.containsKey(uuid)){
                map.put(uuid, map.get(uuid) + 1);
            }
            else{
                map.put(uuid, 1);
            }
            p.sendMessage(map.get(uuid).toString()+"번째 테스트");
        }
        else{
            sender.sendMessage("콘솔에서는 사용 할 수 없습니다.");
        }

        return true;
    }
}
