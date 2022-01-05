package cucumbersaurus.zabon.zabon.bank;

import cucumbersaurus.zabon.gui.GuiBase;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class BankGui extends GuiBase {

    public BankGui(@NotNull Player p) { super(p, 54, "은행"); }

    @Override
    protected void init() {

        for(int i = 0;i < 54;i++){
            setItem(" ", null , Material.LIGHT_BLUE_STAINED_GLASS_PANE,1, i,"zabon.background",false);
        }

        setItem("은행", Arrays.asList("아래 : 은행 메뉴 목록"), Material.NETHER_STAR, 1, 9+4, "zabon.bank", true);
        setItem("대출", Arrays.asList("대출 메뉴"), Material.MAP, 1, 9*3+1, "zabon.bank.loan", false);
        setItem("상환", Arrays.asList("상환 메뉴"), Material.MAP, 1, 9*3+3, "zabon.bank.repay", false);
        setItem("통장", Arrays.asList("통장 메뉴"), Material.GOLD_INGOT, 1, 9*3+5, "zabon.bank.account", false);
        setItem("내 신용등급", Arrays.asList("눌러서 신용등급 확인하기"), Material.DIAMOND, 1, 9*3+7, "zabon.bank.credit", false);
        setItem("이전으로", Arrays.asList("눌러서 이전 탭으로 이동"), Material.BARRIER, 1, 9*5+4, "zabon.bank.back", false);
    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            case "zabon.background":
                //효과없음
                break;
            case "zabon.bank":
                //호과없음
                break;
            case "zabon.bank.loan":
                //대출 창
                break;
            case "zabon.bank.repay":
                //상환 창
                break;
            case "zabon.bank.account":
                //통장 창
                break;
            case "zabon.bank.credit":
                //신용등급 확인 창
                break;
            case "zabon.bank.back":
                //이전 창으로
                break;
            default:
                break;
        }

    }
}
