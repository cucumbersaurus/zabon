package cucumbersaurus.zabon;

import cucumbersaurus.zabon.commands.GetPlayerLocation;
import cucumbersaurus.zabon.commands.GuiCommands;
import cucumbersaurus.zabon.commands.Wasans;
import cucumbersaurus.zabon.commands.effectmenu.EffectCommands;
import cucumbersaurus.zabon.eventListener.GuiListener;
import cucumbersaurus.zabon.eventListener.QuitEventListener;
import cucumbersaurus.zabon.zabon.ZabonGuiOpenCommand;
import cucumbersaurus.zabon.zabon.bank.BankGuiOpenCommand;
import org.bukkit.plugin.java.JavaPlugin;
import cucumbersaurus.zabon.eventListener.JoinEventListener;

public final class Zabon extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommands();
        registerEvents();
        getLogger().info("start");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("end");
    }

    private void getCommands(){
        getCommand("wasans").setExecutor(new Wasans());
        getCommand("guitest").setExecutor(new GuiCommands());
        getCommand("playerlocation").setExecutor(new GetPlayerLocation());
        getCommand("effectmenu").setExecutor(new EffectCommands());
        getCommand("zabon").setExecutor(new ZabonGuiOpenCommand());
        getCommand("bank").setExecutor(new BankGuiOpenCommand());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new QuitEventListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
    }

}
