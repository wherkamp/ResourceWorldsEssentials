package me.kingtux.resourceworldsessentials;

import me.kingtux.enumconfig.BukkitYamlHandler;
import me.kingtux.enumconfig.EnumConfigLoader;
import me.kingtux.resourceworlds.ResourceWorld;
import me.kingtux.resourceworlds.ResourceWorlds;
import net.essentialsx.api.v2.events.WarpModifyEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ResourceWorldsEssentials extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        BukkitYamlHandler yamlHandler = new BukkitYamlHandler(new File(getDataFolder(), "lang.yml"));
        EnumConfigLoader.loadLang(yamlHandler, Locale.class, true);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void onWarpModify(WarpModifyEvent e) {
        if (e.getCause() == WarpModifyEvent.WarpModifyCause.CREATE) {
            for (ResourceWorld resourceWorld : ResourceWorlds.getInstance().getResourceWorlds()) {
                if (resourceWorld.getPropertiesSection().getName().equals(e.getNewLocation().getWorld().getName())) {
                    e.getUser().sendMessage(Locale.BAD_WARP_PLACEMENT.color());
                    e.setCancelled(true);
                }
            }
        }
    }
}
