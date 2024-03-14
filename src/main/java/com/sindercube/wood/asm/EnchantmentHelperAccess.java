package com.sindercube.wood.asm;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableFloat;

public interface EnchantmentHelperAccess {

    static float getAttackSpeed(ItemStack stack) {
        MutableFloat mutableFloat = new MutableFloat();
        EnchantmentHelper.forEachEnchantment((enchantment, level) -> mutableFloat.add(enchantment.getAttackSpeed(level)), stack);
        return mutableFloat.floatValue();
    }

}
