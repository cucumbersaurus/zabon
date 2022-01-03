package cucumbersaurus.zabon.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetPlayerLocation implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args){

        Player p = (Player) sender;

        if(args.length!=0) {Player getP = Bukkit.getPlayer(args[0]);
            if(getP!=null){
                p=getP;
            }
        }

        Location playerLocation = p.getLocation();

        String playerLocationWorld = playerLocation.getWorld().toString();
        int playerLocationX = (int)playerLocation.getX();
        int playerLocationY = (int)playerLocation.getY();
        int playerLocationZ = (int)playerLocation.getZ();

        if(playerLocationWorld.contains("=world}")){
            playerLocationWorld="오버월드";
        }
        else if(playerLocationWorld.contains("=world_nether}")){
            playerLocationWorld="네더";
        }
        else if(playerLocationWorld.contains("=world_the_end}")){
            playerLocationWorld="엔드";
        }

        Bukkit.broadcastMessage(p.getName()+"(은)는 "+playerLocationWorld+"의 x="+playerLocationX+", y="+playerLocationY+", z="+playerLocationZ+"에 있습니다.");


        return true;

    }

}
