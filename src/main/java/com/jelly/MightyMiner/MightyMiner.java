package com.jelly.MightyMiner;

import com.jelly.MightyMiner.handlers.KeybindHandler;
import com.jelly.MightyMiner.handlers.MacroHandler;
import com.jelly.MightyMiner.macros.macros.GemstoneMacro;
import com.jelly.MightyMiner.render.BlockRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MightyMiner.MODID, version = MightyMiner.VERSION)
public class MightyMiner {
    public static final String MODID = "mightyminer";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        MinecraftForge.EVENT_BUS.register(new MacroHandler());
        MinecraftForge.EVENT_BUS.register(new KeybindHandler());
        MinecraftForge.EVENT_BUS.register(new GemstoneMacro());
        MinecraftForge.EVENT_BUS.register(new BlockRenderer());
        KeybindHandler.initializeCustomKeybindings();
        MacroHandler.initializeMacro();
    }



}
