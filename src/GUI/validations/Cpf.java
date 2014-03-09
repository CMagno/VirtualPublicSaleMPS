package GUI.validations;

public class Cpf implements Validation{

    @Override
    public boolean isValid(String data) {
        // digitos de 0 a 9
        //3 digitos 'ponto' 3 digitos 'ponto' 3 digitos 'traco' 2 digitos 
       
        return data.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
    }
    
}