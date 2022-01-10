package cucumbersaurus.zabon.zabon.tradeItem;

import cucumbersaurus.zabon.Zabon;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.bukkit.Bukkit.getLogger;

public class TradeItemList {

    public static ArrayList<TradeableItem> itemList = new ArrayList<>(10);
    public static File f = new File("G:/minecraft/servers/pltest/plugins/list_data.txt");
    public static Zabon plugin;

    public static void setPlugin(Zabon MainPlugin){
        plugin = MainPlugin;
    }

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

    public static void ListToFile() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    FileWriter writer = new FileWriter(f, false);
                    for (TradeableItem i : TradeItemList.itemList) {
                        writer.write(i.getItem().toString() + "\n");
                    }
                    writer.flush();
                    getLogger().info("데이터 저장");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 20 * 300, 20 * 300);
    }
}
