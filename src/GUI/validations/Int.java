package GUI.validations;

public class Int implements Validation {

    @Override
    public boolean isValid(String data) {
        try{
            Integer.parseInt(data);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
}
