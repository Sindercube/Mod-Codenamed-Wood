package com.sindercube.wood;

import com.sindercube.wood.content.MCWRegistry;
import net.fabricmc.api.ModInitializer;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModCodenamedWood implements ModInitializer {

	public static final String MOD_ID = "mod_codenamed_wood";
    public static final Logger LOGGER = LoggerFactory.getLogger("Mod Codenamed Wood");

	public static Identifier of(String path) {
		return new Identifier(MOD_ID, path);
	}


	@Override
	public void onInitialize() {
		MCWRegistry.init();
	}

}