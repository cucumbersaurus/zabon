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

import java.util.Objects;

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
        Objects.requireNonNull(getCommand("wasans")).setExecutor(new Wasans());
        Objects.requireNonNull(getCommand("guitest")).setExecutor(new GuiCommands());
        Objects.requireNonNull(getCommand("playerlocation")).setExecutor(new GetPlayerLocation());
        Objects.requireNonNull(getCommand("effectmenu")).setExecutor(new EffectCommands());
        Objects.requireNonNull(getCommand("zabon")).setExecutor(new ZabonGuiOpenCommand());
        Objects.requireNonNull(getCommand("bank")).setExecutor(new BankGuiOpenCommand());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new QuitEventListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
    }

}
