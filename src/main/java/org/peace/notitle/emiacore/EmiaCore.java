package org.peace.notitle.emiacore;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.peace.notitle.emiacore.items.EmiaItemGroups;
import org.peace.notitle.emiacore.items.EmiaItems;
import org.peace.notitle.emiacore.items.EmiaSounds;

public class EmiaCore implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String NAMESPACE = "emiacore";
    @Override
    public void onInitialize() {


        LOGGER.info("EmiaCore is running.");
        for (EmiaSounds sound : EmiaSounds.values()){
            sound.sound = SoundEvent.of(sound.identifier);
            Registry.register(Registries.SOUND_EVENT, sound.identifier, sound.sound);
        }

        for (EmiaItems item : EmiaItems.values()){
            Registry.register(Registries.ITEM, item.getIdentifier(), item.getInstance());
            item.getGroup().items.add(new ItemStack(item.getInstance()));
        }


        for (EmiaItemGroups group : EmiaItemGroups.values()){
            RegistryKey<ItemGroup> ITEM_GROUP;

            Registry.register(Registries.ITEM_GROUP,ITEM_GROUP =  RegistryKey.of(RegistryKeys.ITEM_GROUP, group.getIdentifier()), FabricItemGroup.builder()
                    .icon(group::getIcon)
                    .displayName(Text.translatable("itemgroup." + NAMESPACE + "." + group.getPath()))

                    .build()
            );

            ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content ->{
                content.addAll(group.items);
            });
        }


    }
}
