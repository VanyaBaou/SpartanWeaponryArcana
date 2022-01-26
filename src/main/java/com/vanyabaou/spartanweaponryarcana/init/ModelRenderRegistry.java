package com.vanyabaou.spartanweaponryarcana.init;

import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.item.ItemMultiSWA;
import com.vanyabaou.spartanweaponryarcana.util.LogHelper;
import com.vanyabaou.spartanweaponryarcana.util.StringHelper;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = SpartanWeaponryArcana.MOD_ID)
public class ModelRenderRegistry 
{
	
	@SubscribeEvent
	public static void registerItemRenders(ModelRegistryEvent ev)
	{
		// Manually register Item Models here
		registerMultiItemRender(ItemRegistrySWA.material);
		
		LogHelper.info("Registered all item renders!");
	}
	
	public static void registerMultiItemRender(ItemMultiSWA item)
	{
		String[] localizedNames = item.getAllUnlocalizedNames();
		if(localizedNames == null)
			return;
		for(int i = 0; i < localizedNames.length; i++)
		{
			String unlocName = localizedNames[i];
			LogHelper.debug("Registering model of item: " + item.getRegistryName().toString() + ":" + i);
			ModelResourceLocation modelLoc = new ModelResourceLocation(SpartanWeaponryArcana.MOD_ID + ":" + StringHelper.stripUnlocalizedName(unlocName), "inventory");
			ModelLoader.setCustomModelResourceLocation(item, i, modelLoc);
		}
	}
}
