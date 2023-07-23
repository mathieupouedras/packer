package fr.xspeedlt.optimizer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class PackerTest {

    @Test
   void should_pack_without_optimization() {
        List<Item> items = createItems();
        Packer packer = new Packer();
        List<Package> packages = packer.pack(items);

        assertThat(packages).hasSize(10);

    }

    @Test
    void should_pack_with_optimization() {
        List<Item> items = createItems();
        Packer packer = new Packer();
        List<Package> packages = packer.packBetter(items);

        assertThat(packages).hasSize(8);

    }

    private List<Item> createItems() {
        return "163841689525773".chars()
                .map(Character::getNumericValue)
                .mapToObj(Size::of)
                .map(Item::new)
                .collect(Collectors.toList());
    }
}
