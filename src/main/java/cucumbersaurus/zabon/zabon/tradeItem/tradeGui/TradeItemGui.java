package cucumbersaurus.zabon.zabon.tradeItem.tradeGui;

import cucumbersaurus.zabon.gui.GuiBase;
import cucumbersaurus.zabon.zabon.tradeItem.TradeItemList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TradeItemGui extends GuiBase {

    private static final HashMap<Player, Integer> onPage = new HashMap<>();

    public TradeItemGui(@NotNull Player p) { super(p, 54, "거래 가능한 아이템 목록"); }

    @Override
    protected void init(Player p) {

        onPage.putIfAbsent(p, 0);
        int page = onPage.get(p);

        for(int i=0;i<9;i++){
            setItem(" ",null,  Material.RED_STAINED_GLASS_PANE, 1, i, "zabon.tradeItem.background", false);
        }
        for(int i=45;i<54;i++){
            setItem(" ",null,  Material.RED_STAINED_GLASS_PANE, 1, i, "zabon.tradeItem.background", false);
        }
        for(int i=9;i<45;i+=9){
            setItem(" ",null,  Material.RED_STAINED_GLASS_PANE, 1, i, "zabon.tradeItem.background", false);
        }
        for(int i=8;i<45;i+=9){
            setItem(" ",null,  Material.RED_STAINED_GLASS_PANE, 1, i, "zabon.tradeItem.background", false);
        }

        setItem("장식 (만지지 마시오)", Collections.singletonList("아니 만지지 말라니까"), Material.CLOCK, 1, 4, "zabon.tradeItem.easterEgg", false);
        setItem("현재 페이지/새로고침",Arrays.asList("현재 페이지를 나타냅니다.", "눌러서 새로고침"),  Material.YELLOW_STAINED_GLASS_PANE, page+1, 9*5+4, "zabon.tradeItem.reload", false);

        int lastPage =TradeItemList.itemList.size()/24;
        if(lastPage==0){
            //아무것도 생성 하지 않기
        }
        else if(page==0){
            makeButtonNext();
        }
        else if(page==lastPage){
            makeButtonPrevious();
        }
        else{
            makeButtonNext();
            makeButtonPrevious();
        }

        for(int i = page*28; i < TradeItemList.itemList.size()&&i<(page+1)*28; i++){
            int pn = i%28;
            int col = pn/7;
            int row = pn%7;

            setItem(TradeItemList.getItem(i).getItem(), 9*(col+1) + row+1, "zabon.tradeItem.buyItem."+ i);
        }
    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(btn==null) return;

        switch (btn){
            case "zabon.tradeItem.easterEgg":
                ItemStack item = new ItemStack(Material.FLOWER_BANNER_PATTERN);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("경고장 (만지지 좀 말라고)");
                item.setItemMeta(meta);
                p.getInventory().addItem(item);
                break;
            case "zabon.tradeItem.nextPage":
                onPage.put(p,onPage.get(p)+1);
                //super.forceCloseGUI(p);
                new TradeItemGui(p);
                //this.init(p);
                break;
            case "zabon.tradeItem.previous":
                onPage.put(p,onPage.get(p)-1);
                //super.forceCloseGUI(p);
                new TradeItemGui(p);
                //this.init(p);
                break;
            case "zabon.tradeItem.reload":
                new TradeItemGui(p);
                break;
            default:
                break;
        }

    }

    private void makeButtonNext(){
        setItem("다음 탭으로", Arrays.asList("눌러서 다음 아이템 목록 확인하기"), Material.FEATHER, 1, 9*5+7, "zabon.tradeItem.nextPage", false);
    }

    private void makeButtonPrevious(){
        setItem("이전 탭으로", Arrays.asList("눌러서 이전 탭으로 이동하기"), Material.BARRIER, 1, 9*5+1, "zabon.tradeItem.previous", false);
    }

}
