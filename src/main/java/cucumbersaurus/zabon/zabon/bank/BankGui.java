package cucumbersaurus.zabon.zabon.bank;

import cucumbersaurus.zabon.gui.GuiBase;
import cucumbersaurus.zabon.zabon.bank.credit.CreditGui;
import cucumbersaurus.zabon.zabon.bank.details.BankDetailGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;

public class BankGui extends GuiBase {

    public BankGui(@NotNull Player p) { super(p, 54, "은행"); }

    @Override
    protected void init(@NotNull Player p) {

        for(int i = 0;i < 54;i++){
            setItem(" ", null , Material.LIGHT_BLUE_STAINED_GLASS_PANE,1, i,"zabon.background",false);
        }

        setItem("은행", Arrays.asList("아래 : 은행 메뉴 목록", "또는 눌러서 자세한 은행 정보"), Material.NETHER_STAR, 1, 9+4, "zabon.bank", true);
        setItem("대출", Collections.singletonList("대출 메뉴"), Material.WRITABLE_BOOK, 1, 9*3+1, "zabon.bank.loan", false);
        setItem("저축", Collections.singletonList("예금 메뉴"), Material.EMERALD, 1, 9*3+3, "zabon.bank.save", false);
        setItem("통장", Collections.singletonList("통장 메뉴"), Material.GOLD_INGOT, 1, 9*3+5, "zabon.bank.account", false);
        setItem("내 신용등급", Collections.singletonList("눌러서 신용등급 확인하기"), Material.DIAMOND, 1, 9*3+7, "zabon.bank.credit", false);
        setItem("이전으로", Collections.singletonList("눌러서 이전 탭으로 이동"), Material.BARRIER, 1, 9*5+4, "zabon.bank.back", false);
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
                new BankDetailGui(p);
                break;
            case "zabon.bank.loan":
                //대출 창
                break;
            case "zabon.bank.save":
                //저축 창
                break;
            case "zabon.bank.account":
                //통장 창
                break;
            case "zabon.bank.credit":
                //신용등급 확인 창
                new CreditGui(p);
                break;
            case "zabon.bank.back":
                //이전 창으로
                break;
            default:
                break;
        }

    }
}
