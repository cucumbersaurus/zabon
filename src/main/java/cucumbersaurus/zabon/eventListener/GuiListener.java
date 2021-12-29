package cucumbersaurus.zabon.eventListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import cucumbersaurus.zabon.gui.GuiBase;

public class GuiListener implements Listener {

    @EventHandler
    public void guiClick(InventoryClickEvent e){
        GuiBase gui = GuiBase.getGUI((Player) e.getWhoClicked());
        if(gui!=null) gui.onClick(e);
    }

    @EventHandler
    public void guiClose(InventoryCloseEvent e){
        GuiBase gui = GuiBase.getGUI((Player) e.getPlayer());
        if(gui!=null) gui.closeGUI(e);
    }

}
