package org.peace.notitle.emiacore.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.peace.notitle.emiacore.EmiaCore;

public enum EmiaItems {
    EMIA_MOBILEPHONE(
            new MobilePhone(
                    new FabricItemSettings().
                    maxCount(1)));

    EmiaItems(EmiaItem instance){
        this.instance = instance;
        this.identifier = new Identifier(EmiaCore.NAMESPACE, instance.PATH);
        this.group = instance.GROUP;


    }
    private final Item instance;
    private final Identifier identifier;
    private final EmiaItemGroups group;
    public Item getInstance() {
        return this.instance;
    }
    public Identifier getIdentifier(){
        return identifier;
    }
    public EmiaItemGroups getGroup(){
        return group;
    }
}
