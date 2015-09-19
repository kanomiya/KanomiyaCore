package com.kanomiya.mcmod.kanomiyacore.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 *
 * ダメージ値をmetadataとして返すItemBlock
 *
 * @author Kanomiya
 *
 */
public class ItemBlockDamaged extends ItemBlock {

	/**
	 * @param block
	 */
	public ItemBlockDamaged(Block block) {
		super(block);
	}

	/**
	 * ダメージ値をmetadataとして返す
	 *
	* @inheritDoc
	 */
	@Override public int getMetadata(int damage) {
		return damage;
	}

}
