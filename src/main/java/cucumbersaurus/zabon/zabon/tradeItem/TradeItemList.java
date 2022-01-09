package cucumbersaurus.zabon.zabon.tradeItem;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class TradeItemList {

    public static ArrayList<TradeableItem> itemList = new ArrayList<>(10);

    public static void addItem(TradeableItem item){
        itemList.add(item);
    }
    public  static void addItem(ItemStack item, double itemPrice, String tradeTime, String lastingTime, String playerName){
        TradeableItem tradeableItem = new TradeableItem(item, itemPrice, tradeTime, lastingTime, playerName);
        itemList.add(tradeableItem);
    }

    public static TradeableItem getItem(int index){
        return itemList.get(index);
    }


}
