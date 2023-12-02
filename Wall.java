import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> inputBlocks) {
        blocks = inputBlocks;
    }

    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equalsIgnoreCase(color))
                return Optional.of(block);
        }
        return Optional.empty();
    }


    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksOfMaterial = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equalsIgnoreCase(material)) {
                blocksOfMaterial.add(block);
            }
        }

        return blocksOfMaterial;
    }


    public int count() {
        int numberOfBlocks = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock){
                numberOfBlocks += ((CompositeBlock) (block)).getBlocks().size();
            } else {
                numberOfBlocks += 1;
            }
        }
        return numberOfBlocks;
    }
}

interface BlockStructure {
    String getColor();
    String getMaterial();
}

interface CompositeBlockStructure extends BlockStructure {
    List<Block> getBlocks();
}