package com.sindercube.wood.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import com.sindercube.wood.asm.EnchantmentHelperAccess;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
	private boolean injected(Entity target, DamageSource source, float damage, @Local(ordinal = 0) LocalIntRef i) {
		if (!this.getMainHandStack().isTrainingWeapon()) return target.damage(source, damage);

		// increase knockback by 1
		i.set(i.get()+1);

		return true;
	}

	@Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
	private boolean injected(LivingEntity target, DamageSource source, float damage) {
		if (this.getMainHandStack().isTrainingWeapon()) return true;
		return target.damage(source, damage);
	}

//	@Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getKnockback(Lnet/minecraft/entity/LivingEntity;)I", shift = At.Shift.BY, by = -2))
//	private void injected(Entity player, CallbackInfo ci) {
//		ItemStack stack = this.getMainHandStack();
//		if (stack.getItem() instanceof WeaponItem weapon) {
//
//		}
//		doSomething3();
//	}


	/**
	 * @author Sindercube
	 * @reason Enchantments modify cooldown reduction
	 */
	@Overwrite
	public float getAttackCooldownProgressPerTick() {
		double attackSpeed = 0;
		attackSpeed += this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_SPEED);
		attackSpeed += EnchantmentHelperAccess.getAttackSpeed(this.getMainHandStack());
		return (float)(1.0 / attackSpeed * 20.0);
	}

}