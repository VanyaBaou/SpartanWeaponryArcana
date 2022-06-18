package com.vanyabaou.spartanweaponryarcana.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class PacketBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ> {
	@Override
	public REQ onMessage(final REQ message, final MessageContext ctx) {
		IThreadListener mainThread;
		if (ctx.side.isServer()) {
			//mainThread = ctx.getServerHandler().player.getServer();
			EntityPlayerMP player = ctx.getServerHandler().player;
			player.getServer().addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					handleServerSide(message, player);
				}
			});
			
		} else {
			mainThread = Minecraft.getMinecraft();
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					handleClientSide(message, Minecraft.getMinecraft().player);
				}
			});
		}
		return null;
	}

	/**
	 * Handle a packet on the client side. Note this occurs after decoding has completed.
	 * 
	 * @param message
	 * @param player
	 *            Reference to the Player
	 */
	public abstract void handleClientSide(REQ message, EntityPlayer player);

	/**
	 * Handle a packet on the server side. Note this occurs after decoding has completed.
	 * 
	 * @param message
	 * @param player
	 *            Reference to the Player
	 */
	public abstract void handleServerSide(REQ message, EntityPlayerMP player);
}
