package me.HenRun189.snakeMCChallenge.game;

import com.mojang.brigadier.Command;
import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.entity.LookAnchor;
import io.papermc.paper.entity.TeleportFlag;
import io.papermc.paper.threadedregions.scheduler.EntityScheduler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.util.TriState;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.*;
import org.bukkit.Location;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

//import javax.xml.stream.Location;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static me.HenRun189.snakeMCChallenge.config.GameConfig.*;

public class SnakePart {
    Location loc;
    int blockIndex;

    SnakePart(Location pLoc, int pBlockIndex) {
        loc = pLoc;
        blockIndex = pBlockIndex;
    }

    void displaySnake() {
        ItemFrame frame = world.<ItemFrame>spawn(loc, ItemFrame.class);

        ItemStack item =  new ItemStack(snakeMaterial[blockIndex], 1);
        frame.setItem(item);

        frame.setVisible(false);

        frame.setInvulnerable(true);

        frame.setFixed(true);
    }

    double squareDistance(Player p) {
        return p.getLocation().distanceSquared(loc);
    }

}
