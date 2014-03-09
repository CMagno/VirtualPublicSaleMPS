package GUI.validations;

public class Doubler implements Validation {

    @Override
    public boolean isValid(String data) {
        try{
            Double.parseDouble(data);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    
}
