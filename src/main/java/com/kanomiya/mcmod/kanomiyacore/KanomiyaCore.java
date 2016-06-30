package com.kanomiya.mcmod.kanomiyacore;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Modクラス
 *
 * @author Kanomiya [2016]
 *
 */
@Mod(modid = KanomiyaCore.MODID, name = "Kanomiya Core", version = "@VERSION@")
public class KanomiyaCore {

    public static final String MODID = "com.kanomiya.mcmod.kanomiyacore";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

    }

}
