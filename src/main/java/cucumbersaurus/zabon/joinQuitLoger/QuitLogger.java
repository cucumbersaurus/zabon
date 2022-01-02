package cucumbersaurus.zabon.joinQuitLoger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

public class QuitLogger {

    private Random random;

    private int getRandom(int max){
        int rd = random.nextInt();
        rd %= 5;
        rd = rd < 0 ? rd * -1 : rd;
        return rd + 1;
    }

    private  void alertQuit(){
        for(Player all: Bukkit.getOnlinePlayers()){
            all.playSound(all.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
        }
    }

    public void quitCucumber(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.YELLOW+"위대한 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 바람과 함께 사라졌습니다.");
        alertQuit();
    }

    public void quitAndesite(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.GOLD+"데스"+ChatColor.YELLOW+"가 \"데스는 데스데스\"를 시전하며 퇴장했습니다.");
        alertQuit();
    }

    public void quitSeo_m(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.YELLOW+"마이크 귀찮아서 안들고온 "+ChatColor.AQUA+"서엠"+ChatColor.YELLOW+"이 서버에서 퇴장하였습니다.");
        alertQuit();
    }

    public void quitDefault(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.DARK_GREEN+e.getPlayer().getName()+ChatColor.YELLOW+"(이)가 탈주했습니다!");

        alertQuit();
    }

}
