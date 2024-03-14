package com.sindercube.wood.asm;

import com.sindercube.wood.content.MCWRegistry;
import com.sindercube.wood.content.components.MCWComponents;
import com.sindercube.wood.content.enchantments.MCWEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public interface ItemStackAccess {

    @SuppressWarnings("RedundantIfStatement")
    default boolean isTrainingWeapon() {
        ItemStack stack = (ItemStack)this;
        if (stack.contains(MCWComponents.TRAINING_WEAPON_COMPONENT)) return true;
        if (stack.isIn(MCWRegistry.TRAINING_WEAPONS)) return true;
        if (EnchantmentHelper.getLevel(MCWEnchantments.DULLNESS_CURSE, stack) > 0) return true;
        return false;
    }

}
