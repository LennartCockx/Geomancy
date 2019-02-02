package me.cockx.geomancermod;

import me.cockx.geomancermod.items.GlueBallItem;
import me.cockx.geomancermod.items.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEM_LIST = new ArrayList<>();

    public static final Item MUSH = new ItemBase("mush");
    public static final Item GLUEBALL = new GlueBallItem("glueball");
    public static final Item CHARRED_MUSH = new ItemBase("charredmush");

}
