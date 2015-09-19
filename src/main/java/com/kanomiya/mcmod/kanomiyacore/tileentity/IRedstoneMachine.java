package com.kanomiya.mcmod.kanomiyacore.tileentity;

/**
 * レッドストーン機械用のインターフェース
 *
 * @author Kanomiya
 *
 */
public interface IRedstoneMachine {

	public boolean isPrevPowered();
	public void setPrevRSState(boolean powered);

}
