package com.karlofduty.personalviewdistance;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class PersonalViewDistance extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        this.getCommand("viewdistance").setExecutor(new ViewDistanceCommand());
    }

    @Override
    public void onDisable()
    {
        // Nothing for now
    }

    public class ViewDistanceCommand implements CommandExecutor {

        // This method is called, when somebody uses our command
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
        {
            if(!(sender instanceof Player))
            {
                sender.sendMessage("§CCannot use this command as console.");
                return false;
            }

            if(!sender.hasPermission("viewdistance"))
            {
                sender.sendMessage("§CYou do not have permission to do that.");
                return true;
            }

            if(args.length < 1)
            {
                sender.sendMessage("§CInvalid arguments.");
                return false;
            }

            if(!StringUtils.isNumeric(args[0]))
            {
                sender.sendMessage("§CArgument is not an integer.");
                return false;
            }

            int range = Integer.valueOf(args[0]);
            if(range < 1 || range > 16)
            {
                sender.sendMessage("§CArgument cannot be lower than 1 or higher than 16.");
                return false;
            }

            Player player = (Player)sender;
            player.setViewDistance(range);
            sender.sendMessage("§AYour view distance has been set to " + args[0]);
            return true;
        }
    }
}
