package com.sindercube.wood.content.items.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SickleItem extends ToolItem {

    public SickleItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (player.isCreative()) return false;

        Block block = state.getBlock();
        if (block instanceof CropBlock crop) return crop.isMature(state);
        if (block instanceof SugarCaneBlock sugarCane) return world.getBlockState(pos.down()).isOf(sugarCane);

        // if for some reason netherite sickles exist, they can replant nether wart
        if (this.getMaterial() != ToolMaterials.NETHERITE) return true;
        if (block instanceof NetherWartBlock) return state.get(NetherWartBlock.AGE) == 3;

        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        replantCrop(world, state, pos);
        return super.postMine(stack, world, state, pos, miner);
    }

    public void replantCrop(World world, BlockState state, BlockPos pos) {
        Block block = state.getBlock();
        if (!(block instanceof CropBlock crop)) return;
        if (!crop.isMature(state)) return;
        world.setBlockState(pos, state.with(CropBlock.AGE, 0));
    }

}
