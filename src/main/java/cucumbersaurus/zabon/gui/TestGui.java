package cucumbersaurus.zabon.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TestGui extends GuiBase{


    public TestGui(@NotNull Player p, int guiSize, String guiName) { super(p, 9, "gui테스트"); }

    @Override
    protected void init(@NotNull Player p) {
setItem("테스트 버튼", Arrays.asList("","일단 눌러봐"), Material.DIAMOND, 5, 0, "test", true);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            case "test":
                Bukkit.broadcastMessage("테스트 성공!");
                break;
            default:
                break;
        }
    }
}
