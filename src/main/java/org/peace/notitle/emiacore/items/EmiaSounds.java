package org.peace.notitle.emiacore.items;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public enum EmiaSounds {
    EMIA_OPEN_MOBILEPHONE("emiacore:emia_open_mobilephone"),
    EMIA_CLOSE_MOBILEPHONE("emiacore:emia_close_mobilephone"),
    EMIA_OPEN_INVENTORY("emiacore:emia_open_inventory"),
    EMIA_CLOSE_INVENTORY("emiacore:emia_close_inventory")
    ;

    public SoundEvent sound;
    public final Identifier identifier;
    EmiaSounds(String id){
        this.identifier = new Identifier(id);
    }
}
