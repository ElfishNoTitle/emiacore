package org.peace.notitle.emiacore.items;




import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.peace.notitle.emiacore.EmiaCore;

import java.util.HashSet;

public enum EmiaItemGroups {
    EMIA_BASIC_GROUP(
            "emia_basic_group",
            new ItemStack(Items.CRAFTING_TABLE)
    );

    EmiaItemGroups(String path, ItemStack icon){
        this.identifier = new Identifier(EmiaCore.NAMESPACE, path);
        this.items = new HashSet<>();
        this.icon = icon;
        this.path = path;
    }
    private final Identifier identifier;
    public final HashSet<ItemStack> items;
    private final ItemStack icon;
    private final String path;
    public Identifier getIdentifier(){
        return identifier;
    }
    public ItemStack getIcon(){
        return icon;
    }
    public String getPath(){
        return path;
    }
}
