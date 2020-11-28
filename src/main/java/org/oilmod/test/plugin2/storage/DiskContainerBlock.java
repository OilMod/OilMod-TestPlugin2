package org.oilmod.test.plugin2.storage;

import org.oilmod.api.UI.UIMPI;
import org.oilmod.api.blocks.BlockType;
import org.oilmod.api.blocks.OilBlock;
import org.oilmod.api.blocks.type.IBlockComplexStateable;
import org.oilmod.api.rep.block.BlockFaceRep;
import org.oilmod.api.rep.entity.EntityHumanRep;
import org.oilmod.api.rep.entity.EntityPlayerRep;
import org.oilmod.api.rep.providers.BlockStateProvider;
import org.oilmod.api.rep.providers.minecraft.MinecraftBlock;
import org.oilmod.api.rep.world.LocationBlockRep;
import org.oilmod.api.stateable.complex.ComplexStateFactoryStore;
import org.oilmod.api.stateable.complex.IComplexState;
import org.oilmod.api.stateable.enumerable.IEnumerableState;
import org.oilmod.api.util.InteractionResult;
import org.oilmod.test.plugin2.TestPlugin2;

public class DiskContainerBlock extends OilBlock implements IBlockComplexStateable<DiskContainerBlock> {
    private final ComplexStateFactoryStore<DiskContainerBlock> complexStateFactoryStore = new ComplexStateFactoryStore<>(this);

    public DiskContainerBlock() {
        super(MinecraftBlock.FURNACE, "Disk Drive");
        complexStateFactoryStore.registerComplexState(DiskContainerState.class, (testBlock, state) -> TestPlugin2.DiskContainerInventoryType.get().create(), ((testBlock, state) -> true));
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.ROCK.getValue();
    }

    @Override
    public ComplexStateFactoryStore<DiskContainerBlock> getComplexStateFactoryStore() {
        return complexStateFactoryStore;
    }

    @Override
    public InteractionResult onRightClickOnBlock(IEnumerableState enumState, IComplexState complexState, EntityHumanRep human, LocationBlockRep loc, boolean offhand, BlockFaceRep blockFace, float hitX, float hitY, float hitZ) {
        if (human.isSneaking()) {
            human.openInventory(((DiskContainerState)complexState).getInventory());
        } else {
            UIMPI.openUI((EntityPlayerRep) human, DiskContainerUI.INSTANCE.create((DiskContainerState) complexState));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public float getHardness() {
        return 1.5f;
    }


    protected DiskContainerBlock(BlockStateProvider vanillaBlock, String displayName) {
        super(vanillaBlock, displayName);
    }

}
