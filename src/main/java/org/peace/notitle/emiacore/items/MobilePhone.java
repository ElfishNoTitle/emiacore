package org.peace.notitle.emiacore.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.peace.notitle.emiacore.client.screen.MobilePhoneScreen;

public class MobilePhone extends EmiaItem{
    public MobilePhone(Settings settings) {
        super(settings);
    }
    @Override
    public void setConfig() {
        this.PATH = "emia_mobilephone";
        this.GROUP = EmiaItemGroups.EMIA_BASIC_GROUP;
        this.setKept();
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        if (!world.isClient) return TypedActionResult.success(playerEntity.getStackInHand(hand));


        ClientPlayerEntity user = (ClientPlayerEntity) playerEntity;

        MinecraftClient.getInstance().setScreen(new MobilePhoneScreen());

        user.playSound(EmiaSounds.EMIA_OPEN_MOBILEPHONE.sound, 1F, 1F);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }


}
