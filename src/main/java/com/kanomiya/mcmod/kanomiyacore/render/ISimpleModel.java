package com.kanomiya.mcmod.kanomiyacore.render;

import net.minecraft.client.model.ModelBase;

/**
 *
 * サイズ比のみを指定するシンプルなモデル
 *
 * @author Kanomiya
 *
 */
public abstract class ISimpleModel extends ModelBase {

	/**
	 * 描画メソッド
	 * @param f サイズ比
	 */
	public abstract void renderModel(float f);

}
