package me.kingtux.resourceworldsessentials;

import me.kingtux.enumconfig.EnumConfig;
import me.kingtux.enumconfig.annotations.ConfigEntry;
import me.kingtux.enumconfig.annotations.ConfigValue;
import org.apache.commons.text.StringSubstitutor;
import org.bukkit.ChatColor;

import java.util.Map;

public enum Locale implements EnumConfig {
    /**
     * Valid Params: permission
     */
    @ConfigEntry
    BAD_WARP_PLACEMENT("You can not place a warp there");
    @ConfigValue
    private String value;
    Locale(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String color() {
        return ChatColor.translateAlternateColorCodes('&', getValue());
    }

    public String colorAndSubstitute(Map<String, String> values) {
        return ChatColor.translateAlternateColorCodes('&', getValueAndSubstitute(values));
    }

    private String getValueAndSubstitute(Map<String, String> values) {
        return StringSubstitutor.replace(getValue(), values);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
