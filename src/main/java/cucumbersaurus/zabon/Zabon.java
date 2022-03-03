package cucumbersaurus.zabon;

import cucumbersaurus.zabon.commands.GetPlayerLocation;
import cucumbersaurus.zabon.commands.GuiCommands;
import cucumbersaurus.zabon.commands.Wasans;
import cucumbersaurus.zabon.commands.effectmenu.EffectCommands;
import cucumbersaurus.zabon.commands.fileTest.FileTest;
import cucumbersaurus.zabon.commands.fileTest.FileTestCommand;
import cucumbersaurus.zabon.eventListener.GuiListener;
import cucumbersaurus.zabon.eventListener.JoinEventListener;
import cucumbersaurus.zabon.eventListener.QuitEventListener;
import cucumbersaurus.zabon.zabon.ZabonGuiOpenCommand;
import cucumbersaurus.zabon.zabon.bank.BankGuiOpenCommand;
import cucumbersaurus.zabon.zabon.tradeItem.TradeItemList;
import cucumbersaurus.zabon.zabon.tradeItem.addTradeIttem.AddTradeItemGuiCommand;
import cucumbersaurus.zabon.zabon.tradeItem.tradeGui.TradeGuiCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Zabon extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("plugin loading");

        getCommands();
        registerEvents();
        //loadFile();
        TradeItemList.makeFile();
        TradeItemList.FileToList();
        TradeItemList.setPlugin(this);
        TradeItemList.ListToFile();

        getLogger().info("plugin enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //saveFile();
        getLogger().info("plugin disabled");
    }

    private void getCommands(){
        Objects.requireNonNull(getCommand("wasans")).setExecutor(new Wasans());
        Objects.requireNonNull(getCommand("guitest")).setExecutor(new GuiCommands());
        Objects.requireNonNull(getCommand("playerlocation")).setExecutor(new GetPlayerLocation());
        Objects.requireNonNull(getCommand("effectmenu")).setExecutor(new EffectCommands());
        Objects.requireNonNull(getCommand("zabon")).setExecutor(new ZabonGuiOpenCommand());
        Objects.requireNonNull(getCommand("bank")).setExecutor(new BankGuiOpenCommand());
        Objects.requireNonNull(getCommand("add")).setExecutor(new FileTestCommand());
        Objects.requireNonNull(getCommand("trade")).setExecutor(new TradeGuiCommand());
        Objects.requireNonNull(getCommand("additem")).setExecutor(new AddTradeItemGuiCommand());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new JoinEventListener(), this);
        getServer().getPluginManager().registerEvents(new QuitEventListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
    }

    private void loadFile(){
        FileTest.setPlugin(this);
        FileTest.makeFile(FileTest.f);
        FileTest.mapToFile(FileTest.f, FileTestCommand.map);

    }

    private void saveFile(){
        FileTest.fileToMap(FileTest.f, FileTestCommand.map);
    }

}
