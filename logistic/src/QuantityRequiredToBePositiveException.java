public class QuantityRequiredToBePositiveException extends Exception{

    //MISSION rappresenta la necessita che la merce abbia quantita > 0
    QuantityRequiredToBePositiveException (String msg){
        super(msg);
    }
}
