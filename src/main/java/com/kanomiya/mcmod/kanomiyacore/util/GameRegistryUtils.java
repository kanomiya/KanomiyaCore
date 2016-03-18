package com.kanomiya.mcmod.kanomiyacore.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.kanomiya.mcmod.kanomiyacore.KanomiyaCore;
import com.mojang.realmsclient.util.Pair;

/**
 * ItemModel他の一括登録
 *
 * @author Kanomiya
 *
 */
public class GameRegistryUtils {
	public final KanomiyaCore core;

	public GameRegistryUtils(KanomiyaCore parCore) {
		core = parCore;
	}

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*



	public static final String DEFAULT_INFIX = "_";

	public void registerModel(Item item, String name, String infix, String[] metaNames) {
		String keyName = core.getModid() + ":" + name;

		if (metaNames != null && 0 < metaNames.length) {
			for (int index=0; index<metaNames.length; index++) {
				boolean flag = (metaNames[index] != null && ! metaNames[index].equals(""));

				String key;

				if (! metaNames[index].contains(":")) key = keyName + ((flag) ? infix + metaNames[index] : "");
				else key = metaNames[index];

				ModelResourceLocation location = new ModelResourceLocation(key, "inventory");

				ModelBakery.registerItemVariants(item, new ResourceLocation(key));
				ModelLoader.setCustomModelResourceLocation(item, index, location);

			}
		} else {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(keyName, "inventory"));
		}

	}



	public void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name, String infix, String[] metaNames, boolean registerModel) {
		block.setUnlocalizedName(name);
		GameRegistry.registerBlock(block, itemclass, name);

		if (registerModel) registerModel(Item.getItemFromBlock(block), name, infix, metaNames);

	}


	public void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name, String[] metaNames, boolean registerModel) {
		registerBlock(block, itemclass, name, DEFAULT_INFIX, metaNames, registerModel);
	}

	public void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name, int metaSize, boolean registerModel) {
		registerBlock(block, itemclass, name, DEFAULT_INFIX, new String[metaSize], registerModel);
	}

	public void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name, boolean registerModel) {
		registerBlock(block, itemclass, name, null, null, registerModel);
	}



	public void registerBlock(Block block, String name, String[] metaNames, boolean registerModel) {
		registerBlock(block, ItemBlock.class, name, DEFAULT_INFIX, metaNames, registerModel);
	}

	public void registerBlock(Block block, String name, int metaSize, boolean registerModel) {
		registerBlock(block, ItemBlock.class, name, DEFAULT_INFIX, new String[metaSize], registerModel);
	}

	public void registerBlock(Block block, String name, boolean registerModel) {
		registerBlock(block, ItemBlock.class, name, null, null, registerModel);
	}


	public void registerItem(Item item, String name, String infix, String[] metaNames, boolean registerModel) {
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);

		if (registerModel) registerModel(item, name, infix, metaNames);
	}

	public void registerItem(Item item, String name, String[] metaNames, boolean registerModel) {
		registerItem(item, name, DEFAULT_INFIX, metaNames, registerModel);
	}

	public void registerItem(Item item, String name, boolean registerModel) {
		registerItem(item, name, null, registerModel);
	}


	/**
	 *
	 * Entity登録名のhashcodeからスポーンエッグ色を生成
	 *
	 * @param name Entity Register Name
	 * @return Pair of Primary & Secondary Color
	 */
	public Pair<Integer, Integer> getUniqueEggColor(String name) {
		Random rand = new Random(name.hashCode());
		return Pair.of((rand.nextInt() *0xFFFFFF) &0xFFFFFF, (rand.nextInt() *0xFFFFFF) &0xFFFFFF);
	}


}
