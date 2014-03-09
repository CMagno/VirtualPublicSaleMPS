package GUI.validations;

public class Name implements Validation{

    @Override
    public boolean isValid(String data) {
        // nome max 300
        boolean condition1 = (data.length() > 300)    ? false : true;
        // nome min 5
        boolean condition2 = (data.length() <   5)    ? false : true; 
        // nome nao contem numero
        boolean condition3 = (data.matches(".*\\d+.*")) ? false : true; 
        
        
        
        return (condition1 && condition2 && condition3);
    }
    
}
