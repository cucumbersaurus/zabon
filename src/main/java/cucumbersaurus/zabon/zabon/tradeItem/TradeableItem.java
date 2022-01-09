package cucumbersaurus.zabon.zabon.tradeItem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

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

    public ItemStack getItem(){
        ItemStack itemStack = this.item;
        ItemMeta itemMeta = itemStack.getItemMeta();

        String itemPrice = String.valueOf(this.itemPrice);
        String uploadTime = String.valueOf(this.uploadTime);
        String lastingTime = String.valueOf(this.lastingTime);
        itemMeta.setLore(Arrays.asList("가격 : "+itemPrice+"데스", "아이템 업로드 시간 : "+uploadTime, "거래 만료시각 : "+lastingTime, "업로더 : "+this.playerName));

        itemStack.setItemMeta(itemMeta);
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
        TradeableItem tradeableItem = new TradeableItem(new ItemStack(Material.STRUCTURE_VOID), 0, "null", "null", "null");
        tradeableItem.setItem(this.getItem());
        tradeableItem.setItemPrice(this.itemPrice);
        tradeableItem.setUploadTime(this.uploadTime);
        tradeableItem.setPlayerName(this.playerName);

        return  tradeableItem;
    }
}
