package cucumbersaurus.zabon.eventListener;

import cucumbersaurus.zabon.joinQuitLoger.JoinLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        String playerName;
        playerName=e.getPlayer().getName();
        JoinLogger jl = new JoinLogger();

        switch (playerName){
            case "Cucumbersaurus":
                jl.joinCucumber(e);
                break;
            case "Seo_M":
                jl.joinSeo_m(e);
                break;
            case "andesite7":
                jl.joinAndesite(e);
                break;
            default:
                jl.joinDefault(e);
                break;
        }
    }


}
