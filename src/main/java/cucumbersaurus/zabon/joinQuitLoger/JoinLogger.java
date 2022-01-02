package cucumbersaurus.zabon.joinQuitLoger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class JoinLogger {

    private final Random random = new Random();

    private int getRandom(int max){
        int rd = random.nextInt();
        rd %= 5;
        rd = rd < 0 ? rd * -1 : rd;
        return rd + 1;
    }

    private  void alertJoin(){
        for(Player all: Bukkit.getOnlinePlayers()){
            all.playSound(all.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
        }
    }

    public void joinCucumber(@NotNull PlayerJoinEvent e){
        int rd=getRandom(5);

        switch (rd){
            case 1:
                e.setJoinMessage(ChatColor.YELLOW+"위대한 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 서버에 등장했습니다!");
                break;
            case 2:
                e.setJoinMessage(ChatColor.YELLOW+"짜짠! "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 나타났어요!");
                break;
            case 3:
                e.setJoinMessage(ChatColor.YELLOW+"화석에서 깨어난 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 출현했습니다!");
                break;
            case 4:
                e.setJoinMessage(ChatColor.YELLOW+"편집 안하는 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"가 몰래 서버에 들어오려다 실패했습니다!");
                break;
            case 5:
                e.setJoinMessage(ChatColor.YELLOW+"오늘도 "+ChatColor.GREEN+"오이사우르스"+ChatColor.YELLOW+"는 서버에 들어왔습니다");
                break;
            default:
                break;
        }
        alertJoin();
    }

    public void joinAndesite(@NotNull PlayerJoinEvent e){
        int rd=getRandom(3);

        switch (rd) {
            case 1:
                e.setJoinMessage(ChatColor.GOLD + "데스" + ChatColor.YELLOW + "가 \"데스는 데스데스\"를 시전하기 위해 서버에 등장했습니다.");
                break;
            case 2:
                e.setJoinMessage((ChatColor.YELLOW + "그래픽카드가 세 자리수인 " + ChatColor.GOLD + "데스" + ChatColor.YELLOW + "는 불만을 표하며 서버에 들어왔습니다."));
                break;
            case 3:
                e.setJoinMessage(ChatColor.YELLOW + "평화롭게 건축이나 하고싶은 " + ChatColor.GOLD + "데스" + ChatColor.YELLOW + "가 건축대회 개최를 주장하기 위해 서버에 나타났습니다.");
                break;
            default:
                break;
        }
        alertJoin();
    }

    public void joinSeo_m(@NotNull PlayerJoinEvent e){
        e.setJoinMessage(ChatColor.YELLOW+"마이크 귀찮아서 안들고온 "+ChatColor.AQUA+"서엠"+ChatColor.YELLOW+"이 나타났습니다.");
        alertJoin();
    }

     public void joinDefault(@NotNull PlayerJoinEvent e){
         e.setJoinMessage(ChatColor.YELLOW+"훌륭한 노동력인 "+ChatColor.DARK_GREEN+e.getPlayer().getName()+ChatColor.YELLOW+"(이)가 서버에 등장했습니다!");
         alertJoin();
    }
}