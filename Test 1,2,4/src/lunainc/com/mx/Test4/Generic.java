package lunainc.com.mx.Test4;

public class Generic<T> {

    private T obj;

    Generic(T o){
        obj = o;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    void showType(){

        String type = obj.getClass().getSimpleName();
        String message;

        if (type.equalsIgnoreCase("String")){
            message = "String: \"Eres una palabra\"";
        }else if(
                type.equalsIgnoreCase("Integer") ||
                type.equalsIgnoreCase("Long")
        ){
            message = "Integer, Long, etc: \"Eres un número\"";
        }else if (
                type.equalsIgnoreCase("List") ||
                type.equalsIgnoreCase("ArrayList")
        ){
            message = "List, ArrayList, etc: \"Eres una lista\"";
        }else{
            message = "Otro: \"Eres otro tipo\"";
        }

        System.out.println(message);
    }

}
