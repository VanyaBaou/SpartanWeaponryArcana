package com.vanyabaou.spartanweaponryarcana.network;

import com.oblivioussp.spartanweaponry.api.IWeaponPropertyContainer;
import com.vanyabaou.spartanweaponryarcana.util.ManaBurstHelper;
import com.vanyabaou.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class PacketManaBurst extends PacketBase<PacketManaBurst>
{
	public PacketManaBurst() {}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
	}

	@Override
	public void handleClientSide(PacketManaBurst message, EntityPlayer player) 
	{
	}

	@Override
	public void handleServerSide(PacketManaBurst message, EntityPlayerMP player)
	{
		ItemStack mainStack;
		
		//Log.info("Received Mana Burst Packet! Processing...");
		
		if(player == null)	return;
		
		mainStack = player.getHeldItem(EnumHand.MAIN_HAND);
		
		if(!mainStack.isEmpty() && mainStack.getItem() instanceof IWeaponPropertyContainer)
		{
			IWeaponPropertyContainer container = ((IWeaponPropertyContainer)mainStack.getItem());
			
			if(container.hasWeaponProperty(WeaponPropertySWA.TerraSlash))
			{
				ManaBurstHelper.trySpawnBurst(player);
				//Log.info("Spawned Mana Burst!");
			}
		}
	}

}
