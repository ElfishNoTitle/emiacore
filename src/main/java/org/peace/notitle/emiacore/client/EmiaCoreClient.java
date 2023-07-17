package org.peace.notitle.emiacore.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;
import org.peace.notitle.emiacore.EmiaCore;

public class EmiaCoreClient implements ClientModInitializer {
    public static boolean isRegistered = false;
    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_WORLD_TICK.register(c -> {
            if (isRegistered) return;
            MinecraftClient client = MinecraftClient.getInstance();
            EmiaCore.LOGGER.info("EMIA CORE 客户端开始工作辣！");
            if (client.player != null) {
                EmiaCore.LOGGER.info("请求人: " + client.player.getName());
            }
            isRegistered = true;
        });



    }
}
