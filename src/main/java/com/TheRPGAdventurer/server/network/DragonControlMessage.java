/*
 ** 2014 March 19
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.TheRPGAdventurer.server.network;

import java.util.BitSet;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
 * Dragon control message packet.
 */
public class DragonControlMessage implements IMessage {
    
    private final BitSet bits;
    private int previous;
    
    public DragonControlMessage() {
        bits = new BitSet(Byte.SIZE);
    }
    
    public BitSet getFlags() {
        return bits;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        fromInteger(buf.readUnsignedByte());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(toInteger());
    }
    
    public void fromInteger(int value) {
        int index = 0;
        while (value != 0) {
            if (value % 2 != 0) {
                bits.set(index);
            }
            index++;
            value >>>= 1;
        }
    }
    
    public int toInteger() {
        int value = 0;
        for (int i = 0; i < bits.length(); i++) {
            value += bits.get(i) ? (1 << i) : 0;
        }
        return value;
    }

    public boolean hasChanged() {
        int current = toInteger();
        boolean changed = previous != current;
        previous = current;
        return changed;
    }
}
