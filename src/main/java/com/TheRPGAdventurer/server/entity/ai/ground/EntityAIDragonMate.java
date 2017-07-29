package com.TheRPGAdventurer.server.entity.ai.ground;

import java.util.List;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.ai.EntityAIDragonBase;
import com.TheRPGAdventurer.server.entity.helper.EnumDragonLifeStage;

/**
 * Derivative EntityAIMate class to deal with some special values that can't be
 * applied with an extension thanks to the visibility.
 */
public class EntityAIDragonMate extends EntityAIDragonBase {

    private EntityTameableDragon dragonMate;
    private int spawnBabyDelay = 0;
    private double speed;

    public EntityAIDragonMate(EntityTameableDragon dragon, double speed) {
        super(dragon);
        this.speed = speed;
        setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        if (!dragon.isInLove()) {
            return false;
        } else {
            dragonMate = getNearbyMate();
            return dragonMate != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return dragonMate.isEntityAlive() && dragonMate.isInLove() && spawnBabyDelay < 60;
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        dragonMate = null;
        spawnBabyDelay = 0;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        dragon.getLookHelper().setLookPositionWithEntity(dragonMate, 10.0F, (float) dragon.getVerticalFaceSpeed());
        dragon.getNavigator().tryMoveToEntityLiving(dragonMate, speed);
        
        ++spawnBabyDelay;

        if (spawnBabyDelay == 60) {
            spawnBaby();
        }
    }

    /**
     * Loops through nearby animals and finds another animal of the same type
     * that can be mated with. Returns the first valid mate found.
     */
    private EntityTameableDragon getNearbyMate() {
        double followRange = getFollowRange();
        List<EntityTameableDragon> nearbyDragons = world.getEntitiesWithinAABB(
            EntityTameableDragon.class,
            dragon.getEntityBoundingBox().expand(followRange, followRange, followRange)
        );
        
        for (EntityTameableDragon nearbyDragon : nearbyDragons) {
            if (dragon.canMateWith(nearbyDragon)) {
                return nearbyDragon;
            }
        }
        
        return null;
    }

    /**
     * Spawns a baby animal of the same type.
     */
    private void spawnBaby() {
        EntityTameableDragon dragonBaby = (EntityTameableDragon) dragon.createChild(dragonMate);

        if (dragonBaby != null) {
            dragon.setGrowingAge(6000);
            dragonMate.setGrowingAge(6000);
            
            dragon.resetInLove();
            dragonMate.resetInLove();
            
            dragonBaby.setLocationAndAngles(dragon.posX, dragon.posY, dragon.posZ, 0, 0);
            dragonBaby.getLifeStageHelper().setLifeStage(EnumDragonLifeStage.EGG);
            
            world.spawnEntityInWorld(dragonBaby);

            // TODO: particles for the clients?
        }
    }
}
