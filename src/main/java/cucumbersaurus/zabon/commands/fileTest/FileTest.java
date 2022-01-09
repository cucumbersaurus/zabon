package cucumbersaurus.zabon.commands.fileTest;


import cucumbersaurus.zabon.Zabon;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;

public class FileTest {

    public static File f = new File("G:/minecraft/servers/pltest/plugins/data.txt");
    public static Zabon plugin;

    public static void setPlugin(Zabon MainPlugin){
        plugin = MainPlugin;
    }

    public static void makeFile(File f){
        if(!f.exists() || !f.isFile()){
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void mapToFile(File f, HashMap<UUID, Integer> map){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                try {
                    FileWriter writer = new FileWriter(f,false);
                    for (UUID uuid : map.keySet()) {
                        writer.write(uuid.toString() + "=" + map.get(uuid)+"\n");
                        getLogger().info(uuid.toString());

                    }
                    writer.flush();
                    getLogger().info("데이터 저장");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0,20*300);
    }

    public static void fileToMap(File f, HashMap<UUID, Integer> map){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String fileLine = null;
            while ((fileLine = reader.readLine())!=null){

                UUID uuid = UUID.fromString(fileLine.split("=")[0]);
                String str = fileLine.split("=")[1];

                map.put(uuid, Integer.parseInt(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
