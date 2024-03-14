package com.sindercube.wood.content.enchantments.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class AttackSpeedEnchantment extends Enchantment {

    public AttackSpeedEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, ItemTags.WEAPON_ENCHANTABLE, slotTypes);
    }

    public float getAttackSpeed(int level) {
        return level * 0.15F;
    }

    public int getMaxLevel() {
        return 5;
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 50;
    }

}
