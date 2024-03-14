package com.sindercube.wood.content.components.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.TooltipAppender;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.dynamic.Codecs;

import java.util.function.Consumer;

public record TrainingWeaponComponent(
        boolean showInTooltip
) implements TooltipAppender {

    public static final Codec<TrainingWeaponComponent> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codecs.createStrictOptionalFieldCodec(Codec.BOOL, "show_in_tooltip", true).forGetter(TrainingWeaponComponent::showInTooltip)
    ).apply(instance, TrainingWeaponComponent::new));
    public static final PacketCodec<ByteBuf, TrainingWeaponComponent> PACKET_CODEC = PacketCodecs.BOOL.xmap(TrainingWeaponComponent::new, TrainingWeaponComponent::showInTooltip);
    private static final Text TOOLTIP_TEXT = Text.translatable("item.training_weapon").formatted(Formatting.BLUE);


    @Override
    public void appendTooltip(Consumer<Text> textConsumer, TooltipContext context) {
        if (this.showInTooltip) textConsumer.accept(TOOLTIP_TEXT);
    }

}
