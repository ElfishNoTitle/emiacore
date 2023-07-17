package org.peace.notitle.emiacore.items;

import net.minecraft.item.Item;

import java.util.HashSet;
import java.util.Objects;

public abstract class EmiaItem extends Item{
    public static HashSet<Item> beKeptItems = new HashSet<>();
    public String PATH = null;
    public EmiaItemGroups GROUP = null;
    public EmiaItem(Settings settings) {
        super(settings);
        setConfig();
    }
    public abstract void setConfig();
    public final void setKept(){
        beKeptItems.add(this);
    }

    @Override
    public int hashCode(){
        return Objects.hash(PATH);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass().getSuperclass() != EmiaItem.class){
            return false;
        }
        return this.PATH.equals(((EmiaItem) obj).PATH);
    }
}
