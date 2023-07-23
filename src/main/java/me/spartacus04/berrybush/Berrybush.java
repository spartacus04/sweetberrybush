package me.spartacus04.berrybush;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("berrybush")
public class Berrybush {

    public Berrybush() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
