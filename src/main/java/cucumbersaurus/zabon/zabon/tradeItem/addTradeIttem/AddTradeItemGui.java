package cucumbersaurus.zabon.zabon.tradeItem.addTradeIttem;

import cucumbersaurus.zabon.gui.GuiBase;
import cucumbersaurus.zabon.zabon.tradeItem.TradeItemList;
import cucumbersaurus.zabon.zabon.tradeItem.TradeableItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class AddTradeItemGui extends GuiBase{

    public static final HashMap<Player, Boolean> isWaitingAddItem = new HashMap<>();
    public AddTradeItemGui(@NotNull Player p, int guiSize, String guiName) { super(p, guiSize, guiName); }
    public AddTradeItemGui(@NotNull Player p) { super(p, 54, "거래 가능한 이이템 추가하기"); }
    private final ItemStack item = new ItemStack(Material.STRUCTURE_VOID);
    protected final TradeableItem tradeableItem = new TradeableItem(item, 0, "null", "null", "null");
    protected boolean isUploaded = false;

    @Override
    protected void init(@NotNull Player p) {

        for(int i = 0;i < 54;i++){
            setItem(" ", null ,Material.WHITE_STAINED_GLASS_PANE,1, i,"zabon.tradeItem.addItem.background",false);
        }

        setItem("아이템 등록", Collections.singletonList("눌러서 인벤토리의 아이템 선택하기"), Material.GLOW_ITEM_FRAME, 1, 9+4, "zabon.tradeItem.addItem.setItem", false);
        setItem("등록된 아이템", Collections.singletonList("없음"), Material.STRUCTURE_VOID, 1, 9*3+4, "zabon.tradeItem.addItem.showSelected", false);
        setItem("-10 데스", Collections.singletonList("눌러서 아이템 판매가격 조정하기"), Material.RED_WOOL, 1, 9*4+2, "zabon.tradeItem.addItem.subtractPrice_10", false);
        setItem("-1 데스", Collections.singletonList("눌러서 아이템 판매가격 조정하기"), Material.RED_CARPET, 1, 9*4+3, "zabon.tradeItem.addItem.subtractPrice_1", false);
        setItem("아이템 거래소에 등록하기", Collections.singletonList("눌러서 바로 등록하기"), Material.ANVIL, 1, 9*4+4, "zabon.tradeItem.addItem.confirm", true);
        setItem("+1 데스", Collections.singletonList("눌러서 아이템 판매가격 조정하기"), Material.GREEN_CARPET, 1, 9*4+5, "zabon.tradeItem.addItem.addPrice_1", false);
        setItem("+10 데스", Collections.singletonList("눌러서 아이템 판매가격 조정하기"), Material.GREEN_WOOL, 1, 9*4+6, "zabon.tradeItem.addItem.addPrice_10", false);

    }

    @Override
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        String btn = getValue(e.getRawSlot());

        if(Objects.equals(e.getClickedInventory(), p.getInventory())){
            if(isWaitingAddItem.get(p)&&isWaitingAddItem.get(p)!=null){

                if(e.getCurrentItem()==null){
                    return;
                }
                alertYes(p);
                this.tradeableItem.setItem(Objects.requireNonNull(e.getCurrentItem()).clone());
                this.tradeableItem.setPlayerName(p.getName());
                e.getCurrentItem().subtract(e.getCurrentItem().getAmount());

                updateItem();
                AddTradeItemGui.isWaitingAddItem.put(p,false);
                isUploaded = true;
            }
        }

        if(btn==null) return;

        switch (btn){
            case "zabon.tradeItem.addItem.setItem":
                if(GuiBase.getGUI(p) instanceof AddTradeItemGui){
                    alertYes(p);
                    AddTradeItemGui.isWaitingAddItem.put(p, true);
                }
            case "zabon.tradeItem.addItem.showSelected":
                //선택한 아이템 보여주는 칸, 효과 없음
                break;
            case "zabon.tradeItem.addItem.subtractPrice_10":
                //아이템 가격 -10
                if(!isUploaded){
                    alertNo(p);
                    p.sendMessage(ChatColor.RED+"아이템을 먼저 선택 해 주세요!");
                    break;
                }
                if(!tradeableItem.setItemPrice(tradeableItem.getItemPrice()-10)){
                    p.sendMessage(ChatColor.RED+"가격은 0보다 작을 수 없습니다.");
                    alertNo(p);
                    break;
                }
                updateItem();
                alertYes(p);
                break;
            case "zabon.tradeItem.addItem.subtractPrice_1":
                //아이템 가격 -1
                if(!isUploaded){
                    alertNo(p);
                    p.sendMessage(ChatColor.RED+"아이템을 먼저 선택 해 주세요!");
                    break;
                }
                if(!tradeableItem.setItemPrice(tradeableItem.getItemPrice()-1)){
                    p.sendMessage(ChatColor.RED+"가격은 0보다 작을 수 없습니다.");
                    alertNo(p);
                    break;
                }
                updateItem();
                alertYes(p);
                break;
            case "zabon.tradeItem.addItem.addPrice_1":
                //아이템 가격 +1
                if(!isUploaded){
                    alertNo(p);
                    p.sendMessage(ChatColor.RED+"아이템을 먼저 선택 해 주세요!");
                    break;
                }
                if(!tradeableItem.setItemPrice(tradeableItem.getItemPrice()+1)){
                    p.sendMessage(ChatColor.RED+"가격은 0보다 작을 수 없습니다.");
                    alertNo(p);
                    break;
                }
                updateItem();
                alertYes(p);
                break;
            case "zabon.tradeItem.addItem.addPrice_10":
                //아이템 가격 +10
                if(!isUploaded){
                    alertNo(p);
                    p.sendMessage(ChatColor.RED+"아이템을 먼저 선택 해 주세요!");
                    break;
                }
                if(!tradeableItem.setItemPrice(tradeableItem.getItemPrice()+10)){
                    p.sendMessage(ChatColor.RED+"가격은 0보다 작을 수 없습니다.");
                    alertNo(p);
                    break;
                }
                updateItem();
                alertYes(p);
                break;
            case "zabon.tradeItem.addItem.confirm":
                //아이템 리스트에 아이템 등록
                tradeableItem.setUploadTime(getTime());
                if(isUploaded) TradeItemList.addItem(tradeableItem.clone());
                else{
                    alertNo(p);
                    p.sendMessage(ChatColor.RED+"아이템을 먼저 선택 해 주세요!");
                    break;
                }
                isUploaded = false;
                p.sendMessage(ChatColor.GREEN+"아이템 등록 성공!");
                alert(p, Sound.BLOCK_ANVIL_USE);
                tradeableItem.reset();
                resetItem();
                //new ConfirmAddItemGui(p, this.tradeableItem);
            default:
                break;
        }
    }

    @Override
    public void closeGUI(@NotNull InventoryCloseEvent e) {
        slotMap = null;
        guiMap.remove((Player) e.getPlayer());
        isWaitingAddItem.remove(e.getPlayer());
    }

    protected void alertYes(@NotNull Player p){
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
    }

    protected void alertNo(@NotNull Player p){
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
    }

    protected void alert(@NotNull Player p, Sound sound){
        p.playSound(p.getLocation(), sound, 1, 1);
    }

    protected void updateItem(){
        setItem(this.tradeableItem.getItem(),9*3+4, "zabon.tradeItem.addItem.showSelected");
    }

    protected void resetItem(){
        setItem("등록된 아이템", Arrays.asList("없음"), Material.STRUCTURE_VOID, 1, 9*3+4, "zabon.tradeItem.addItem.showSelected", false);
    }

    protected String getTime(){
        LocalDateTime now = LocalDateTime.now();

        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        return year+"년 "+monthValue+"월 "+dayOfMonth+"일 "+hour+"시 "+minute+"분 "+second+"초";

    }
}
