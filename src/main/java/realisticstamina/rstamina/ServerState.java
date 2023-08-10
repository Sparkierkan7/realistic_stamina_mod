package realisticstamina.rstamina;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.UUID;

public class ServerState extends PersistentState {

    int testInt = 0;
    String worldVersion = "1.2.0";

    public HashMap<UUID, RStaminaPlayerState> players = new HashMap<>();

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {

        NbtCompound playersNbtCompound = new NbtCompound();
        players.forEach((UUID, playerSate) -> {
            NbtCompound playerStateNbt = new NbtCompound();

            playerStateNbt.putInt("testplayerdata", playerSate.testplayerdata);
            playerStateNbt.putDouble("stamina", playerSate.stamina);
            playerStateNbt.putDouble("maxStamina", playerSate.maxStamina);
            playerStateNbt.putDouble("totalStamina", playerSate.totalStamina);
            playerStateNbt.putDouble("energy", playerSate.energy);
            playerStateNbt.putDouble("energyFromResting", playerSate.energyFromResting);
            playerStateNbt.putBoolean("edited", playerSate.edited);
            playerStateNbt.putInt("staminaRegenCooldown", playerSate.staminaRegenCooldown);
            playerStateNbt.putDouble("staminaLossRate", playerSate.staminaLossRate);
            playerStateNbt.putDouble("staminaGainRate", playerSate.staminaGainRate);
            playerStateNbt.putDouble("energyLossRate", playerSate.energyLossRate);
            playerStateNbt.putDouble("energyGainRate", playerSate.energyGainRate);

            playersNbtCompound.put(String.valueOf(UUID), playerStateNbt);
        });
        nbt.put("players", playersNbtCompound);

        nbt.putInt("testInt", testInt);
        return nbt;
    }

    public static ServerState createFromNbt(NbtCompound tag) {

        ServerState serverState = new ServerState();

        NbtCompound playersTag = tag.getCompound("players");
        playersTag.getKeys().forEach(key -> {
            RStaminaPlayerState playerState = new RStaminaPlayerState();

            playerState.testplayerdata = playersTag.getCompound(key).getInt("testplayerdata");
            playerState.stamina = playersTag.getCompound(key).getDouble("stamina");
            playerState.maxStamina = playersTag.getCompound(key).getDouble("maxStamina");
            playerState.totalStamina = playersTag.getCompound(key).getDouble("totalStamina");
            playerState.energy = playersTag.getCompound(key).getDouble("energy");
            playerState.energyFromResting = playersTag.getCompound(key).getDouble("energyFromResting");
            playerState.edited = playersTag.getCompound(key).getBoolean("edited");
            playerState.staminaRegenCooldown = playersTag.getCompound(key).getInt("staminaRegenCooldown");
            playerState.staminaLossRate = playersTag.getCompound(key).getDouble("staminaLossRate");
            playerState.staminaGainRate = playersTag.getCompound(key).getDouble("staminaGainRate");
            playerState.energyLossRate = playersTag.getCompound(key).getDouble("energyLossRate");
            playerState.energyGainRate = playersTag.getCompound(key).getDouble("energyGainRate");

            UUID uuid = UUID.fromString(key);
            serverState.players.put(uuid, playerState);
        });

        serverState.testInt = tag.getInt("testInt");

        return serverState;
    }

    public static ServerState getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server
                .getWorld(World.OVERWORLD).getPersistentStateManager();

        ServerState serverState = persistentStateManager.getOrCreate(
                ServerState::createFromNbt,
                ServerState::new,
                RStaminaMod.modid);

        return serverState;
    }

    public static RStaminaPlayerState getPlayerState(LivingEntity player) {
        ServerState serverState = getServerState(player.getWorld().getServer());

        RStaminaPlayerState playerState = serverState.players.computeIfAbsent(player.getUuid(), uuid -> new RStaminaPlayerState());

        return playerState;
    }
}