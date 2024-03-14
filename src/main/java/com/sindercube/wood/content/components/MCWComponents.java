package com.sindercube.wood.content.components;

import com.sindercube.wood.ModCodenamedWood;
import com.sindercube.wood.content.components.custom.TrainingWeaponComponent;
import net.minecraft.component.DataComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.UnaryOperator;

public class MCWComponents {

    public static final DataComponentType<TrainingWeaponComponent> TRAINING_WEAPON_COMPONENT = register(
            "training_weapon",
            (builder) -> builder.codec(TrainingWeaponComponent.CODEC).packetCodec(TrainingWeaponComponent.PACKET_CODEC)
    );

    public static void init() {}

    private static <T> DataComponentType<T> register(String id, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(
                Registries.DATA_COMPONENT_TYPE,
                ModCodenamedWood.of(id),
                builderOperator.apply(DataComponentType.builder()).build()
        );
    }

}
