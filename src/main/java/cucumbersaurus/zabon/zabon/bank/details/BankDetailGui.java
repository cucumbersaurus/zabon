package cucumbersaurus.zabon.zabon.bank.details;

import cucumbersaurus.zabon.gui.GuiBase;
import cucumbersaurus.zabon.zabon.bank.BankGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class BankDetailGui extends GuiBase {

    public BankDetailGui(@NotNull Player p, int guiSize, String guiName) {
        super(p, guiSize, guiName);
    }
    public BankDetailGui(@NotNull Player p) {
        super(p, 54, "은행 정보");
    }

    @Override
    protected void init(@NotNull Player p) {
        for (int i = 0; i < 54; i++) {
            setItem(" ", null, Material.YELLOW_STAINED_GLASS_PANE, 1, i, "zabon.bank.details.background", false);
        }

        setItem("은행", Collections.singletonList("아래 : 은행 정보 목록"), Material.NETHER_STAR, 1, 9+4, "zabon.bank.details.", true);
        setItem("이율", Collections.singletonList("이율 : __%"), Material.IRON_HELMET, 1, 9*3+1, "zabon.bank.details.saveInterest", true);
        setItem("금리", Collections.singletonList("금리 : __%"), Material.GOLDEN_HELMET, 1, 9*3+4, "zabon.bank.details.loanInterest", true);
        setItem("신용등급 표", Collections.singletonList("눌러서 신용등급 확인하기"), Material.DIAMOND_HELMET, 1, 9*3+7, "zabon.bank.details.credit", true);
        setItem("이전 탭으로", Collections.singletonList("눌러서 이전탭으로"), Material.BARRIER, 1, 9*5+4, "zabon.bank.details.back", true);

    }

    @Override
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            case "zabon.bank.details.back":
                new BankGui(p);
                break;
            default:
                break;
        }
    }
}
