package com.vanyabaou.spartanweaponryarcana.util;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.Loader;

public class ConditionFactoryModId implements IConditionFactory
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		String modId = json.get("mod").getAsString();
		boolean result = Loader.isModLoaded(modId);
		return () -> result;
	}

}
