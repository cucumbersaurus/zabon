package cucumbersaurus.zabon.zabon.bank.credit;

import cucumbersaurus.zabon.gui.GuiBase;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class CreditGui extends GuiBase {
    public CreditGui(@NotNull Player p, int guiSize, String guiName) {
        super(p, guiSize, guiName);
    }
    public CreditGui(@NotNull Player p) {
        super(p, 54, "시용등급");
    }

    @Override
    protected void init(@NotNull Player p) {
        for(int i = 0;i < 54;i++){
            setItem(" ", null , Material.ORANGE_STAINED_GLASS_PANE,1, i,"zabon.bank.credit.background",false);
        }
        setItem("신용등급 1등급", null, Material.RED_CANDLE, 1, 9+2, "zabon.bank.credit.1", false);
        setItem("신용등급 2등급", null, Material.ORANGE_CANDLE, 1, 9+3, "zabon.bank.credit.2", false);
        setItem("신용등급 3등급", null, Material.YELLOW_CANDLE, 1, 9+4, "zabon.bank.credit.3", false);
        setItem("신용등급 4등급", null, Material.LIME_CANDLE, 1, 9+5, "zabon.bank.credit.4", false);
        setItem("신용등급 5등급", null, Material.LIGHT_BLUE_CANDLE, 1, 9+6, "zabon.bank.credit.5", false);
        setItem("내 신용등금", Collections.singletonList("내 신용등급이 아래에 나타납니다."), Material.DIAMOND, 1, 9*3+4, "zabon.bank.credit.show", false);
        setItem("임의 등급 값", null, Material.GRAY_CANDLE, 1, 9*4+4, "zabon.bank.credit.show.me", false);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;
    }
}
