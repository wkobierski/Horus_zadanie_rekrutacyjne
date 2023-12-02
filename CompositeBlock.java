import java.util.List;

public class CompositeBlock extends Block{
    private List<Block> blocksIncluded;

    public CompositeBlock (List<Block> inputBlocksIncluded){
        super("Multiple colors", "Multiple materials");
        blocksIncluded = inputBlocksIncluded;
    }

    public List<Block> getBlocks(){
        return blocksIncluded;
    }

}
