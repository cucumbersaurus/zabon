package cucumbersaurus.zabon.eventListener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEventListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        String playerName;
        playerName=e.getPlayer().getName();

        switch (playerName){
            case "Cucumbersaurus":
                e.setQuitMessage(ChatColor.YELLOW+"위대한 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 바람과 함께 사라졌습니다.");
                break;
            case "Seo_M":
                e.setQuitMessage(ChatColor.YELLOW+"마이크 귀찮아서 안들고온 "+ChatColor.AQUA+"서엠"+ChatColor.YELLOW+"이 서버에서 퇴장하였습니다.");
                break;
            case "andesite7":
                e.setQuitMessage(ChatColor.GOLD+"데스"+ChatColor.YELLOW+"가 \"데스는 데스데스\"를 시전하며 퇴장했습니다.");
                break;
            default:
                e.setQuitMessage(ChatColor.DARK_GREEN+e.getPlayer().getName()+ChatColor.YELLOW+"(이)가 탈주했습니다!");
                break;
        }
    }
}
