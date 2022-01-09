package cucumbersaurus.zabon.commands.effectmenu;

import cucumbersaurus.zabon.gui.GuiBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class EffectGui extends GuiBase {

    public EffectGui(@NotNull Player p, int guiSize, String guiName) { super(p, 27, "이펙트 선택"); }

    @Override
    protected void init(@NotNull Player p) {
        setItem("번개 소환", Arrays.asList("현재 위치에 번개 효과를 소환합니다."), Material.BLAZE_ROD, 1, 9+2, "Lightning", false);
        setItem("화염 소환", Arrays.asList("현재 위치에 화염 입자를 소환합니다"), Material.BLAZE_POWDER, 1, 9+6, "Flame", false);
    }

    @Override
    public void onClick(@NotNull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            case "Lightning":
                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                p.sendMessage("번개 소환!");
                break;
            case "Flame":
                p.getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 170, 1.5, 1.5, 1.5);

                for(Player all : Bukkit.getOnlinePlayers()){
                    all.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 0.6f, 1);
                }

                p.sendMessage("화염 소환!");
                break;
            default:
                break;
        }
    }

}
