package com.enderzombi102.floraldiversity.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

import java.util.ArrayList;
import java.util.List;

public abstract class PlantBlock extends net.minecraft.block.PlantBlock {

	public PlantBlock() {
		super(
			QuiltBlockSettings.of(Material.PLANT)
				.sounds(BlockSoundGroup.GRASS)
				.breakInstantly()
				.collidable(false)
		);
	}

	@Override
	public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
		List<ItemStack> drops = new ArrayList<>();
		addDrops(drops, state);
		return drops;
	}

	/* API */

	/**
	 * Add drops to this block
	 */
	protected abstract void addDrops(List<ItemStack> drops, BlockState state);

}
