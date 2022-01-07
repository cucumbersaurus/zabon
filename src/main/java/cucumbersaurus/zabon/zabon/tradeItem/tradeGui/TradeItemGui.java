package cucumbersaurus.zabon.zabon.tradeItem.tradeGui;

import cucumbersaurus.zabon.gui.GuiBase;
import cucumbersaurus.zabon.zabon.tradeItem.TradeItemList;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class TradeItemGui extends GuiBase {

    public TradeItemGui(@NotNull Player p) { super(p, 54, "거래 가능한 아이템 목록"); }

    @Override
    protected void init() {

        for(int i = 0; i < TradeItemList.itemList.size()&&i<45; i++){
            setItem(TradeItemList.getItem(i).getItem(), i, "zabon.tradeItem.buyItem."+ i);
        }
    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            default:
                break;
        }

    }


}
