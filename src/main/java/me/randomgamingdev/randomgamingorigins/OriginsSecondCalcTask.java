package me.randomgamingdev.randomgamingorigins;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class OriginsSecondCalcTask extends BukkitRunnable {
    private final RandomGamingOrigins plugin;

    OriginsSecondCalcTask(RandomGamingOrigins plugin) {
        this.plugin = plugin;
    }

    public void TickDown(Player player, PlayerData playerData) {
        if (playerData.abilityTimer <= 0)
            return;

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(
            String.format("%ds before you can use your ability again", playerData.abilityTimer)));
        playerData.abilityTimer--;
    }

    public void RainDamage(Player player, double damage) {
        if (player.getInventory().getHelmet() != null)
            return;
        World world = player.getWorld();
        if (!world.hasStorm() && !world.isThundering())
            return;
        Location location = player.getLocation();
        double temperature = location.getBlock().getTemperature();
        if (temperature < 0.15 || temperature > 0.95)
            return;
        int blockLocation = world.getHighestBlockYAt(location);
        if (blockLocation <= player.getLocation().getY())
            player.damage(damage);
    }

    @Override
    public void run() {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            PlayerData playerData = Origins.playersData.get(player.getUniqueId());
            switch (playerData.origin) {
                case Blazeborn:
                    if (player.getFireTicks() > 0)
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(4);
                    else
                        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
                    if (player.isInWater())
                        player.damage(2);

                    RainDamage(player, 1);
                    break;
                case Merling:
                    if (player.getRemainingAir() <= 0)
                        player.damage(1);
                    break;
                case Fox:
                    TickDown(player, playerData);
                    break;
                case Enderian:
                    TickDown(player, playerData);
                    if (player.isInWater())
                        player.damage(1);
                    RainDamage(player, 1);
                    break;
                case Elytrian:
                    TickDown(player, playerData);
                    break;
                case Phantom:
                    if (player.hasPotionEffect(PotionEffectType.INVISIBILITY))
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20, 0, true, false));
                    break;
            }
        }
    }
}
