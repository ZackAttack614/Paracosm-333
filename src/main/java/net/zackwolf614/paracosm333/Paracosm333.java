package net.zackwolf614.paracosm333;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class Paracosm333 implements ModInitializer {
  public static final Item CRYSTAL_HEART = new Item(new FabricItemSettings().group(ItemGroup.MISC));
  public static final String ModID = "paracosm333";

  public static Identifier id(String path) {
    return new Identifier(ModID, path);
  }

  private static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(
    Registry.DIMENSION_KEY,
    new Identifier(ModID, "paracosm")
  );
  private static RegistryKey<World> WORLD_KEY = RegistryKey.of(
    Registry.WORLD_KEY,
    DIMENSION_KEY.getValue()
  );
  private static final RegistryKey<DimensionType> DIMENSION_TYPE_KEY = RegistryKey.of(
    Registry.DIMENSION_TYPE_KEY,
    new Identifier(ModID, "paracosm_type")
  );


  @Override
  public void onInitialize() {
    WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(ModID, "paracosm"));
    RegistryKey.of(Registry.CHUNK_GENERATOR_KEY, new Identifier(ModID, "paracosm_noise"));
    Registry.register(Registry.ITEM, new Identifier("paracosm333", "crystal_heart"), CRYSTAL_HEART);
    CustomPortalApiRegistry.addPortal(Blocks.LAPIS_BLOCK,
                                      PortalIgnitionSource.ItemUseSource(CRYSTAL_HEART),
                                      new Identifier("paracosm333", "paracosm"),
                                      0, 0, 76);
  }

}
