package com.sindercube.wood.content.components.custom;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

public record DurabilityComponent(
        Integer durability
) {

    public static final DurabilityComponent DEFAULT = new DurabilityComponent(0);

    public static final Codec<DurabilityComponent> CODEC = Codec.INT.xmap(
            DurabilityComponent::new, DurabilityComponent::durability
    );

    public static final PacketCodec<ByteBuf, DurabilityComponent> PACKET_CODEC = PacketCodecs.VAR_INT.xmap(
            DurabilityComponent::new, DurabilityComponent::durability
    );
    
}
