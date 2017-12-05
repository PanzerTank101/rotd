/*
 ** 2012 August 27
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.TheRPGAdventurer.ROTD.client;

import com.TheRPGAdventurer.ROTD.RealmOfTheDragons;
import com.TheRPGAdventurer.ROTD.client.gui.GuiDragonDebug;
import com.TheRPGAdventurer.ROTD.client.init.ModArmour;
import com.TheRPGAdventurer.ROTD.client.init.ModBlocks;
import com.TheRPGAdventurer.ROTD.client.init.ModItems;
import com.TheRPGAdventurer.ROTD.client.init.ModTools;
import com.TheRPGAdventurer.ROTD.client.render.DragonRenderer;
import com.TheRPGAdventurer.ROTD.server.CommonProxy;
import com.TheRPGAdventurer.ROTD.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.ROTD.server.entity.breeds.EnumDragonBreed;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class ClientProxy extends CommonProxy {
    

    @Override
    public void PreInitialization(FMLPreInitializationEvent event) {
        super.PreInitialization(event);        
        // register dragon entity renderer
        RenderingRegistry.registerEntityRenderingHandler(EntityTameableDragon.class, DragonRenderer::new);
      
    }

    @Override
    public void Initialization(FMLInitializationEvent evt) {
        super.Initialization(evt);
    }

    @Override
    public void PostInitialization(FMLPostInitializationEvent event) {
        super.PostInitialization(event);
        
        if (RealmOfTheDragons.instance.getConfig().isDebug()) {
            MinecraftForge.EVENT_BUS.register(new GuiDragonDebug());
        }
    }
}
