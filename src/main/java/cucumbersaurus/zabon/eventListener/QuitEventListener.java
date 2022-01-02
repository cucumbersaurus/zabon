package cucumbersaurus.zabon.eventListener;

import cucumbersaurus.zabon.joinQuitLoger.QuitLogger;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEventListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        String playerName;
        playerName=e.getPlayer().getName();
        QuitLogger ql =new QuitLogger();

        switch (playerName){
            case "Cucumbersaurus":
                ql.quitCucumber(e);
                break;
            case "Seo_M":
                ql.quitSeo_m(e);
                break;
            case "andesite7":
               ql.quitAndesite(e);
                break;
            default:
                ql.quitDefault(e);
                break;
        }
    }
}
