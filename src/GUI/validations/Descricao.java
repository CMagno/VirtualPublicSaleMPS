package GUI.validations;

public class Descricao implements Validation{

    @Override
    public boolean isValid(String data) { 
        return (data.length() <= 500);
    }
    
}
