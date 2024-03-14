package com.sindercube.wood.mixin;

import com.sindercube.wood.asm.EnchantmentHelperAccess;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Redirect(
            method = "appendAttributeModifierTooltip",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;getAttributeBaseValue(Lnet/minecraft/registry/entry/RegistryEntry;)D"
            ),
            slice = @Slice(
                    from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityType;)F"),
                    to = @At(value = "INVOKE", target = "Lnet/minecraft/entity/attribute/EntityAttributeModifier;operation()Lnet/minecraft/entity/attribute/EntityAttributeModifier$Operation;")
            )
    )
    private double injected(PlayerEntity player, RegistryEntry<EntityAttribute> registryEntry) {
        double attackSpeed = 0;
        ItemStack stack = (ItemStack)(Object)this;

        attackSpeed += player.getAttributeBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED);
        attackSpeed += EnchantmentHelperAccess.getAttackSpeed(stack);
        return attackSpeed;
    }

}
