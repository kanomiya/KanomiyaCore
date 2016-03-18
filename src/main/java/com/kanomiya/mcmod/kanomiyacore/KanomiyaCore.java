package com.kanomiya.mcmod.kanomiyacore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;

import com.kanomiya.mcmod.kanomiyacore.util.GameRegistryUtils;

/**
 * 核クラス
 *
 * @author Kanomiya
 *
 */
public class KanomiyaCore {

	/**
	 * Modクラス
	 * @author Kanomiya
	 *
	 */
	@Mod(modid = KanomiyaCoreMod.MODID)
	public static class KanomiyaCoreMod {
		public static final String MODID = "kanomiyacore";

		public static Logger logger;

		@EventHandler
		public void preInit(FMLPreInitializationEvent event) {
			logger = event.getModLog();

		}


	}


	protected final String modid;
	protected final Object mod;

	protected GameRegistryUtils gameregutils;

	/**
	 *
	 * @param parModid Modid
	 * @param parMod Modのインスタンス
	 */
	public KanomiyaCore(String parModid, Object parMod) {
		modid = parModid;
		mod = parMod;
	}

	public GameRegistryUtils getGameRegistryUtils() {
		if (gameregutils == null) gameregutils = new GameRegistryUtils(this);
		return gameregutils;
	}

	public String getModid() { return modid; }
	public Object getModInstance() { return mod; }


}




