package me.randomgamingdev.randomgamingorigins;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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

    @Override
    public void run() {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            PlayerData playerData = Origins.playersData.get(player.getUniqueId());
            switch (playerData.origin) {
                case Blazeborn:
                    if (player.getFireTicks() > 0)
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 1, true, false));
                    if (player.isInWater())
                        player.damage(1);
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
                    break;
                case Elytrian:
                    TickDown(player, playerData);
                    if (player.isGliding())
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 1, true, false));
                    break;
            }
        }
    }
}
