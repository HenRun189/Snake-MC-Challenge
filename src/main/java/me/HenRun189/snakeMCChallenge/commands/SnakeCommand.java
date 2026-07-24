package me.HenRun189.snakeMCChallenge.commands;

import me.HenRun189.snakeMCChallenge.game.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SnakeCommand implements CommandExecutor {

    private final GameManager gameManager;

    public SnakeCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Nutzung: /snake <start|stop|pause|resume|join|leave>");
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

            case "join":
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.RED + "Nur Spieler können beitreten.");
                    break;
                }
                if (gameManager.join((Player) sender)) {
                    sender.sendMessage(ChatColor.GREEN + "Du bist der Challenge beigetreten.");
                } else {
                    sender.sendMessage(ChatColor.RED + "Beitritt nicht möglich (läuft bereits oder bereits beigetreten).");
                }
                break;

            case "leave":
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.RED + "Nur Spieler können verlassen.");
                    break;
                }
                if (gameManager.leave((Player) sender)) {
                    sender.sendMessage(ChatColor.GREEN + "Du hast die Challenge verlassen.");
                } else {
                    sender.sendMessage(ChatColor.RED + "Du warst nicht Teil der Challenge.");
                }
                break;

            default:
                sender.sendMessage(ChatColor.RED + "Unbekannter Befehl. Nutzung: /snake <start|stop|pause|resume|join|leave>");
        }
        return true;
    }
}