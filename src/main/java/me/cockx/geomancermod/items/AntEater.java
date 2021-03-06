package me.cockx.geomancermod.items;

import me.cockx.geomancermod.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class AntEater extends ItemBase{
    public AntEater(String name) {
        super(name);

    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {
        if(!worldIn.isRemote){
            ItemStack stackInSlot = playerIn.inventory.getStackInSlot(0);
            playerIn.sendMessage(new TextComponentString("Display name: "+stackInSlot.getDisplayName()));
            playerIn.sendMessage(new TextComponentString(""+stackInSlot.getUnlocalizedName()));
            playerIn.sendMessage(new TextComponentString("Amount: "+stackInSlot.getCount()));
            playerIn.sendMessage(new TextComponentString("Metadata: "+stackInSlot.getMetadata()));

            if (playerIn.isSneaking()){
                playerIn.inventory.clear();
                playerIn.inventory.addItemStackToInventory(new ItemStack(ModItems.ANTEATER,1));
            }
        }
        playerIn.playSound(SoundEvents.UI_TOAST_IN,1f,1f);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if(!worldIn.isRemote){
            entityLiving.sendMessage(new TextComponentString("Broke: "+state.getBlock().getLocalizedName()));
            entityLiving.sendMessage(new TextComponentString(state.getBlock().getUnlocalizedName()));
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
