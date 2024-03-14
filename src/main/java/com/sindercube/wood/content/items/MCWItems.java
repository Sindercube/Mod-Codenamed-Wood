package com.sindercube.wood.content.items;

import com.sindercube.wood.ModCodenamedWood;
import com.sindercube.wood.content.items.custom.SickleItem;
import com.sindercube.wood.content.misc.CopperToolMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MCWItems {

    public static final Item BAMBOO_SWORD = register(
            "bamboo_sword",
            new SwordItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 3, -2.4F)))
    );

    public static final Item COPPER_SICKLE = register(
            "copper_sickle",
            // 3, -2.4F
            new SickleItem(CopperToolMaterial.INSTANCE, new Item.Settings())
    );

    public static void init() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.WOODEN_SWORD, BAMBOO_SWORD);
            entries.addAfter(Items.DIAMOND_SWORD, COPPER_SICKLE);
        });

    }

    public static Item register(String id, Item item) {
        return Registry.register(
                Registries.ITEM,
                ModCodenamedWood.of(id),
                item
        );
    }

}
