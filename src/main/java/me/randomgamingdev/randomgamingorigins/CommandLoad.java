package me.randomgamingdev.randomgamingorigins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLoad implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String saveFileName;

        if (args.length == 0)
            saveFileName = Origins.saveFileName;
        else
            saveFileName = args[0];

        boolean successfulLoad = Origins.Load(Origins.saveFileName);

        if (!(sender instanceof Player))
            return true;

        String loadState;

        if (successfulLoad)
            loadState = String.format("RandomGamingOrigins: Loaded successfully from %s!", saveFileName);
        else
            loadState = String.format("RandomGamingOrigins: Something went wrong while loading from %s!", saveFileName);

        ((Player)sender).sendMessage(loadState);
        return true;
    }
}