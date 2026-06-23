public class Valvetrain {
    private String partName;
    private int valveCount;
    private boolean isTitanium;

    Valvetrain (String partName, int valveCount, boolean isTitanium){
        this.partName = partName;
        this.valveCount = valveCount;
        this.isTitanium = isTitanium;
    }

    public String getPartName(){
        return partName;
    }

    public int getValveCount (){
        return valveCount;
    }

    public boolean getIsTitanium(){
        return isTitanium;
    }
}


