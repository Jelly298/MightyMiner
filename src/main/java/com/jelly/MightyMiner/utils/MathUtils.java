package com.jelly.MightyMiner.utils;

import net.minecraft.block.BlockSlab;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class MathUtils {


    public static double getDistanceBetweenTwoBlock(BlockPos b1, BlockPos b2){
        return Math.sqrt((b1.getX() - b2.getX()) * (b1.getX() - b2.getX())
                + (b1.getY() - b2.getY()) * (b1.getY() - b2.getY())
                + (b1.getZ() - b2.getZ()) * (b1.getZ() - b2.getZ()));
    }
    public static int getBlockDistanceBetweenTwoBlock(BlockPos b1, BlockPos b2){
        return Math.abs(b1.getX() - b2.getX())
                + Math.abs((b1.getY() - b2.getY()))
                + Math.abs((b1.getZ() - b2.getZ()));
    }
    public static double getHeuristicCostBetweenTwoBlock(BlockPos b1, BlockPos b2){
        return  (Math.sqrt(
                square(b1.getX() - b2.getX()) * 0.5d
                + square( b1.getY() - b2.getY()) * (Minecraft.getMinecraft().theWorld.getBlockState(b1) instanceof BlockSlab ? 0.5 : 2) * (Minecraft.getMinecraft().theWorld.getBlockState(b2) instanceof BlockSlab ? 0.5 : 2)
                + square(b1.getZ() - b2.getZ()) * 0.5d));
    }
    public static double square(double d){
        return d * d;
    }




}
