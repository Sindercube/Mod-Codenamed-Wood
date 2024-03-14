package com.sindercube.wood.content.enchantments.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class SlowAttackCurseEnchantment extends Enchantment {

    public SlowAttackCurseEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, ItemTags.WEAPON_ENCHANTABLE, slotTypes);
    }

    public float getAttackSpeed(int level) {
        return -0.6F * level;
    }

    public float getAttackDamage(int level, EntityType<?> e) {
        return 6F * level;
    }

    public boolean isTreasure() {
        return true;
    }

    public boolean isCursed() {
        return true;
    }

}
