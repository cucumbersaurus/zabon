package cucumbersaurus.zabon.joinQuitLoger;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class QuitLogger {

    private Random random;
    private final String inLavaMessage = ChatColor.YELLOW+"가 용암에 빠진 것 같습니다.";

    private int getRandom(int max){
        int rd = random.nextInt();
        rd %= max;
        rd = rd < 0 ? rd * -1 : rd;
        return rd + 1;
    }

    private void alertQuit(){
        for(Player all: Bukkit.getOnlinePlayers()){
            all.playSound(all.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
        }
    }

    private boolean IsInLava(@NotNull Player p){

        World w = p.getWorld();
        Location l = p.getLocation();

        return w.getBlockAt(l).getType() == Material.LAVA;

    }

    public void quitCucumber(@NotNull PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(IsInLava(p)){
            e.setQuitMessage(ChatColor.GREEN+"오이사우르스"+inLavaMessage);
            alertQuit();
            return;
        }
        int rd=getRandom(1);
        switch (rd){
            case 0:
                e.setQuitMessage(ChatColor.YELLOW+"위대한 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 바람과 함께 사라졌습니다.");
                break;
            default:
                break;
        }
        alertQuit();
    }

    public void quitAndesite(@NotNull PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(IsInLava(p)) {
            e.setQuitMessage(ChatColor.GOLD+"데스"+inLavaMessage);
            alertQuit();
            return;
        }
        int rd=getRandom(1);
        switch (rd){
            case 0:
                e.setQuitMessage(ChatColor.GOLD+"데스"+ChatColor.YELLOW+"가 \"데스는 데스데스\"를 시전하며 퇴장했습니다.");
                break;
            default:
                break;
        }
        alertQuit();
    }

    public void quitSeo_m(@NotNull PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(IsInLava(p)) {
            e.setQuitMessage(ChatColor.AQUA+"서엠"+inLavaMessage);
            alertQuit();
            return;
        }
        int rd=getRandom(1);
        switch (rd){
            case 0:
                e.setQuitMessage(ChatColor.YELLOW+"마이크 귀찮아서 안들고온 "+ChatColor.AQUA+"서엠"+ChatColor.YELLOW+"이 서버에서 퇴장하였습니다.");
                break;
            default:
                break;
        }

        alertQuit();
    }

    public void quitDefault(@NotNull PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(IsInLava(p)) {
            e.setQuitMessage(ChatColor.DARK_GREEN+e.getPlayer().getName()+inLavaMessage);
            alertQuit();
            return;
        }
        int rd=getRandom(1);
        switch (rd){
            case 0:
                e.setQuitMessage(ChatColor.DARK_GREEN+e.getPlayer().getName()+ChatColor.YELLOW+"(이)가 탈주했습니다!");
                break;
            default:
                break;
        }
        alertQuit();
    }

}
