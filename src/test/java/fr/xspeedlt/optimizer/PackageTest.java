import fr.xspeedlt.optimizer.Item;
import fr.xspeedlt.optimizer.Package;
import org.junit.jupiter.api.Test;

import static fr.xspeedlt.optimizer.Size.*;
import static org.assertj.core.api.Assertions.*;

class PackageTest {
    @Test
    void should_add_item() {

        var macbook = new Item(EIGHT);
        Package aPackage = new Package(10);

        aPackage.add(macbook);

        assertThat(aPackage.getCapacity()).isEqualTo(2);
    }

    @Test
    void should_not_add_item_if_remaining_capacity_is_too_small() {

        var macBookAir = new Item(SEVEN);
        var macBookPro = new Item(EIGHT);
        Package aPackage = new Package(10);

        aPackage.add(macBookAir);
        aPackage.add(macBookPro);

        assertThat(aPackage.getCapacity()).isEqualTo(3);
    }
}