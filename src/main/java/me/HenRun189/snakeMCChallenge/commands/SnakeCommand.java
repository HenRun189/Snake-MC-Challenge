package me.HenRun189.snakeMCChallenge.commands;

import me.HenRun189.snakeMCChallenge.game.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SnakeCommand implements CommandExecutor {

    private final GameManager gameManager;

    public SnakeCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Nutzung: /snake <start|stop|pause|resume>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "start":
                if (gameManager.start()) {
                    sender.sendMessage(ChatColor.GREEN + "Challenge gestartet!");
                } else {
                    sender.sendMessage(ChatColor.RED + "Die Challenge läuft bereits.");
                }
                break;

            case "stop":
                if (gameManager.stop()) {
                    sender.sendMessage(ChatColor.GREEN + "Challenge gestoppt.");
                } else {
                    sender.sendMessage(ChatColor.RED + "Es läuft keine Challenge.");
                }
                break;

            case "pause":
                if (gameManager.pause()) {
                    sender.sendMessage(ChatColor.GREEN + "Challenge pausiert.");
                } else {
                    sender.sendMessage(ChatColor.RED + "Kann nicht pausiert werden (nicht aktiv).");
                }
                break;

            case "resume":
                if (gameManager.resume()) {
                    sender.sendMessage(ChatColor.GREEN + "Challenge fortgesetzt.");
                } else {
                    sender.sendMessage(ChatColor.RED + "Kann nicht fortgesetzt werden (nicht pausiert).");
                }
                break;

            default:
                sender.sendMessage(ChatColor.RED + "Unbekannter Befehl. Nutzung: /snake <start|stop|pause|resume>");
        }
        return true;
    }
}