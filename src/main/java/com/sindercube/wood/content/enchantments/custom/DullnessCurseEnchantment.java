package com.sindercube.wood.content.enchantments.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class DullnessCurseEnchantment extends Enchantment {

    public DullnessCurseEnchantment(Enchantment.Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, ItemTags.WEAPON_ENCHANTABLE, slotTypes);
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 50;
    }

    public boolean isTreasure() {
        return true;
    }

    public boolean isCursed() {
        return true;
    }

}
