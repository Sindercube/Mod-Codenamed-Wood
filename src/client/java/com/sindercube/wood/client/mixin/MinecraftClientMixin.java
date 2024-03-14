package com.sindercube.wood.client.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

//    @Shadow @Nullable public HitResult crosshairTarget;
//
//    @Inject(method = "doAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;"))
//    private void injected(CallbackInfoReturnable<Boolean> cir) {
//        if (crosshairTarget == null) return;
//        if (crosshairTarget.getType() == HitResult.Type.BLOCK) return;
//
//        ClientPlayNetworking.send(Wood.LEFT_CLICK_ITEM_PACKET, PacketByteBufs.empty());
//    }

}
