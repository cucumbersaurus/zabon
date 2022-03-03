package cucumbersaurus.zabon.zabon.tradeItem;

import com.google.gson.Gson;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TradeableItem {

    private double itemPrice;
    private String uploadTime;
    private String lastingTime;
    private String playerName;
    private ItemStack item;


    public TradeableItem(ItemStack item, double itemPrice, String tradeTime, String UploadTime, String playerName) {
        this.itemPrice = itemPrice;
        this.uploadTime = tradeTime;
        this.lastingTime = UploadTime;
        this.item = item;
        this.playerName = playerName;
    }

    public TradeableItem() {
        this.itemPrice = 0;
        this.uploadTime = "null";
        this.lastingTime = "null";
        this.item = new ItemStack(Material.AIR);
        this.playerName = "null";
    }


    public double getItemPrice() {
        return itemPrice;
    }

    public boolean setItemPrice(double itemPrice) {
        if(itemPrice<0){
            return false;
        }
        else{
        this.itemPrice = itemPrice;
            return true;
        }
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getLastingTime() {
        return lastingTime;
    }

    public void setLastingTime(String lastingTime) {
        this.lastingTime = lastingTime;
    }

    public ItemStack getTradeableItem(){
        ItemStack itemStack = this.item.clone();
        ItemMeta itemMeta = itemStack.getItemMeta().clone();

        String itemPrice = String.valueOf(this.itemPrice);
        String uploadTime = String.valueOf(this.uploadTime);
        String lastingTime = String.valueOf(this.lastingTime);
        itemMeta.setLore(Arrays.asList("가격 : "+itemPrice+"데스", "아이템 업로드 시간 : "+uploadTime, "거래 만료시각 : "+lastingTime, "업로더 : "+this.playerName));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getItem(){

        ItemStack itemStack = new ItemStack(Material.AIR);
        itemStack.setType(this.item.getType());
        itemStack.setAmount(this.item.getAmount());
        itemStack.setData(this.item.getData());
        itemStack.setDurability(this.item.getDurability());

        itemStack.setItemMeta(this.item.getItemMeta().clone());

        return itemStack;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void reset(){
        this.itemPrice = 0;
        this.uploadTime = "null";
        this.lastingTime = "null";
        this.playerName = "";
        this.item =  new ItemStack(Material.STRUCTURE_VOID);
    }

    public TradeableItem clone(){
        TradeableItem tradeableItem = new TradeableItem();
        tradeableItem.setItem(this.getItem());
        tradeableItem.setItemPrice(this.itemPrice);
        tradeableItem.setUploadTime(this.uploadTime);
        tradeableItem.setPlayerName(this.playerName);

        return  tradeableItem;
    }

    public Map<String, Object> serialize(){
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("itemPrice", itemPrice);
        map.put("uploadTime", uploadTime);
        map.put("lastingTime", lastingTime);
        map.put("playerName", playerName);
        //Map<String, Object> item = this.item.serialize();
        //item.put("ItemMeta", this.item.getItemMeta().serialize());

        //map.put("item", gson.toJson(item));
        map.put("item", item.serialize());

        // Bukkit.broadcastMessage(item.serialize().toString());

        return map;
    }

    public static TradeableItem deSerialize(Map<String, Object> map){
        TradeableItem item = new TradeableItem();
        Gson gson = new Gson();
        map.forEach((key, value) -> {
            switch (key) {
                case "itemPrice":
                    item.setItemPrice((Double) value);
                    break;
                case "uploadTime":
                    item.setUploadTime((String) value);
                    break;
                case "lastingTime":
                    item.setLastingTime((String) value);
                    break;
                case "playerName":
                    item.setPlayerName((String) value);
                    break;
                case "item":
                    //Map itemMap = gson.fromJson(value.toString(), Map.class);
                    //item.setItem(ItemStack.deserialize((itemMap)));
                    item.setItem(ItemStack.deserialize((Map<String, Object>) value));
                    break;
                default:
                    break;
            }
        });

        return item;
    }
}
