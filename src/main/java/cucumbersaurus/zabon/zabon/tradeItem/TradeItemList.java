package cucumbersaurus.zabon.zabon.tradeItem;

import com.google.gson.Gson;
import cucumbersaurus.zabon.Zabon;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

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

    public static void makeFile(){
        if(!f.exists() || !f.isFile()){
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void ListToFile() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    FileWriter writer = new FileWriter(f, false);
                    for (TradeableItem i : TradeItemList.itemList) {
                        String jsonStr = getJson(i);
                        writer.write(jsonStr + "\n");
                    }
                    writer.flush();
                    getLogger().info("데이터 저장");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 20 * 10, 20 * 10);
    }

    private static String getJson(TradeableItem item){
        Gson gson = new Gson();
        String jsonStr = gson.toJson(item.serialize());
        //Bukkit.broadcastMessage(jsonStr);
        return jsonStr;
    }

    public static void FileToList(){
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String fileLine;
            while ((fileLine = reader.readLine())!=null){
                Map map = gson.fromJson(fileLine, Map.class);
                Bukkit.broadcastMessage(map.toString());
                TradeableItem item = TradeableItem.deSerialize(map);
                //ItemStack item = ItemStack.deserialize(map);
                //List<String> lore = item.getLore();
                //double price = Double.parseDouble(lore.get(0).substring(5).split("데")[0]);
                //String uploadTime = lore.get(1).split(":")[1].substring(1);
                //String lastingTime = lore.get(2).split(":")[1].substring(1);
                //String playerName = lore.get(3).split(":")[1].substring(1);

                //TradeableItem tradeableItem = new TradeableItem(item, 0, "null", "null", "null");
                itemList.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
