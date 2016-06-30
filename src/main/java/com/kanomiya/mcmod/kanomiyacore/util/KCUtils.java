package com.kanomiya.mcmod.kanomiyacore.util;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KCUtils
{
    @SideOnly(Side.CLIENT)
    public static class Client
    {

        public static final Consumer<Item> simpleRegister = (item) -> ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

        public static final BiConsumer<Item, Integer> metaRegister = new BiConsumer<Item, Integer>()
        {
            @Override
            public void accept(Item item, Integer maxMeta)
            {
                for (int i=0; i<=maxMeta; ++i)
                {
                    ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), item.getRegistryName().getResourcePath()), "inventory"));
                }
            }
        };

        public static final BiConsumer<Item, String[]> arrayRegister = new BiConsumer<Item, String[]>()
        {
            @Override
            public void accept(Item item, String[] stringAry)
            {
                for (int i=0; i<stringAry.length; ++i)
                {
                    ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), item.getRegistryName().getResourcePath() + (stringAry[i].equals("") ? "" : "_" + stringAry[i].toLowerCase())), "inventory"));
                }
            }
        };

        public static final BiConsumer<Item, Enum[]> enumRegister = new BiConsumer<Item, Enum[]>()
        {
            @Override
            public void accept(Item item, Enum[] enumAry)
            {
                for (int i=0; i<enumAry.length; ++i)
                {
                    ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), item.getRegistryName().getResourcePath() + "_" + enumAry[i].name().toLowerCase()), "inventory"));
                }
            }
        };

    }
}
