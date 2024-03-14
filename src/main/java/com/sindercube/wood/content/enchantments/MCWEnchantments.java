package com.sindercube.wood.content.enchantments;

import com.sindercube.wood.ModCodenamedWood;
import com.sindercube.wood.content.enchantments.custom.AttackSpeedEnchantment;
import com.sindercube.wood.content.enchantments.custom.DullnessCurseEnchantment;
import com.sindercube.wood.content.enchantments.custom.ReflectEnchantment;
import com.sindercube.wood.content.enchantments.custom.SlowAttackCurseEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MCWEnchantments {

    public static final Enchantment DULLNESS_CURSE = register(
            "dullness_curse",
            new DullnessCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values())
    );

    public static final Enchantment FLURRY_ENCHANTMENT = register(
            "flurry",
            new AttackSpeedEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values())
    );

    public static final Enchantment REFLECT_ENCHANTMENT = register(
            "reflect",
            new ReflectEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values())
    );

    public static final Enchantment SLOW_ATTACK_CURSE = register(
            "slow_attack_curse",
            new SlowAttackCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values())
    );

    public static void init() {}

    public static Enchantment register(String id, Enchantment enchant) {
        return Registry.register(
                Registries.ENCHANTMENT,
                ModCodenamedWood.of(id),
                enchant
        );
    }

}
