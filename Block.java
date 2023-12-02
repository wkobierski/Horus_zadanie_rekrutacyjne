public class Block implements BlockStructure{
    protected String color;
    protected String material;

    public Block(String inputColor, String inputMaterial){
        color = inputColor;
        material = inputMaterial;
    }

    public String getColor(){
        return color;
    }

    public String getMaterial(){
        return material;
    }
}
