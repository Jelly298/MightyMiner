package com.jelly.MightyMiner.handlers;

import com.jelly.MightyMiner.baritone.Baritone;
import com.jelly.MightyMiner.baritone.baritones.WalkBaritone;
import com.jelly.MightyMiner.macros.Macro;
import com.jelly.MightyMiner.macros.macros.GemstoneMacro;
import com.jelly.MightyMiner.utils.AngleUtils;
import com.jelly.MightyMiner.utils.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class MacroHandler {
    public static List<Macro> macros = new ArrayList<>();
    public static Minecraft mc = Minecraft.getMinecraft();

    static boolean enabled = false;

    public static void initializeMacro(){
       macros.add(new GemstoneMacro());
    }

    @SubscribeEvent
    public void onTickPlayer(TickEvent.ClientTickEvent tickEvent) {
        if (!enabled || mc.thePlayer == null || mc.theWorld == null)
            return;

        for (Macro process : macros) {
            if (process.isEnabled()) {
                process.onTick(tickEvent.phase);
            }
        }
    }

    @SubscribeEvent
    public void onRenderWorld(final RenderWorldLastEvent event) {
        if (!enabled || mc.thePlayer == null || mc.theWorld == null)
            return;

        for (Macro process : macros) {
            if (process.isEnabled()) {
                process.onLastRender();
            }
        }
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        if (!enabled || mc.thePlayer == null || mc.theWorld == null)
            return;

        for (Macro process : macros) {
            if (process.isEnabled()) {
                process.onOverlayRenderEvent(event);
            }
        }
    }


    public static void startScript(Macro macro){
        if(!macro.isEnabled()) {
            LogUtils.addMessage("enabled script");
            macro.toggle();
            enabled = true;
        }
    }
    public static void startScript(int index){
        startScript(macros.get(index));
    }

    public static void disableScript() {

       boolean flag = false;
       for(Macro macro : macros){
           if(macro.isEnabled()) {
               macro.toggle();
               flag = true;
           }
       }

       enabled = false;
       if(flag)
           LogUtils.addMessage("disabled script");

    }




}
