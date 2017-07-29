package com.TheRPGAdventurer.server.entity.helper;

import com.TheRPGAdventurer.util.math.Interpolation;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.MathHelper;

/**
 * Enum for dragon life stages. Used as aliases for the age value of dragons.
 */
public enum EnumDragonLifeStage implements IStringSerializable {
    
    EGG(0.25f),
    HATCHLING(0.33f),
    JUVENILE(0.66f),
    ADULT(1);
    
    public static final int TICKS_PER_STAGE = 24000;
    public static final EnumDragonLifeStage[] VALUES = values(); // cached for speed
    
    public static EnumDragonLifeStage fromTickCount(int ticksSinceCreation) {
        return VALUES[clampTickCount(ticksSinceCreation) / TICKS_PER_STAGE];
    }
    
    public static float progressFromTickCount(int ticksSinceCreation) {
        EnumDragonLifeStage lifeStage = fromTickCount(ticksSinceCreation);
        int lifeStageTicks = ticksSinceCreation - lifeStage.startTicks();
        return lifeStageTicks / (float) TICKS_PER_STAGE;
    }
    
    public static float scaleFromTickCount(int ticksSinceCreation) {
        EnumDragonLifeStage lifeStage = fromTickCount(ticksSinceCreation);
        
        // constant size for egg and adult stage
        if (lifeStage == EGG || lifeStage == ADULT) {
            return lifeStage.scale;
        }
        
        // interpolated size between current and next stage
        return Interpolation.linear(lifeStage.scale, lifeStage.next().scale,
                progressFromTickCount(ticksSinceCreation));
    }

    public static int clampTickCount(int ticksSinceCreation) {
        return MathHelper.clamp_int(ticksSinceCreation, 0, VALUES.length * TICKS_PER_STAGE);
    }
    
    public final float scale;
    
    EnumDragonLifeStage(float scale) {
        this.scale = scale;
    }
    
    public int startTicks() {
        return ordinal() * TICKS_PER_STAGE;
    }
    
    public EnumDragonLifeStage next() {
        return this == ADULT ? null : VALUES[ordinal() + 1];
    }

	@Override
	public String getName() {
		return null;
	}
}
