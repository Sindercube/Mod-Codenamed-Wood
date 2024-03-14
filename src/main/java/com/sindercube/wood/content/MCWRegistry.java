package com.sindercube.wood.content;

import com.sindercube.wood.ModCodenamedWood;
import com.sindercube.wood.content.components.MCWComponents;
import com.sindercube.wood.content.components.custom.TrainingWeaponComponent;
import com.sindercube.wood.content.enchantments.MCWEnchantments;
import com.sindercube.wood.content.items.MCWItems;
import net.minecraft.component.DataComponentType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import java.util.function.UnaryOperator;

public class MCWRegistry {

    public static final TagKey<Item> TRAINING_WEAPONS = TagKey.of(RegistryKeys.ITEM, ModCodenamedWood.of("training_weapons"));

    public static void init() {

        MCWEnchantments.init();
        MCWItems.init();
        MCWComponents.init();

    }

}
