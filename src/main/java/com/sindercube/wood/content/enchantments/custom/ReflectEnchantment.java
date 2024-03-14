package com.sindercube.wood.content.enchantments.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class ReflectEnchantment extends Enchantment {

    public ReflectEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, ItemTags.WEAPON_ENCHANTABLE, slotTypes);
    }

}
